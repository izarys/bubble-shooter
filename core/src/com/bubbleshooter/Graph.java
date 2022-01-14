package com.bubbleshooter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graph {
    Map<Bubble, Set<Bubble>> graph;
    RowGenerator rowGenerator;

    public Graph() {
        graph = new HashMap<>();
        rowGenerator = new RowGenerator(graph);

        for (int i = 0; i < 4; i++) {
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
