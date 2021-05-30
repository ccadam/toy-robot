package com.iress.toyrobot.command;

import com.iress.toyrobot.model.ToyRobot;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NullCommand implements Command {
    @Override
    public void apply(ToyRobot toyRobot) {
        log.info("NullCommand detected, check input if output is not what you expected.");
    }
}
