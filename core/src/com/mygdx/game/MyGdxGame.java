package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Random r = new Random();
	Texture img;
	private final int AST_COUNT = 100;
	Asteroid[] ast = new Asteroid[AST_COUNT];
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		Asteroid.setMytexture(new Texture("asteroid.png"));
		img = new Texture("boo.png");
		for (int i = 0; i < AST_COUNT; i++) {
			ast[i] = new Asteroid(new Vector2(r.nextInt(600), r.nextInt(480)),new Vector2(3 * (r.nextFloat()-0.5f), 3 * (r.nextFloat()-0.5f)));
		}
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img,InputHandler.getMousePosition().x-40,InputHandler.getMousePosition().y-63);
		for (int i = 0; i < AST_COUNT; i++) {
			ast[i].render(batch);

		}

		batch.end();
	}

	public void update(){
		for (int i = 0; i < AST_COUNT; i++) {
			ast[i].update();

		}	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
