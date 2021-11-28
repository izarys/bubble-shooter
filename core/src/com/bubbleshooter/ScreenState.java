package com.bubbleshooter;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public interface ScreenState extends Screen {
    // screen
    Camera camera = new OrthographicCamera();
    Viewport viewport = new StretchViewport(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT, camera);

    SpriteBatch batch = new SpriteBatch();

    void show();
    void render(float delta);
    void resize(int width, int height);
    void pause();
    void resume();
    void hide();
    void dispose();
    void actOnKeyUp(int keycode);
}
