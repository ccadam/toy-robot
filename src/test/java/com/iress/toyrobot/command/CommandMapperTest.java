package com.iress.toyrobot.command;

import org.junit.jupiter.api.Test;

import static com.iress.toyrobot.model.Direction.NORTH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandMapperTest {

    @Test
    void testMapUserInputToCommand_whenUserInputMove_shouldReturnMoveCommand() {
        assertTrue(CommandMapper.mapUserInputToCommand("MOVE") instanceof MoveCommand);
    }

    @Test
    void testMapUserInputToCommand_whenUserInputLeft_shouldReturnLeftCommand() {
        assertTrue(CommandMapper.mapUserInputToCommand("LEFT") instanceof LeftCommand);
    }

    @Test
    void testMapUserInputToCommand_whenUserInputRight_shouldReturnRightCommand() {
        assertTrue(CommandMapper.mapUserInputToCommand("RIGHT") instanceof RightCommand);
    }

    @Test
    void testMapUserInputToCommand_whenUserInputReport_shouldReturnReportCommand() {
        assertTrue(CommandMapper.mapUserInputToCommand("REPORT") instanceof ReportCommand);
    }

    @Test
    void testMapUserInputToCommand_whenUserInputPlaceWithPositionAndDirection_shouldReturnPlaceCommand() {
        Command placeCommand = CommandMapper.mapUserInputToCommand("PLACE 0,0,NORTH");
        assertTrue(placeCommand instanceof PlaceCommand);
        assertEquals(0, ((PlaceCommand) placeCommand).getPosition()[0]);
        assertEquals(0, ((PlaceCommand) placeCommand).getPosition()[1]);
        assertEquals(NORTH, ((PlaceCommand) placeCommand).getDirection());
    }

    @Test
    void testMapUserInputToCommand_whenUserInputInvalidPosition_shouldReturnNullCommand() {
        assertTrue(CommandMapper.mapUserInputToCommand("PLACE A,A,NORTH") instanceof NullCommand);
    }

    @Test
    void testMapUserInputToCommand_whenUserInputInvalidDirection_shouldReturnNullCommand() {
        assertTrue(CommandMapper.mapUserInputToCommand("PLACE 0,0,CENTER") instanceof NullCommand);
    }

    @Test
    void testMapUserInputToCommand_whenUserInputUnknown_shouldReturnNullCommand() {
        assertTrue(CommandMapper.mapUserInputToCommand("NOTVALID") instanceof NullCommand);
    }

    @Test
    void testMapUserInputToCommand_whenUserInputLowerCase_shouldReturnNullCommand() {
        assertTrue(CommandMapper.mapUserInputToCommand("move") instanceof NullCommand);
    }
}
