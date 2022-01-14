package com.bubbleshooter;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class GameScreen {
    private final InputListener inputListener = new InputListener() {
        @Override
        public boolean keyUp(InputEvent event, int keycode) {
            screenState.actOnKeyUp(keycode);
            return true;
        }
    };
    private final ScreenState menuScreenState = new MenuScreenState(this);
    private final ScreenState settingsScreenState = new SettingsScreenState(this);
    private final ScreenState gameScreenState = new GameScreenState(this);
    private ScreenState screenState;

    GameScreen() {
        screenState = menuScreenState;
    }

    public InputListener getInputListener() {
        return inputListener;
    }

    public ScreenState getMenuScreenState() {
        return menuScreenState;
    }

    public ScreenState getSettingsScreenState() {
        return settingsScreenState;
    }

    public GameScreenState getGameScreenState() {
        return (GameScreenState) gameScreenState;
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
