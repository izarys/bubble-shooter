package com.bubbleshooter;

import java.util.ArrayList;
import java.util.List;

public class RowGenerator {
    List<List<Bubble>> graph;

    public RowGenerator(List<List<Bubble>> graph) {
        this.graph = graph;
    }

    public void generate() {
        List<Bubble> newRow = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            newRow.add(new BubbleImpl());
        }
        graph.add(newRow);
    }
}
