package com.iress.toyrobot.model;

import org.junit.jupiter.api.Test;

import static com.iress.toyrobot.model.Direction.EAST;
import static com.iress.toyrobot.model.Direction.NONE;
import static com.iress.toyrobot.model.Direction.NORTH;
import static com.iress.toyrobot.model.Direction.SOUTH;
import static com.iress.toyrobot.model.Direction.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {

    @Test
    void testLeft_whenDirectionIsNorth_shouldReturnWest() {
        assertEquals(WEST, NORTH.left());
    }

    @Test
    void testLeft_whenDirectionIsWest_shouldReturnSouth() {
        assertEquals(SOUTH, WEST.left());
    }

    @Test
    void testLeft_whenDirectionIsSouth_shouldReturnEast() {
        assertEquals(EAST, SOUTH.left());
    }

    @Test
    void testLeft_whenDirectionIsEast_shouldReturnNorth() {
        assertEquals(NORTH, EAST.left());
    }

    @Test
    void testLeft_whenDirectionIsNone_shouldReturnNone() {
        assertEquals(NONE, NONE.left());
    }

    @Test
    void testRight_whenDirectionIsNorth_shouldReturnEast() {
        assertEquals(EAST, NORTH.right());
    }

    @Test
    void testRight_whenDirectionIsWest_shouldReturnNorth() {
        assertEquals(NORTH, WEST.right());
    }

    @Test
    void testRight_whenDirectionIsSouth_shouldReturnWest() {
        assertEquals(WEST, SOUTH.right());
    }

    @Test
    void testRight_whenDirectionIsEast_shouldReturnSouth() {
        assertEquals(SOUTH, EAST.right());
    }

    @Test
    void testRight_whenDirectionIsNone_shouldReturnNone() {
        assertEquals(NONE, NONE.right());
    }
}
