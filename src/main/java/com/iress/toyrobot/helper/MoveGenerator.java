package com.iress.toyrobot.helper;

import com.iress.toyrobot.model.Direction;

public class MoveGenerator {
    public static int[] generateMove(Direction direction, int unit) {
        switch (direction) {
            case NORTH: return new int[] { 0, unit };
            case EAST: return new int[] { unit, 0 };
            case SOUTH: return new int[] { 0, -unit };
            case WEST: return new int[] { -unit, 0 };
            default: return new int[] { 0, 0 };
        }
    }
}
