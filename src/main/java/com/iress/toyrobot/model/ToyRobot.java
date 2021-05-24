package com.iress.toyrobot.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class ToyRobot implements Robot {
    private Direction direction;

    private int[] position = new int[2];

    @Override
    public void move(int[] move) {
        this.position[0] = (byte) (this.position[0] + move[0]);
        this.position[1] = (byte) (this.position[1] + move[1]);
    }

    @Override
    public void left() {
        this.direction = direction.left();
    }

    @Override
    public void right() {
        this.direction = direction.right();
    }

    @Override
    public List<String> report() {
        return Arrays.asList(
                String.valueOf(this.position[0]),
                String.valueOf(this.position[1]),
                this.direction.toString());
    }

}
