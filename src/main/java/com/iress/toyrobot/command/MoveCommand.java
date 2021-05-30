package com.iress.toyrobot.command;

import com.iress.toyrobot.model.ToyRobot;

public class MoveCommand implements Command {
    @Override
    public void apply(ToyRobot toyRobot) {
        toyRobot.apply(this);
    }
}
