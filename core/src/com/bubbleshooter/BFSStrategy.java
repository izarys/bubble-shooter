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
            if (bubble.getColor().equals(Color.BOMB)) {System.out.println("here");
                result.addAll(graph.get(bubble));
            }
            else {
                for (Bubble neighbour : graph.get(bubble)) {
                    if (bubble.shouldFire(neighbour) && !result.contains(neighbour)) {
                        queue.add(neighbour);
                    }
                }
            }
            result.add(bubble);
        }

        return result;
    }
}
