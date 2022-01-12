package com.bubbleshooter;

import java.util.ArrayList;
import java.util.List;

public class RowGenerator {
    List<List<Bubble>> graph;
    BubbleFactory bubbleFactory = new BubbleFactory();

    public RowGenerator(List<List<Bubble>> graph) {
        this.graph = graph;
    }

    public void generate() {
        List<Bubble> newRow = new ArrayList<>();
        moveRows();
        for (int i = 0; i < 21; i++) {
            Position position = new Position(GameConstants.BIG_FRAME_X + i * GameConstants.BUBBLE_SIZE,
                    GameConstants.FRAME_HEIGHT + GameConstants.FRAME_Y - GameConstants.BUBBLE_SIZE);
            newRow.add(bubbleFactory.getBubble(position));
        }
        graph.add(newRow);
    }

    private void moveRows() {
        // TODO check if not game over

        for (List<Bubble> row : graph) {
            for (Bubble bubble : row) {
                bubble.move(0, -GameConstants.BUBBLE_SIZE);
            }
        }


    }
}
