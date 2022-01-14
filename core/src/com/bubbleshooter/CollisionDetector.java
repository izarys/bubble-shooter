package com.bubbleshooter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollisionDetector {

    public static boolean sideFrameCollision(Bubble bubble) {
        return bubble.getPosition().getX() < GameConstants.BIG_FRAME_X
                || bubble.getPosition().getX() > GameConstants.BIG_FRAME_WIDTH - GameConstants.BIG_FRAME_X;
    }

    public static boolean topFrameCollision(Bubble bubble) {
        return bubble.getPosition().getY() > GameConstants.FRAME_HEIGHT;
    }

    public static boolean bubblesOverlapping(Bubble shootingBubble) {
        Map<Bubble, Set<Bubble>> graph = Level.getInstance().getGraph();
        for (Bubble bubble : graph.keySet()) {
            if (GameConstants.COLLISION(shootingBubble, bubble)) {
                if (shootingBubble.getColor().equals(bubble.getColor())) {
                    Breaker.getInstance().update(bubble);
                } else {
                    graph.put(shootingBubble, new HashSet<Bubble>());
                }
                return true;
            }
        }
        return false;
    }
}
