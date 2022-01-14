package com.bubbleshooter;

public class TurnRightCommand implements Command {
    @Override
    public void execute() {
        GameLogic.getInstance().getShooter().moveRight();
    }
}
