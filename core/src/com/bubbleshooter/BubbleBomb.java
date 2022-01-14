package com.bubbleshooter;

public class BubbleBomb implements Bubble {
    private Position position;
    private final Color color;

    public BubbleBomb(Position position) {
        this.position = position;
        color = Color.BOMB;
    }

    @Override
    public boolean shouldFire(Bubble bubble) {
        return true;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public void move(float deltaX, float deltaY) {
        position.setX(position.getX() + deltaX);
        position.setY(position.getY() + deltaY);
    }
}
