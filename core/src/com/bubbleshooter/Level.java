package com.bubbleshooter;

import java.util.List;

public class Level {
    private static final Level instance = new Level();
    private int level;
    private final Graph graph;
    private final NextQueue queue;
    private final Shooter shooter;

    private Level() {
        graph = new Graph();
        queue = new NextQueue();
        shooter = new Shooter();
        level = 1;
    }

    public static Level getInstance() {
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

    public List<List<Bubble>> getGraph() {
        return graph.getGraph();
    }
}
