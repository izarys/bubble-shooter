package com.bubbleshooter.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.bubbleshooter.BubbleShooterGame;

public class DesktopLauncher {
	private static final int SCREEN_WIDTH = 1800;
	private static final int SCREEN_HEIGHT = 900;

	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(SCREEN_WIDTH, SCREEN_HEIGHT);
		config.setResizable(false);
		config.setTitle("Bubble Shooter");
		new Lwjgl3Application(new BubbleShooterGame(), config);
	}
}
