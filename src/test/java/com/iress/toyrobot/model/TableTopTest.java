package com.iress.toyrobot.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableTopTest {

    private TableTop tableTop;

    @BeforeEach
    public void setUp() {
        tableTop = new TableTop(5, 5);
    }

    @Test
    void testGetLowerLimit_whenCalled_shouldReturnLowerLimit() {
        int[] lowerLimit = tableTop.getLowerLimit();
        assertEquals(0, lowerLimit[0]);
        assertEquals(0, lowerLimit[1]);
    }

    @Test
    void testGetUpperLimit_whenCalled_shouldReturnUpperLimit() {
        int[] lowerLimit = tableTop.getUpperLimit();
        assertEquals(5, lowerLimit[0]);
        assertEquals(5, lowerLimit[1]);
    }
}
