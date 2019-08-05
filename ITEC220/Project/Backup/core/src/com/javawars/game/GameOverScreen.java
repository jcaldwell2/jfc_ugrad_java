/**
 * GameOverScreen - Displays Game Over Screen
 * @author James Caldwell
 * @version 4/29/2015
 */
package com.javawars.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverScreen implements Screen{

    private ScreenManager game;
    private Texture backgroundTexture;
    private Sprite backgroundSprite;
    private SpriteBatch batch;


    /**
     * Instantiates a new Game over screen.
     *
     * @param _game the _ game
     */
    public GameOverScreen(ScreenManager _game){

        game = _game;
        backgroundTexture = new Texture("core/assets/gameOverScreen.png");
        backgroundSprite = new Sprite(backgroundTexture);


    }
    /**
     * Called when this screen becomes the current screen for a {@link Game}.
     */
    @Override
    public void show() {


        batch = new SpriteBatch();

    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        batch.begin();



        batch.draw(backgroundSprite,50,0);


        batch.end();

        if (Gdx.input.justTouched()) {// use your own criterion here
        GameScreen newGameScreen = new GameScreen(game);
         game.setScreen(newGameScreen);



        }
    }

    /**
     * @param width
     * @param height
     * @see ApplicationListener#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     * @see ApplicationListener#pause()
     */
    @Override
    public void pause() {

    }

    /**
     * @see ApplicationListener#resume()
     */
    @Override
    public void resume() {

    }

    /**
     * Called when this screen is no longer the current screen for a {@link Game}.
     */
    @Override
    public void hide() {

    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {

    }

    /**
     * Called when a key was pressed
     *
     * @param keycode one of the constants in {@link Input.Keys}
     * @return whether the input was processed
     */

}

