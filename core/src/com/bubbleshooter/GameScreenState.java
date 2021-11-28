package com.bubbleshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.List;

public class GameScreenState extends ScreenSetup implements ScreenState {
    GameScreen gameScreen;
    BitmapFont font;
    Stage stage;
    Level level;

    GameScreenState(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        level = new Level();
        setupFont();
    }

    @Override
    public void setupFont() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(GameConstants.FONT_FILE);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = GameConstants.GAME_FONT_SIZE;
        font = generator.generateFont(parameter);
        generator.dispose();
        font.setColor(Color.WHITE);
    }

    @Override
    public void setupButtons() {

    }

    @Override
    public void actOnKeyUp(int keycode) {
        switch (keycode) {

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

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(GameConstants.BACKGROUND, 0,0);

        font.draw(batch, "level: ", 500, 400);
        font.draw(batch, "score: ", 500, 380);
        font.draw(batch, "next:", 500, 360);
        font.draw(batch, "exit (ESC)", 500, 50);

        List<List<Bubble>> graph = level.getGraph().getGraph();

        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                font.draw(batch, "O", 300 - i * 20, 400 - j * 20);
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
