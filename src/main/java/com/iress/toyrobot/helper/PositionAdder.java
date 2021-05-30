package com.iress.toyrobot.helper;

public class PositionAdder {

    public static int[] addPositions(int[] currentPos, int[] addMove) {
        if (currentPos.length == 2 && addMove.length == 2) {
            return new int[] { currentPos[0] + addMove[0], currentPos[1] + addMove[1] };
        }
        return currentPos;
    }

}
