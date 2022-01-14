package com.bubbleshooter;


public class NextQueue {
    private final int size = 3;
    Bubble[] queue = new Bubble[size];
    BubbleFactory bubbleFactory = new BubbleFactory();

    public NextQueue() {
        for (int i = 0; i < size; i++) {
            Position position = new Position(GameConstants.SMALL_FRAME_X + GameConstants.SMALL_FRAME_WIDTH / 2f - GameConstants.BUBBLE_SIZE / 2f,
                    GameConstants.SCREEN_HEIGHT / 2f - i * GameConstants.QUEUE_BUBBLE_DIST);
            queue[i] = generateRandomBubble(position);
        }
    }

    public Bubble generateRandomBubble(Position position) {
        return bubbleFactory.getBubble(position);
    }

    public Bubble[] getQueue() {
        return queue;
    }

    private void moveBubbles() {
        for (int i = 1; i < size; i++) {
            Bubble bubble = queue[i];
            bubble.move(0, -GameConstants.QUEUE_BUBBLE_DIST);
        }
    }

    public Bubble getFront() {
        Bubble front = queue[2];
        queue[2] = queue[1];
        queue[1] = queue[0];
        queue[0] = generateRandomBubble(new Position(GameConstants.SMALL_FRAME_X + GameConstants.SMALL_FRAME_WIDTH / 2f - GameConstants.BUBBLE_SIZE / 2f,
                GameConstants.SCREEN_HEIGHT / 2f));
        moveBubbles();
        return front;
    }

}
