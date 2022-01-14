package com.bubbleshooter;

import java.util.*;

public class RowGenerator {
    Map<Bubble, Set<Bubble>> graph;
    BubbleFactory bubbleFactory = new BubbleFactory();

    public RowGenerator(Map<Bubble, Set<Bubble>> graph) {
        this.graph = graph;
    }

    public void generate() {
        updateHeights();
        // TODO check if not game over
        for (int i = 0; i < 21; i++) {
            Position position = new Position(GameConstants.BIG_FRAME_X + i * GameConstants.BUBBLE_SIZE,
                    GameConstants.FRAME_HEIGHT + GameConstants.FRAME_Y - GameConstants.BUBBLE_SIZE);
            graph.put(bubbleFactory.getBubble(position), new HashSet<Bubble>());
        }
        updateNeighbours();
    }

    private void updateHeights() {
        for (Bubble bubble : graph.keySet()) {
            bubble.move(0, -GameConstants.BUBBLE_SIZE);
        }
    }

    private void updateNeighbours() {
        for (Map.Entry<Bubble, Set<Bubble>> entry : graph.entrySet()) {
            Bubble bubble = entry.getKey();
            Set<Bubble> neighbours = entry.getValue();
            for (Bubble potentialNeighbour : graph.keySet()) {
                if (!bubble.equals(potentialNeighbour)
                        && GameConstants.COLLISION(bubble, potentialNeighbour)) {
                    neighbours.add(potentialNeighbour);
                }
            }
        }
    }
}
