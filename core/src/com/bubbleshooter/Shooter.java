package com.bubbleshooter;

import java.util.List;

enum State {
    FREE, SHOOTING
};

public class Shooter {
    private int angle;
    private Bubble bubble;
    private State state;
    private Position position = new Position(GameConstants.BIG_FRAME_X + GameConstants.BIG_FRAME_WIDTH / 2f - GameConstants.BUBBLE_SIZE / 2f, GameConstants.FRAME_Y);;

    public Shooter() {
        angle = 90;
        state = State.FREE;
        bubble = new BubbleFactory().getBubble(position);
    }

    private void generateBubble() {
        position = new Position(GameConstants.BIG_FRAME_X + GameConstants.BIG_FRAME_WIDTH / 2f - GameConstants.BUBBLE_SIZE / 2f, GameConstants.FRAME_Y);
        bubble = Level.getInstance().getQueue().getFront();
        bubble.setPosition(position);
    }

    public Bubble getBubble() {
        return bubble;
    }

    public void shoot() {
        state = State.SHOOTING;
    }

    public void update() {
        if (collisionDetected()) {

        }
        else if (frameCollisionDetected()) {
            state = State.FREE;
            generateBubble();
        } else if (state.equals(State.SHOOTING)) {
            position.setX(position.getX() + (float) Math.cos(getAngle())*10);
            position.setY(position.getY() + (float) Math.sin(getAngle())*10);
        }
    }

    private boolean frameCollisionDetected() {
        return position.getX() < GameConstants.BIG_FRAME_X
                || position.getX() > GameConstants.BIG_FRAME_WIDTH - GameConstants.BIG_FRAME_X
                || position.getY() > GameConstants.FRAME_HEIGHT;
    }

    private boolean collisionDetected() {
        List<List<Bubble>> graph = Level.getInstance().getGraph();



        return false;
    }

    public void moveLeft() {
        if (angle < GameConstants.MAX_ANGLE) {
            angle++;
        }
    }

    public void moveRight() {
        if (angle > GameConstants.MIN_ANGLE) {
            angle--;
        }
    }

    public float getAngle() {
        return (float) Math.toRadians(angle);
    }
}
