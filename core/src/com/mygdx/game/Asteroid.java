package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by lurix on 29.05.17.
 */
public class Asteroid {
    private Vector2 position;
    private Vector2 velocity;

    public Asteroid(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
        Circle circle = new Circle();
    }

    public static void setMytexture(Texture mytexture) {
        Asteroid.mytexture = mytexture;
    }

    private static Texture mytexture;



    public void render(SpriteBatch batch){
        batch.draw(mytexture,position.x,position.y);
    }


    public void update(){
        position.add(velocity);
        if (position.x < -mytexture.getWidth())position.x = Gdx.graphics.getWidth();
        if (position.y < -mytexture.getHeight())position.y = Gdx.graphics.getHeight();
        if (position.x > Gdx.graphics.getWidth())position.x = -mytexture.getWidth();
        if (position.y > Gdx.graphics.getHeight())position.y = -mytexture.getHeight();

        if (InputHandler.isPressed()){
            velocity = position.cpy().sub(InputHandler.getMousePosition()).nor().scl(-1.0f);
        }
    }


}
