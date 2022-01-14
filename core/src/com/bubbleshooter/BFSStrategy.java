package com.bubbleshooter;

import java.util.*;

public class BFSStrategy implements SearchStrategy {
    @Override
    public Set<Bubble> search(Bubble start) {
        Map<Bubble, Set<Bubble>> graph = Level.getInstance().getGraph();
        Set<Bubble> result = new HashSet<>();

        Queue<Bubble> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Bubble bubble = queue.poll();
            for (Bubble neighbour : graph.get(bubble)) {
                if (neighbour.getColor().equals(bubble.getColor())
                        && !result.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
            result.add(bubble);
        }

        return result;
    }
}
