package com.iress.toyrobot.model;

import java.util.Arrays;
import java.util.List;

public class ToyRobot implements Robot {
    private Direction direction;

    private byte[] position = new byte[2];

    @Override
    public void move(byte[] move) {
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
