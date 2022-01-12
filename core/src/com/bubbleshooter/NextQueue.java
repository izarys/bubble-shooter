package com.bubbleshooter;


public class NextQueue {
    Bubble[] queue = new Bubble[3];

    public NextQueue() {
        for (int i = 0; i < 3; i++) {
            queue[i] = generateRandomBubble();
        }
    }

    public Bubble generateRandomBubble() {
        return new BubbleImpl();
    }

    public Bubble[] getQueue() {
        return queue;
    }

    public Bubble getFront() {
        Bubble front = queue[2];
        queue[2] = queue[1];
        queue[1] = queue[0];
        queue[0] = generateRandomBubble();
        return front;
    }

}
