package com.iress.toyrobot.model;

import com.iress.toyrobot.command.Command;
import com.iress.toyrobot.command.LeftCommand;
import com.iress.toyrobot.command.MoveCommand;
import com.iress.toyrobot.command.PlaceCommand;
import com.iress.toyrobot.command.ReportCommand;
import com.iress.toyrobot.command.RightCommand;

public interface Robot {
    void receiveCommand(Command command);
    void apply(PlaceCommand command);
    void apply(MoveCommand command);
    void apply(LeftCommand command);
    void apply(RightCommand command);
    void apply(ReportCommand command);
}
