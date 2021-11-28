package com.bubbleshooter;

public abstract class BubbleDecorator implements Bubble {
    private Bubble bubble;

    public BubbleDecorator(Bubble bubble) {
    }

    @Override
    public void destroy() {
        bubble.destroy();
    }
}
