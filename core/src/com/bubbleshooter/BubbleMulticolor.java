package com.bubbleshooter;

public class BubbleMulticolor implements Bubble {
    private Position position;
    private final Color color;
    private Color matchingColor;

    public BubbleMulticolor(Position position) {
        this.position = position;
        color = Color.MULTICOLOR;
        matchingColor = Color.MULTICOLOR;
    }

    @Override
    public boolean shouldFire(Bubble bubble) {
        return true;
    }

    public void setMatchingColor(Color matchingColor) {
        this.matchingColor = matchingColor;
    }

    public Color getMatchingColor() {
        return matchingColor;
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
