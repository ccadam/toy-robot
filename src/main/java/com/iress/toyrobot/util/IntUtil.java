package com.iress.toyrobot.util;

public class IntUtil {

    public static int[] addInt(int[] first, int[] second) {
        return new int[] { first[0] + second[0], first[1] + second[1] };
    }

    public static boolean isBetween(int[] position, int[] lower, int[] upper) {
        return lower[0] <= position[0] && position[0] <= upper[0]
                && lower[1] <= position[1] && position[1] <= upper[1];
    }

}
