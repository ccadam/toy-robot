package com.iress.toyrobot.command;

import com.iress.toyrobot.model.Direction;
import com.iress.toyrobot.model.ToyRobot;
import lombok.Getter;

@Getter
public class PlaceCommand implements Command {
    private final Direction direction;
    private final int[] position;

    public PlaceCommand(int[] position, Direction direction) {
        this.direction = direction;
        this.position = position;
    }

    @Override
    public void apply(ToyRobot toyRobot) {
        toyRobot.apply(this);
    }
}
