package com.bubbleshooter;

import java.util.List;

public class CollisionDetector {

    public static boolean sideFrameCollision(Bubble bubble) {
        return bubble.getPosition().getX() < GameConstants.BIG_FRAME_X
                || bubble.getPosition().getX() > GameConstants.BIG_FRAME_WIDTH - GameConstants.BIG_FRAME_X;
    }

    public static boolean topFrameCollision(Bubble bubble) {
        return bubble.getPosition().getY() > GameConstants.FRAME_HEIGHT;
    }

    public static boolean bubbleCollisionDetected(Bubble shootingBubble) {
        List<List<Bubble>> graph = Level.getInstance().getGraph();
        for (List<Bubble> row : graph) {
            for (Bubble bubble : row) {
                if (collision(shootingBubble, bubble)) {
                    if (shootingBubble.getColor().equals(bubble.getColor())) {
                        Breaker.getInstance().update(shootingBubble);
                    }
                    else {
                        row.add(shootingBubble);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean collision(Bubble bubble1, Bubble bubble2) {
        float x1 = bubble1.getPosition().getX();
        float y1 = bubble1.getPosition().getY();
        float x2 = bubble2.getPosition().getX();
        float y2 = bubble2.getPosition().getY();
        int d = GameConstants.BUBBLE_SIZE;

        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) <= d * d;
    }
}
