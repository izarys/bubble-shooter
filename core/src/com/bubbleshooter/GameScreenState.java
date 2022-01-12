package com.bubbleshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.List;

public class GameScreenState extends ScreenSetup implements ScreenState {
    GameScreen gameScreen;
    BitmapFont font;
    Stage stage;

    GameScreenState(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
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
            case Input.Keys.ESCAPE:
                Gdx.app.exit();
            case Input.Keys.LEFT: {
                Level.getInstance().getShooter().moveLeft();
                break;
            }
            case Input.Keys.RIGHT: {
                Level.getInstance().getShooter().moveRight();
                break;
            }
            case Input.Keys.SPACE: {
                Level.getInstance().getShooter().shoot();
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

    @Override
    public void render(float delta) {

        Level.getInstance().getShooter().update();

        batch.begin();
        batch.draw(GameConstants.BACKGROUND, 0,0);

        font.draw(batch, "level: " + Level.getInstance().getLevel(), GameConstants.SIDE_TEXT_WIDTH, GameConstants.SIDE_TEXT_HEIGHT);
        font.draw(batch, "score: " + Player.getInstance().getScore(), GameConstants.SIDE_TEXT_WIDTH, GameConstants.SIDE_TEXT_HEIGHT - GameConstants.SIDE_TEXT_HEIGHT_OFFSET);
        font.draw(batch, "next:", GameConstants.SIDE_TEXT_WIDTH, GameConstants.SIDE_TEXT_HEIGHT - 2 * GameConstants.SIDE_TEXT_HEIGHT_OFFSET);
        font.draw(batch, "exit (ESC)", GameConstants.SIDE_TEXT_WIDTH, GameConstants.SIDE_TEXT_HEIGHT - 12 * GameConstants.SIDE_TEXT_HEIGHT_OFFSET);

        List<List<Bubble>> graph = Level.getInstance().getGraph();

        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                batch.draw(GameConstants.BUBBLE_RED, GameConstants.BIG_FRAME_X + j * 64, GameConstants.FRAME_HEIGHT + GameConstants.FRAME_Y - 64 - i * 64);
            }
        }

        Bubble[] nextBubbles = Level.getInstance().getQueue();

        for (int i = 0; i < nextBubbles.length; i++) {
            batch.draw(GameConstants.BUBBLE_RED, 1500, 500 - i * 80);
        }

        batch.draw(GameConstants.BUBBLE_RED, Level.getInstance().getShooter().getX(), Level.getInstance().getShooter().getY()); // shooter



        batch.end();

        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rectLine(GameConstants.BIG_FRAME_X + GameConstants.BIG_FRAME_WIDTH / 2f, GameConstants.FRAME_Y + 32, GameConstants.BIG_FRAME_X + GameConstants.BIG_FRAME_WIDTH / 2f + Level.getInstance().getShooter().getTarget() * 100, 250,1);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(GameConstants.BIG_FRAME_X, GameConstants.FRAME_Y, GameConstants.BIG_FRAME_WIDTH, GameConstants.FRAME_HEIGHT);
        shapeRenderer.rect(GameConstants.SMALL_FRAME_X, GameConstants.FRAME_Y, GameConstants.SMALL_FRAME_WIDTH, GameConstants.FRAME_HEIGHT);
        shapeRenderer.end();

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
