package com.bubbleshooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class GameConstants {
    // world parameters
    public final static int SCREEN_WIDTH = 1800;
    public final static int SCREEN_HEIGHT = 900;

    // textures
    public static final Texture BACKGROUND = new Texture("menu_background.png");
    public static final Texture BUBBLE_RED = new Texture("bubble_red.png");

    // buttons variables
    public static final int MAIN_MENU_BUTTON_COUNT = 3;
    public static final int SETTINGS_BUTTON_COUNT = 3;
    public static final String NEW_GAME = "new game";
    public static final String SETTINGS = "settings";
    public static final String EXIT = "exit";
    public static final String SOUND = "sound: ";
    public static final String ON = "on";
    public static final String OR = " / ";
    public static final String OFF = "off";
    public static final String CONTROLS = "controls: ";
    public static final String ARROWS = "arrows";
    public static final String WASD = "wasd";
    public static final String BACK = "back";
    public static final String[] MAIN_MENU_BUTTONS = {NEW_GAME, SETTINGS, EXIT};
    public static final String[][] SETTINGS_BUTTONS = {{SOUND, ON, OR, OFF}, {CONTROLS, ARROWS, OR, WASD}, {BACK}};
    public static final int MAIN_MENU_HEIGHT_OFFSET = 128;
    public static final float BUTTONS_HEIGHT = 600;

    // text position
    public static final int SIDE_TEXT_WIDTH = 1500;
    public static final int SIDE_TEXT_HEIGHT = 700;
    public static final int SIDE_TEXT_HEIGHT_OFFSET = 50;

    // frame position
    public static final int BIG_FRAME_X = 50;
    public static final int SMALL_FRAME_X = 1450;
    public static final int BIG_FRAME_WIDTH = 1350;
    public static final int SMALL_FRAME_WIDTH = 300;
    public static final int FRAME_HEIGHT = 800;
    public static final int FRAME_Y = 50;


    // font
    public static final FileHandle FONT_FILE = Gdx.files.internal("pixel_font.ttf");
    public static final int MENU_FONT_SIZE = 128;
    public static final int SETTINGS_FONT_SIZE = 100;
    public static final int GAME_FONT_SIZE = 32;

}
