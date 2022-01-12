package com.bubbleshooter;

public class BubbleFactory {
    public Bubble getBubble(Position position) {
        return new BubbleNormal(position);
    }
}
