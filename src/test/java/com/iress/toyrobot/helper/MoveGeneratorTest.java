package com.iress.toyrobot.helper;

import org.junit.jupiter.api.Test;

import static com.iress.toyrobot.model.Direction.EAST;
import static com.iress.toyrobot.model.Direction.NONE;
import static com.iress.toyrobot.model.Direction.NORTH;
import static com.iress.toyrobot.model.Direction.SOUTH;
import static com.iress.toyrobot.model.Direction.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveGeneratorTest {

    @Test
    void testGenerateMove_whenDirectionIsNorth_shouldReturnNewPosition() {
        int[] newPosition = MoveGenerator.generateMove(NORTH, 1);
        assertEquals(0, newPosition[0]);
        assertEquals(1, newPosition[1]);
    }

    @Test
    void testGenerateMove_whenDirectionIsEast_shouldReturnNewPosition() {
        int[] newPosition = MoveGenerator.generateMove(EAST, 1);
        assertEquals(1, newPosition[0]);
        assertEquals(0, newPosition[1]);
    }

    @Test
    void testGenerateMove_whenDirectionIsSouth_shouldReturnNewPosition() {
        int[] newPosition = MoveGenerator.generateMove(SOUTH, 1);
        assertEquals(0, newPosition[0]);
        assertEquals(-1, newPosition[1]);
    }

    @Test
    void testGenerateMove_whenDirectionIsWest_shouldReturnNewPosition() {
        int[] newPosition = MoveGenerator.generateMove(WEST, 1);
        assertEquals(-1, newPosition[0]);
        assertEquals(0, newPosition[1]);
    }

    @Test
    void testGenerateMove_whenDirectionIsNotKnown_shouldReturnDefaultPosition() {
        int[] newPosition = MoveGenerator.generateMove(NONE, 1);
        assertEquals(0, newPosition[0]);
        assertEquals(0, newPosition[1]);
    }
}
