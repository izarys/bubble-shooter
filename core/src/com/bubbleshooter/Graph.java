package com.bubbleshooter;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<List<Bubble>> graph;
    RowGenerator rowGenerator;

    public Graph() {
        graph = new ArrayList<>();
        rowGenerator = new RowGenerator(graph);

        for (int i = 0; i < 4; i++) {
            rowGenerator.generate();
        }
    }

    public List<List<Bubble>> getGraph() {
        return graph;
    }
}
