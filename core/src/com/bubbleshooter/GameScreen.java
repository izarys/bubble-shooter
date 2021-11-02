package com.bubbleshooter;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    // screen
    private Camera camera;
    private Viewport viewport;

    // graphics
    private SpriteBatch batch;
    private Texture background;


    // world parameters
    private static final int SCREEN_WIDTH = 1800;
    private static final int SCREEN_HEIGHT = 900;

    GameScreen() {
        camera = new OrthographicCamera();
        viewport = new StretchViewport(SCREEN_WIDTH, SCREEN_HEIGHT, camera);

        background = new Texture("menu_background.png");

        batch = new SpriteBatch();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();

        batch.draw(background, 0,0, SCREEN_WIDTH, SCREEN_HEIGHT);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        batch.setProjectionMatrix(camera.combined);
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
