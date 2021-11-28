package com.bubbleshooter;

public class BubbleBomb extends BubbleDecorator {
    public BubbleBomb(Bubble bubble) {
        super(bubble);
    }

    @Override
    public void destroy() {
        super.destroy();

    }
}
