package com.bubbleshooter;

public class GameScreenState implements ScreenState {
    GameScreen gameScreen;
    GameScreenState(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();

        batch.draw(GameConstants.BACKGROUND, 0,0);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
