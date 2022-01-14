package com.bubbleshooter;

public class Breaker {
    private static final Breaker instance = new Breaker();

    private Breaker() {

    }

    public static Breaker getInstance() {
        return instance;
    }

    public void update(Bubble shootingBubble) {

    }

    public void destroyAll() {

    }
}
