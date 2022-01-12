package com.bubbleshooter;


public class NextQueue {
    Bubble[] queue = new Bubble[3];
    BubbleFactory bubbleFactory = new BubbleFactory();

    public NextQueue() {
        for (int i = 0; i < 3; i++) {
            Position position = new Position(1500, 500 - i * 80);
            queue[i] = generateRandomBubble(position);
        }
    }

    public Bubble generateRandomBubble(Position position) {
        return bubbleFactory.getBubble(position);
    }

    public Bubble[] getQueue() {
        return queue;
    }

    public Bubble getFront() {
        Bubble front = queue[2];
        queue[2] = queue[1];
        queue[1] = queue[0];
        queue[0] = generateRandomBubble(new Position(1500, 500));
        return front;
    }

}
