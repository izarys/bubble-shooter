package com.bubbleshooter;

import com.badlogic.gdx.Game;

public class BubbleShooterGame extends Game {
	GameScreen gameScreen;

	@Override
	public void create() {
		gameScreen = new GameScreen();
		setScreen(gameScreen.getScreenState());
	}

	@Override
	public void dispose() {
		gameScreen.dispose();
	}

	@Override
	public void render() {
		super.render();
		setScreen(gameScreen.getScreenState());
	}

	@Override
	public void resize(int width, int height) {
		gameScreen.resize(width, height);
	}
}
