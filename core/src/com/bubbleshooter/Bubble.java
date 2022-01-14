package com.bubbleshooter;

public interface Bubble {
    boolean shouldFire(Bubble bubble);
    Color getColor();
    Position getPosition();
    void setPosition(Position position);
    void move(float deltaX, float deltaY);
}
