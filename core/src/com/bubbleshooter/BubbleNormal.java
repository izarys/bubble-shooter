package com.bubbleshooter;

public class BubbleNormal implements Bubble {
    private final Color color;
    private final Position position;

    BubbleNormal(Position position) {
        color = GameConstants.BUBBLE_COLORS[(int)(Math.random()*100 % GameConstants.NORMAL_COLORS)];
        this.position = position;
    }

    @Override
    public void destroy() {

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
    public void move(int deltaX, int deltaY) {
        position.setX(position.getX() + deltaX);
        position.setY(position.getY() + deltaY);
    }
}
