/**
 * ScreenManager - handles the different screens
 * @author James Caldwell
 * @version 4/29/2015
 */
package com.javawars.game;

import com.badlogic.gdx.Game;


/**
 * The type Screen manager.
 */
public class ScreenManager extends Game{
    /**
     * The Game screen.
     */
//  MainMenuScreen mainMenuScreen;
    GameScreen gameScreen;
    /**
     * The Game over screen.
     */
    GameOverScreen gameOverScreen;
    /**
     * The Title screen.
     */
    TitleScreen titleScreen;


    @Override
    public void create() {
  //      mainMenuScreen = new MainMenuScreen(this);
        gameScreen = new GameScreen(this);
        titleScreen = new TitleScreen(this);
        gameOverScreen = new GameOverScreen(this);
        setScreen(titleScreen);
    }


}
