package com.bubbleshooter;

public class Player {
    private static final Player instance = new Player();
    private int points = 0;
    private int score = 0;

    private Player() {
    }

    public static Player getInstance() {
        return instance;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int delta) {
        score += delta;
    }
}
