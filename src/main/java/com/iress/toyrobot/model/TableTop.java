package com.iress.toyrobot.model;

public class TableTop {
    private final int[] dimensions;

    public TableTop(int x, int y) {
        this.dimensions = new int[] { x, y };
    }

    public int[] getLowerLimit() {
        return new int[] { 0, 0 };
    }

    public int[] getUpperLimit() {
        return dimensions;
    }
}
