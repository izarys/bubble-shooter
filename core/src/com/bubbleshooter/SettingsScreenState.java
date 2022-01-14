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

public class SettingsScreenState extends ScreenSetup implements ScreenState {
    GameScreen gameScreen;
    BitmapFont font;
    Stage stage;

    Color[][] buttonsColors;
    int buttonsIdxUpDown;

    SettingsScreenState(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        setup();
        stage.addListener(gameScreen.getInputListener());
    }

    @Override
    public void setupFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(GameConstants.FONT_FILE);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = GameConstants.SETTINGS_FONT_SIZE;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    @Override
    public void setupButtons() {
        buttonsColors = new Color[][]{{Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK}, {Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK}, {Color.BLACK}};
        buttonsIdxUpDown = 0;
    }

    private void moveButtonIndexUpDown(int idx) {
        buttonsColors[buttonsIdxUpDown][0] = Color.BLACK;
        buttonsIdxUpDown = idx;
        buttonsColors[buttonsIdxUpDown][0] = Color.WHITE;
    }

    private void setFirstArgOn() {
        buttonsColors[buttonsIdxUpDown][1] = Color.WHITE;
        buttonsColors[buttonsIdxUpDown][3] = Color.BLACK;
    }

    private void setFirstArgOff() {
        buttonsColors[buttonsIdxUpDown][1] = Color.BLACK;
        buttonsColors[buttonsIdxUpDown][3] = Color.WHITE;
    }

    @Override
    public void actOnKeyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.ENTER: {
                String currentButton = GameConstants.SETTINGS_BUTTONS[buttonsIdxUpDown][0];
                if (GameConstants.BACK.equals(currentButton)) {
                    gameScreen.setScreenState(gameScreen.getMenuScreenState());
                    if (buttonsColors[1][1] == Color.WHITE) {
                        gameScreen.getGameScreenState().setArrowsCommand();
                    }
                    else {
                        gameScreen.getGameScreenState().setADCommand();
                    }
                }
                break;
            }
            case Input.Keys.DOWN: {
                moveButtonIndexUpDown((buttonsIdxUpDown + 1) % GameConstants.SETTINGS_BUTTON_COUNT);
                break;
            }
            case Input.Keys.UP: {
                moveButtonIndexUpDown((buttonsIdxUpDown + (GameConstants.SETTINGS_BUTTON_COUNT - 1)) % GameConstants.SETTINGS_BUTTON_COUNT);
                break;
            }
            case Input.Keys.LEFT:
                case Input.Keys.RIGHT: {
                    if (buttonsIdxUpDown < 2) {
                        if ((buttonsColors[buttonsIdxUpDown][1].equals(Color.WHITE))) {
                            setFirstArgOff();
                        } else {
                            setFirstArgOn();
                        }
                    }
                    break;
                }
        }
    }

    @Override
    public void setupStage() {
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    private float getLayoutOffset(int i, int j) {
        float offset = 0;
        for (int k = 0; k < GameConstants.SETTINGS_BUTTONS[i].length; k++) {
            GlyphLayout layout = new GlyphLayout(font, GameConstants.SETTINGS_BUTTONS[i][k]);
            offset += layout.width;
        }
        offset /= 2;
        for (int k = 0; k < j; k++) {
            GlyphLayout layout = new GlyphLayout(font, GameConstants.SETTINGS_BUTTONS[i][k]);
            offset -= layout.width;
        }

        return offset;
    }

    @Override
    public void render(float delta) {
        batch.begin();

        batch.draw(GameConstants.BACKGROUND, 0,0);

        for (int i = 0; i < GameConstants.SETTINGS_BUTTONS.length; i++) {
            for (int j = 0; j < GameConstants.SETTINGS_BUTTONS[i].length; j++) {
                font.setColor(buttonsColors[i][j]);
                GlyphLayout layout = new GlyphLayout(font, GameConstants.SETTINGS_BUTTONS[i][j]);
                float x = GameConstants.SCREEN_WIDTH / 2f - getLayoutOffset(i, j);
                float y = GameConstants.BUTTONS_HEIGHT - GameConstants.SETTINGS_FONT_SIZE * i;
                font.draw(batch, layout, x, y);
            }
        }

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
