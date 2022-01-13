package com.bubbleshooter;

public interface Bubble {
    void destroy();
    Color getColor();
    Position getPosition();
    void setPosition(Position position);
    void move(float deltaX, float deltaY);
}
