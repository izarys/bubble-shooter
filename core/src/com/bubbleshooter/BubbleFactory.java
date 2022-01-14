package com.bubbleshooter;

public class BubbleFactory {
    public Bubble getBubble(Position position) {
        int rand = (int) (Math.random() * 100);
        return rand > 6
                ? new BubbleNormal(position)
                : new BubbleBomb(position);
    }
}
