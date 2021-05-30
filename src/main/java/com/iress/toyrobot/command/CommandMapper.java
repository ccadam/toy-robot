package com.iress.toyrobot.command;

import com.iress.toyrobot.model.Direction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandMapper {

    private static final Pattern PLACE_COMMAND_REGEX =  Pattern.compile("PLACE (\\d+),(\\d+),([A-Z]+)$");
    private static final String MOVE = "MOVE";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";
    private static final String REPORT = "REPORT";

    public static Command mapUserInputToCommand(String userInput) {
        switch (userInput) {
            case MOVE:
                return new MoveCommand();
            case LEFT:
                return new LeftCommand();
            case RIGHT:
                return new RightCommand();
            case REPORT:
                return new ReportCommand();
            default:
                Matcher matcher = PLACE_COMMAND_REGEX.matcher(userInput);
                if (matcher.matches()) {
                    return parsePlaceCommand(matcher);
                }
                return new NullCommand();
        }
    }

    private static Command parsePlaceCommand(Matcher matcher) {
        int x = Integer.parseInt(matcher.group(1));
        int y = Integer.parseInt(matcher.group(2));
        Direction direction;

        try {
            direction = Direction.valueOf(matcher.group(3));
        } catch (IllegalArgumentException ex) {
            return new NullCommand();
        }

        return new PlaceCommand(new int[] {x,y}, direction);
    }
}
