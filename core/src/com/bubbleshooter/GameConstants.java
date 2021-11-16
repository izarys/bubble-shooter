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
    public static final int MAIN_MENU_WIDTH_OFFSET = 320;
    public static final int MAIN_MENU_HEIGHT_OFFSET = 100;

    // font
    public static final FileHandle FONT_FILE = Gdx.files.internal("pixel_font.ttf");
    public static final int MENU_FONT_SIZE = 64;
    public static final int SETTINGS_FONT_SIZE = 32;

}
