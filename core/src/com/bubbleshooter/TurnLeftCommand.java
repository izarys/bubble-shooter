package com.bubbleshooter;

public class TurnLeftCommand implements Command {
    @Override
    public void execute() {
        GameLogic.getInstance().getShooter().moveLeft();
    }
}
