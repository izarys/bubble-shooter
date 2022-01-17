package com.bubbleshooter;

public class BubbleFactory {
    public Bubble getBubble(Position position) {
        int rand = (int) (Math.random() * 100);
        return rand < GameConstants.BOMBS_PERCENTAGE
                ? new BubbleBomb(position)
                : new BubbleNormal(position);
    }
}
