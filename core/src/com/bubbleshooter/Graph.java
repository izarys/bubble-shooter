package com.bubbleshooter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graph {
    private final Map<Bubble, Set<Bubble>> graph;
    private final RowGenerator rowGenerator;

    public Graph() {
        graph = new HashMap<>();
        rowGenerator = new RowGenerator(graph);

        for (int i = 0; i < GameConstants.ROWS; i++) {
            addRow();
        }
    }

    public Map<Bubble, Set<Bubble>> getGraph() {
        return graph;
    }

    public void addRow() {
        rowGenerator.generate();
    }
}
