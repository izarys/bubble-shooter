package com.bubbleshooter;

enum State {
    FREE, SHOOTING
};

public class Shooter {
    private int untilNextRow;
    private int angle;
    private Bubble bubble;
    private State state;
    private Position position = new Position(GameConstants.BIG_FRAME_X + GameConstants.BIG_FRAME_WIDTH / 2f - GameConstants.BUBBLE_SIZE / 2f, GameConstants.FRAME_Y);;

    public Shooter() {
        untilNextRow = GameConstants.UNTIL_NEXT_ROW;
        angle = 90;
        state = State.FREE;
        bubble = new BubbleFactory().getBubble(position);
    }

    private void generateBubble() {
        angle = 90;
        position = new Position(GameConstants.BIG_FRAME_X + GameConstants.BIG_FRAME_WIDTH / 2f - GameConstants.BUBBLE_SIZE / 2f, GameConstants.FRAME_Y);
        bubble = Level.getInstance().getQueue().getFront();
        bubble.setPosition(position);
    }

    public Bubble getBubble() {
        return bubble;
    }

    public void shoot() {
        state = State.SHOOTING;
        untilNextRow--;
        if (untilNextRow == 0) {
            Level.getInstance().addRow();
            untilNextRow = GameConstants.UNTIL_NEXT_ROW;
        }
    }

    public void update() {
        if (CollisionDetector.bubblesOverlapping(bubble)
                || CollisionDetector.topFrameCollision(bubble)) {
            state = State.FREE;
            generateBubble();
        }
        else if (CollisionDetector.sideFrameCollision(bubble)) {
            angle = 180 - angle;
        }
        if (state.equals(State.SHOOTING)) {
            position.setX(position.getX() + (float) Math.cos(getAngle())*25);
            position.setY(position.getY() + (float) Math.sin(getAngle())*25);
        }
    }

    public void moveLeft() {
        if (angle < GameConstants.MAX_ANGLE) {
            angle+=4;
        }
    }

    public void moveRight() {
        if (angle > GameConstants.MIN_ANGLE) {
            angle-=4;
        }
    }

    public float getAngle() {
        return (float) Math.toRadians(angle);
    }
}
