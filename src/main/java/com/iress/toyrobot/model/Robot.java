package com.iress.toyrobot.model;

import java.util.List;

public interface Robot {
    void move(byte[] move);
    void left();
    void right();
    List<String> report();
}
