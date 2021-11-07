package com.bubbleshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;


public class MenuScreenState implements ScreenState {
    GameScreen gameScreen;
    // buttons
    Button newGameButton;
    Button settingsButton;
    Button exitButton;
    Button[] buttons;
    int buttonsIdx;

    // stage
    Stage stage;

    MenuScreenState(GameScreen gameScreen) {
        this.gameScreen = gameScreen;

        stage = new Stage(viewport);

        setupButtons();
        setupInputListener();

        buttonsIdx = 0;

    }

    private void setupButtons() {
        Gdx.input.setInputProcessor(stage);

        newGameButton = new Button(GameConstants.NEW_GAME_OFF_STYLE);
        settingsButton = new Button(GameConstants.SETTINGS_STYLE);
        exitButton = new Button(GameConstants.EXIT_STYLE);
        buttons = new Button[] {newGameButton, settingsButton, exitButton};

        newGameButton.setSize(GameConstants.BUTTON_WIDTH, GameConstants.BUTTON_HEIGHT);
        settingsButton.setSize(GameConstants.BUTTON_WIDTH, GameConstants.BUTTON_HEIGHT);
        exitButton.setSize(GameConstants.BUTTON_WIDTH, GameConstants.BUTTON_HEIGHT);

        newGameButton.setPosition(GameConstants.BUTTON_POSITION_WIDTH, GameConstants.BUTTON_POSITION_HEIGHT + GameConstants.BUTTON_HEIGHT);
        settingsButton.setPosition(GameConstants.BUTTON_POSITION_WIDTH, GameConstants.BUTTON_POSITION_HEIGHT);
        exitButton.setPosition(GameConstants.BUTTON_POSITION_WIDTH, GameConstants.BUTTON_POSITION_HEIGHT - GameConstants.BUTTON_HEIGHT);

        newGameButton.setChecked(true);

        stage.addActor(newGameButton);
        stage.addActor(settingsButton);
        stage.addActor(exitButton);
    }

    private void moveButtonIndex(int idx) {
        buttons[buttonsIdx].setChecked(false);
        buttonsIdx = idx;
        buttons[buttonsIdx].setChecked(true);
    }

    private void setupInputListener() {

        InputListener inputListener = new InputListener() {
            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                switch (keycode) {
                    case Input.Keys.ENTER: {
                        Button currentCheckedButton = buttons[buttonsIdx];
                        if (currentCheckedButton.equals(newGameButton)) {
                            gameScreen.setScreenState(new GameScreenState(gameScreen));
                        } else if (currentCheckedButton.equals(settingsButton)) {
                            gameScreen.setScreenState(new SettingsScreenState(gameScreen));
                        } else if (currentCheckedButton.equals(exitButton)) {
                            Gdx.app.exit();
                        }
                        break;
                    }
                    case Input.Keys.DOWN: {
                        moveButtonIndex((buttonsIdx + 1) % GameConstants.MAIN_MENU_BUTTON_COUNT);
                        break;
                    }
                    case Input.Keys.UP: {
                        moveButtonIndex((buttonsIdx + (GameConstants.MAIN_MENU_BUTTON_COUNT - 1)) % GameConstants.MAIN_MENU_BUTTON_COUNT);
                        break;
                    }
                }
                return true;
            }
        };
        stage.addListener(inputListener);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act();

        batch.begin();
        batch.draw(GameConstants.BACKGROUND, 0,0);
        batch.end();

        stage.draw();
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
