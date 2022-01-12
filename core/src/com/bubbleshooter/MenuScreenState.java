package com.bubbleshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuScreenState extends ScreenSetup implements ScreenState {

    Stage stage;
    GameScreen gameScreen;
    BitmapFont font;
    Color[] buttonsColors;
    int buttonsIdx;

    MenuScreenState(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        setup();
    }

    @Override
    public void setupFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(GameConstants.FONT_FILE);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = GameConstants.MENU_FONT_SIZE;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    @Override
    public void setupStage() {
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void setupButtons() {
        buttonsColors = new Color[]{Color.WHITE, Color.BLACK, Color.BLACK};
        buttonsIdx = 0;
    }

    private void moveButtonIndex(int idx) {
        buttonsColors[buttonsIdx] = Color.BLACK;
        buttonsIdx = idx;
        buttonsColors[buttonsIdx] = Color.WHITE;
    }

    @Override
    public void actOnKeyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.ENTER: {
                String currentButton = GameConstants.MAIN_MENU_BUTTONS[buttonsIdx];
                switch (currentButton) {
                    case GameConstants.NEW_GAME:
                        gameScreen.setScreenState(gameScreen.getGameScreenState());
                        break;
                    case GameConstants.SETTINGS:
                        gameScreen.setScreenState(gameScreen.getSettingsScreenState());
                        break;
                    case GameConstants.EXIT:
                        Gdx.app.exit();
                        break;
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
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act();

        batch.begin();
        batch.draw(GameConstants.BACKGROUND, 0,0);
        for (int i = 0; i < GameConstants.MAIN_MENU_BUTTON_COUNT; i++) {
            font.setColor(buttonsColors[i]);
            GlyphLayout layout = new GlyphLayout(font, GameConstants.MAIN_MENU_BUTTONS[i]);
            float x = (GameConstants.SCREEN_WIDTH - layout.width) / 2;
            float y = GameConstants.BUTTONS_HEIGHT - GameConstants.MAIN_MENU_HEIGHT_OFFSET * i;
            font.draw(batch, layout, x, y);
        }

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
