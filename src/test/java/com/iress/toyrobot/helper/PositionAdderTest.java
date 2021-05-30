package com.iress.toyrobot.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionAdderTest {

    @Test
    void testAddPositions_whenCurrentPosIs0And0AndAddMoveIs1And1_shouldReturn1And1() {
        int[] newPos = PositionAdder.addPositions(new int[] {0,0}, new int[] {1,1});
        assertEquals(1, newPos[0]);
        assertEquals(1, newPos[1]);
    }

    @Test
    void testAddPositions_whenCurrentPosIs1And1AndAddMoveIs1AndNegative1_shouldReturn2And0() {
        int[] newPos = PositionAdder.addPositions(new int[] {1,1}, new int[] {1,-1});
        assertEquals(2, newPos[0]);
        assertEquals(0, newPos[1]);
    }

    @Test
    void testAddPositions_whenCurrentPosIs1And1AndAddMoveIsNegative1And1_shouldReturn0And2() {
        int[] newPos = PositionAdder.addPositions(new int[] {1,1}, new int[] {-1,1});
        assertEquals(0, newPos[0]);
        assertEquals(2, newPos[1]);
    }
}
