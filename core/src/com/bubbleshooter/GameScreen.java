package com.bubbleshooter;

public class GameScreen {
    ScreenState screenState;

    GameScreen() {
        screenState = new MenuScreenState(this);
    }

    public void setScreenState(ScreenState screenState) {
        this.screenState = screenState;
    }

    public ScreenState getScreenState() {
        return screenState;
    }

    public void show() {
        screenState.show();
    }

    public void render(float delta) {
        screenState.render(delta);
    }

    public void resize(int width, int height) {
        screenState.resize(width, height);
    }

    public void pause() {
        screenState.pause();
    }

    public void resume() {
        screenState.resume();
    }

    public void hide() {
        screenState.hide();
    }

    public void dispose() {
        screenState.dispose();
    }
}
