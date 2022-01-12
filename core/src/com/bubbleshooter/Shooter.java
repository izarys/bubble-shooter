package com.bubbleshooter;

import java.util.List;

enum State {
    FREE, SHOOTING
};

public class Shooter {
    private float target = 0;
    Bubble bubble;
    State state = State.FREE;
    private float x,y;

    public Shooter() {
        x = GameConstants.BIG_FRAME_X + GameConstants.BIG_FRAME_WIDTH / 2f - 32;
        y = GameConstants.FRAME_Y;
    }

    public void shoot() {
        state = State.SHOOTING;
    }

    public void update() {
        if (state.equals(State.SHOOTING)) {
            x += target;
            y += 10;
        }
        if (collisionDetected()) {

        }
        if (x < 0 || x > 1800 || y > 900) {
            x = GameConstants.BIG_FRAME_X + GameConstants.BIG_FRAME_WIDTH / 2f - 32;
            y = GameConstants.FRAME_Y;
            state = State.FREE;
        }
    }

    private boolean collisionDetected() {
        List<List<Bubble>> graph = Level.getInstance().getGraph();



        return false;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void moveLeft() {
        target--;
    }

    public void moveRight() {
        target++;
    }

    public float getTarget() {
        return target;
    }
}
