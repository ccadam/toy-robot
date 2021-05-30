package com.iress.toyrobot.model;

import com.iress.toyrobot.command.LeftCommand;
import com.iress.toyrobot.command.MoveCommand;
import com.iress.toyrobot.command.PlaceCommand;
import com.iress.toyrobot.command.RightCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.iress.toyrobot.model.Direction.EAST;
import static com.iress.toyrobot.model.Direction.NORTH;
import static com.iress.toyrobot.model.Direction.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ToyRobotTest {

    private ToyRobot toyRobot;

    @BeforeEach
    public void setUp() {
        TableTop tableTop = new TableTop(5, 5);
        toyRobot = new ToyRobot(tableTop);
    }

    @Test
    void testReceiveCommand_whenCommandIsReceived_shouldCallApply() {
        LeftCommand command = mock(LeftCommand.class);
        toyRobot.receiveCommand(command);
        verify(command, times(1)).apply(toyRobot);
    }

    @Test
    void testApply_whenPlaceCommandIsReceived_shouldInitToyRobot() {
        PlaceCommand command = new PlaceCommand(new int[] {0,0}, NORTH);
        toyRobot.apply(command);
        assertTrue(toyRobot.isInitialised());
        assertEquals(NORTH, toyRobot.getDirection());
        assertEquals(0, toyRobot.getPosition()[0]);
        assertEquals(0, toyRobot.getPosition()[1]);
    }

    @Test
    void testApply_whenPlaceCommandIsReceivedButOutOfBound_shouldNotInitToyRobot() {
        PlaceCommand command = new PlaceCommand(new int[] {6,0}, NORTH);
        toyRobot.apply(command);
        assertFalse(toyRobot.isInitialised());
    }

    @Test
    void testApply_whenMoveCommandIsReceived_shouldMoveToyRobot() {
        MoveCommand command = new MoveCommand();
        initToyRobot(toyRobot);
        toyRobot.apply(command);
        assertTrue(toyRobot.isInitialised());
        assertEquals(NORTH, toyRobot.getDirection());
        assertEquals(0, toyRobot.getPosition()[0]);
        assertEquals(1, toyRobot.getPosition()[1]);
    }

    @Test
    void testApply_whenLeftCommandIsReceived_shouldRotateLeft() {
        LeftCommand command = new LeftCommand();
        initToyRobot(toyRobot);
        toyRobot.apply(command);
        assertTrue(toyRobot.isInitialised());
        assertEquals(WEST, toyRobot.getDirection());
        assertEquals(0, toyRobot.getPosition()[0]);
        assertEquals(0, toyRobot.getPosition()[1]);
    }

    @Test
    void testApply_whenRightCommandIsReceived_shouldRotateRight() {
        RightCommand command = new RightCommand();
        initToyRobot(toyRobot);
        toyRobot.apply(command);
        assertTrue(toyRobot.isInitialised());
        assertEquals(EAST, toyRobot.getDirection());
        assertEquals(0, toyRobot.getPosition()[0]);
        assertEquals(0, toyRobot.getPosition()[1]);
    }

    private void initToyRobot(ToyRobot toyRobot) {
        PlaceCommand placeCommand = new PlaceCommand(new int[] {0,0}, NORTH);
        toyRobot.apply(placeCommand);
    }
}
