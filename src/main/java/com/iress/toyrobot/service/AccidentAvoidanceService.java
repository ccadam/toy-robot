package com.iress.toyrobot.service;

import com.iress.toyrobot.model.TableTop;
import com.iress.toyrobot.model.ToyRobot;
import com.iress.toyrobot.util.IntUtil;

public class AccidentAvoidanceService {
    static int[] upper = new int[] { 5, 5 };
    static int[] lower = new int[] { 0, 0 };

    public static boolean isSafeToMove(TableTop tableTop, ToyRobot toyRobot, int[] move) {
        int[] futurePosition = IntUtil.addInt(toyRobot.getPosition(), move);
        return IntUtil.isBetween(futurePosition, lower, upper);
    }
}
