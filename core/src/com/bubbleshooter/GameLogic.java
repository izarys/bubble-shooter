package com.bubbleshooter;

import java.util.Map;
import java.util.Set;

public class GameLogic {
    private static final GameLogic instance = new GameLogic();
    private int level;
    private final Graph graph;
    private final NextQueue queue;
    private final Shooter shooter;

    private GameLogic() {
        graph = new Graph();
        queue = new NextQueue();
        shooter = new Shooter();
        level = 1;
    }

    public static GameLogic getInstance() {
        return instance;
    }

    public NextQueue getQueue() {
        return queue;
    }

    public int getLevel() {
        return level;
    }

    public void increaseLevel() {
        level++;
    }

    public Shooter getShooter() {
        return shooter;
    }

    public Map<Bubble, Set<Bubble>> getGraph() {
        return graph.getGraph();
    }

    public void addRow() {
        graph.addRow();
    }

    public boolean gameOver() {
        for (Bubble bubble : graph.getGraph().keySet()) {
            if (bubble.getPosition().getY() + GameConstants.BUBBLE_SIZE / 2f <= GameConstants.FRAME_Y) {
                return true;
            }
        }

        return false;
    }
}
