package com.bubbleshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MenuScreenState extends ScreenSetup implements ScreenState {
    private Stage stage;
    private final GameScreen gameScreen;
    private BitmapFont font;
    private MenuButton[] buttons;
    private MenuButtonsIterator iterator;

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
        buttons = new MenuButton[]{
                new MenuButton(Color.WHITE, GameConstants.MAIN_MENU_BUTTONS[0]),
                new MenuButton(Color.BLACK, GameConstants.MAIN_MENU_BUTTONS[1]),
                new MenuButton(Color.BLACK, GameConstants.MAIN_MENU_BUTTONS[2])
        };
        iterator = new MenuButtonsIterator(buttons);
    }

    @Override
    public void actOnKeyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.ENTER: {
                String currentButton = iterator.curr().getText();
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
                iterator.next();
                break;
            }
            case Input.Keys.UP: {
                iterator.prev();
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
            font.setColor(buttons[i].getTextColor());
            GlyphLayout layout = new GlyphLayout(font, buttons[i].getText());
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
