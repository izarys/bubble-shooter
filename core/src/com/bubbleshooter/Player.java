package com.bubbleshooter;

public class Player {
    private static final Player instance = new Player();
    private int points = 0;
    private int level = 1;
    private int highestScore = 0;

    private Player() {}

    public static Player getInstance() {
        return instance;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }
}
