package com.iress.toyrobot.model;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction left() {
        switch (this) {
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            case EAST: return NORTH;
            default: return this;
        }
    }

    public Direction right() {
        switch (this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: return this;
        }
    }

    public int[] move() {
        switch (this) {
            case NORTH: return new int[] { 0, 1 };
            case EAST: return new int[] { 1, 0 };
            case SOUTH: return new int[] { 0, -1 };
            case WEST: return new int[] { -1, 0 };
            default: return new int[] { 0, 0 };
        }
    }
}
