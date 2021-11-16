package com.bubbleshooter;


public abstract class ScreenSetup {

    public abstract void setupFont();
    public abstract void setupButtons();
    public abstract void setupStage();

    public final void setup() {
        setupFont();
        setupStage();
        setupButtons();
    }
}
