package com.bubbleshooter;

import java.util.Map;
import java.util.Set;

public class GameLogic {
    private static final GameLogic instance = new GameLogic();
    private int level;
    private Graph graph;
    private final NextQueue queue;
    private final Shooter shooter;
    private int score;

    private GameLogic() {
        graph = new Graph();
        queue = new NextQueue();
        shooter = new Shooter();
        level = 1;
        score = 0;
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

    public Shooter getShooter() {
        return shooter;
    }

    public Map<Bubble, Set<Bubble>> getGraph() {
        return graph.getGraph();
    }

    public void addRow() {
        graph.addRow();
    }

    public void update() {
        if (graph.getGraph().isEmpty()) {
            level++;
            graph = new Graph();
        }
        shooter.update();
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int delta) {
        score += delta;
    }

    public boolean gameOver() {
        for (Bubble bubble : graph.getGraph().keySet()) {
            if (bubble.getPosition().getY() + GameConstants.BUBBLE_SIZE / 2f <= GameConstants.FRAME_Y + GameConstants.BUBBLE_SIZE) {
                return true;
            }
        }

        return false;
    }
}
