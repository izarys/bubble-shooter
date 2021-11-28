package com.bubbleshooter;

public class Level {
    private int level;
    private final Graph graph;

    public Level() {
        graph = new Graph();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Graph getGraph() {
        return graph;
    }
}
