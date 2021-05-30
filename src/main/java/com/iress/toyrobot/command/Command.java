package com.iress.toyrobot.command;

import com.iress.toyrobot.model.ToyRobot;

public interface Command {
    void apply(ToyRobot toyRobot);
}
