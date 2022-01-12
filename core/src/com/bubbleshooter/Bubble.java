package com.bubbleshooter;

public interface Bubble {
    void destroy();
    Color getColor();
    Position getPosition();
    void move(int deltaX, int deltaY);
}
