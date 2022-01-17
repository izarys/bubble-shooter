package com.bubbleshooter;

import com.badlogic.gdx.graphics.Color;

public class MenuButtonsIterator {
    private final MenuButton[] buttons;
    private int idx;

    MenuButtonsIterator(MenuButton[] buttons) {
        this.buttons = buttons;
        idx = 0;
    }

    public MenuButton next() {
        buttons[idx].setTextColor(Color.BLACK);
        idx = (idx + 1) % GameConstants.MAIN_MENU_BUTTON_COUNT;
        buttons[idx].setTextColor(Color.WHITE);
        return buttons[idx];
    }

    public MenuButton curr() {
        return buttons[idx];
    }

    public MenuButton prev() {
        buttons[idx].setTextColor(Color.BLACK);
        idx = (idx + (GameConstants.MAIN_MENU_BUTTON_COUNT - 1)) % GameConstants.MAIN_MENU_BUTTON_COUNT;
        buttons[idx].setTextColor(Color.WHITE);
        return buttons[idx];
    }
}
