package com.iress.toyrobot.model;

import com.iress.toyrobot.command.Command;
import com.iress.toyrobot.command.LeftCommand;
import com.iress.toyrobot.command.MoveCommand;
import com.iress.toyrobot.command.PlaceCommand;
import com.iress.toyrobot.command.ReportCommand;
import com.iress.toyrobot.command.RightCommand;
import com.iress.toyrobot.helper.PositionAdder;
import com.iress.toyrobot.helper.MoveGenerator;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ToyRobot {

    private static final int moveUnit = 1;

    private final TableTop tableTop;
    private Direction direction;
    private int[] position;
    private boolean isInitialised;

    public ToyRobot(TableTop tableTop) {
        this.tableTop = tableTop;
    }

    public void receiveCommand(Command command) {
        command.apply(this);
    }

    public void apply(PlaceCommand command) {
        if (checkIsSafe(command.getPosition(), this.tableTop.getLowerLimit(), this.tableTop.getUpperLimit())) {
            this.direction = command.getDirection();
            this.position = command.getPosition();
            this.isInitialised = true;
        }
    }

    public void apply(MoveCommand command) {
        if (isInitialised) {
            int[] addMove = MoveGenerator.generateMove(this.direction, moveUnit);
            int[] newPosition = PositionAdder.addPositions(position, addMove);
            if (checkIsSafe(newPosition, this.tableTop.getLowerLimit(), this.tableTop.getUpperLimit())) {
                this.position = newPosition;
            }
        }
    }

    public void apply(LeftCommand command) {
        if (isInitialised) {
            this.direction = direction.left();
        }
    }

    public void apply(RightCommand command) {
        if (isInitialised) {
            this.direction = direction.right();
        }
    }

    public void apply(ReportCommand command) {
        if (isInitialised) {
            log.info(String.format("Robot is currently at %s,%s,%s",
                    this.position[0], this.position[1], this.direction));
        }
    }

    private boolean checkIsSafe(int[] position, int[] lower, int[] upper) {
        return lower[0] <= position[0] && position[0] <= upper[0]
                && lower[1] <= position[1] && position[1] <= upper[1];
    }
}
