package com.bubbleshooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GameConstants {
    // world parameters
    public final static int SCREEN_WIDTH = 1800;
    public final static int SCREEN_HEIGHT = 900;

    // textures
    public static final Texture BACKGROUND = new Texture("menu_background.png");
    public static final Texture NEW_GAME_OFF_TEXTURE = new Texture("new_game_off.png");
    public static final Texture NEW_GAME_ON_TEXTURE = new Texture("new_game_on.png");
    public static final Texture SETTINGS_OFF_TEXTURE = new Texture("settings_off.png");
    public static final Texture SETTINGS_ON_TEXTURE = new Texture("settings_on.png");
    public static final Texture EXIT_OFF_TEXTURE = new Texture("exit_off.png");
    public static final Texture EXIT_ON_TEXTURE = new Texture("exit_on.png");

    // drawables
    public static final Drawable NEW_GAME_OFF_DRAWABLE = new TextureRegionDrawable(NEW_GAME_OFF_TEXTURE);
    public static final Drawable NEW_GAME_ON_DRAWABLE = new TextureRegionDrawable(NEW_GAME_ON_TEXTURE);
    public static final Drawable SETTINGS_OFF_DRAWABLE = new TextureRegionDrawable(SETTINGS_OFF_TEXTURE);
    public static final Drawable SETTINGS_ON_DRAWABLE = new TextureRegionDrawable(SETTINGS_ON_TEXTURE);
    public static final Drawable EXIT_OFF_DRAWABLE = new TextureRegionDrawable(EXIT_OFF_TEXTURE);
    public static final Drawable EXIT_ON_DRAWABLE = new TextureRegionDrawable(EXIT_ON_TEXTURE);

    // styles
    public static final Button.ButtonStyle NEW_GAME_OFF_STYLE = new Button.ButtonStyle(NEW_GAME_OFF_DRAWABLE, NEW_GAME_OFF_DRAWABLE, NEW_GAME_ON_DRAWABLE);
    public static final Button.ButtonStyle SETTINGS_STYLE = new Button.ButtonStyle(SETTINGS_OFF_DRAWABLE, SETTINGS_OFF_DRAWABLE, SETTINGS_ON_DRAWABLE);
    public static final Button.ButtonStyle EXIT_STYLE = new Button.ButtonStyle(EXIT_OFF_DRAWABLE, EXIT_OFF_DRAWABLE, EXIT_ON_DRAWABLE);

    // buttons variables
    public static final int BUTTON_WIDTH = 600;
    public static final int BUTTON_HEIGHT = 150;
    public static final int BUTTON_POSITION_WIDTH = (SCREEN_WIDTH - BUTTON_WIDTH) / 2;
    public static final int BUTTON_POSITION_HEIGHT = (SCREEN_HEIGHT - BUTTON_HEIGHT) / 2;
    public static final int MAIN_MENU_BUTTON_COUNT = 3;
}
