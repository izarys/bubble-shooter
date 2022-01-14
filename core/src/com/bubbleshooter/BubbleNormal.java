package com.bubbleshooter;

public class BubbleNormal implements Bubble {
    private final Color color;
    private Position position;

    BubbleNormal(Position position) {
        color = GameConstants.BUBBLE_COLORS[(int)(Math.random()*100 % GameConstants.NORMAL_COLORS)];
        this.position = position;
    }

    @Override
    public boolean shouldFire(Bubble bubble) {
        return bubble.getColor().equals(color) || bubble.getColor().equals(Color.BOMB);
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
