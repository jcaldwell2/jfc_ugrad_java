package com.javawars.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.javawars.game.ScreenManager;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Java Wars";
		config.useGL30 = false;
		config.height = 640;
		config.width = 800;
        config.resizable = false;


		new LwjglApplication(new ScreenManager(), config);
	}

    public static void newGame(){

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Java Wars";
        config.useGL30 = false;
        config.height = 640;
        config.width = 800;
        config.resizable = false;


        new LwjglApplication(new ScreenManager(), config);
    }

}
