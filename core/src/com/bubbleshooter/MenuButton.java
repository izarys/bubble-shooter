package com.bubbleshooter;

import com.badlogic.gdx.graphics.Color;
public class MenuButton {
    private Color textColor;
    private final String text;

    public MenuButton(Color textColor, String text) {
        this.textColor = textColor;
        this.text = text;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public String getText() {
        return text;
    }
}
