package com.bubbleshooter;

import java.util.*;

public class Breaker {
    private final SearchStrategy searchStrategy = new BFSStrategy();
    private static final Breaker instance = new Breaker();
    Map<Bubble, Set<Bubble>> graph = Level.getInstance().getGraph();

    private Breaker() {
    }

    public static Breaker getInstance() {
        return instance;
    }

    public void update(Bubble bubble) {
        remove(bubble);
    }

    private void remove(Bubble start) {
        Set<Bubble> toBeRemoved = searchStrategy.search(start);

        for (Bubble bubble : toBeRemoved) {
            for (Bubble neighbour : graph.get(bubble)) {
                graph.get(neighbour).remove(bubble);
            }
            graph.remove(bubble);
            Player.getInstance().increaseScore(GameConstants.POINTS_FOR_ONE_BUBBLE);
        }
    }
}
