package com.bubbleshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

        Map<Bubble, Set<Bubble>> graph = Level.getInstance().getGraph();

        for (Bubble bubble : graph.keySet()) {
            batch.draw(GameConstants.BUBBLE_TEXTURE.get(bubble.getColor()), bubble.getPosition().getX(), bubble.getPosition().getY());
        }

        Bubble[] nextBubbles = Level.getInstance().getQueue().getQueue();

        for (Bubble bubble : nextBubbles) {
            batch.draw(GameConstants.BUBBLE_TEXTURE.get(bubble.getColor()), bubble.getPosition().getX(), bubble.getPosition().getY());
        }

        Bubble shooterBubble = Level.getInstance().getShooter().getBubble();
        batch.draw(GameConstants.BUBBLE_TEXTURE.get(shooterBubble.getColor()), shooterBubble.getPosition().getX(), shooterBubble.getPosition().getY());



        batch.end();

        float r = GameConstants.AIM_HELPER_RADIUS;
        float angle = Level.getInstance().getShooter().getAngle();
        float x1 = GameConstants.BIG_FRAME_X + GameConstants.BIG_FRAME_WIDTH / 2f;
        float y1 = GameConstants.FRAME_Y + GameConstants.BUBBLE_SIZE / 2f;
        float x2 = (x1 + (float) Math.cos(angle) * r);
        float y2 = (y1 + (float) Math.sin(angle) * r);

        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rectLine(x1, y1, x2, y2,1);
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
