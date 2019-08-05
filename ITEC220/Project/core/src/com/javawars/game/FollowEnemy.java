/**
 * FollowEnemy Class - creates  enemies that move towards the player
 * @author James Caldwell
 * @version 4/29/2015
 */
package com.javawars.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class FollowEnemy {

    private float speed = .01f;

    private Vector2 position = new Vector2();
    private Vector2 velocity = new Vector2();

    private Texture texture;
    private Sprite enemy;
    private float x, y;
    private float xDir, yDir;
    private boolean isAlive;
    private Rectangle boundingBox;


    public FollowEnemy(float orgX, float orgY) {

        this.texture = new Texture("core/assets/enemy3.png");
        this.x = orgX;
        this.y = orgY;
        this.position.x = orgX;
        this.position.y = orgY;
        this.enemy = new Sprite(texture);

        this.xDir += -1 * speed;
        this.yDir += -1 * speed;

        this.isAlive = true;

        this.boundingBox = new Rectangle(position.x, position.y, enemy.getWidth(), enemy.getHeight());


    }


    public Sprite getSprite() {
        return enemy;
    }


    public void update(float deltaTime, float _x, float _y) {



        yDir = _y;
        xDir = _x ;
        x += xDir * speed;
        y += yDir * speed;


        position.x = x;
        position.y = y;
        boundingBox.set(position.x, position.y, enemy.getWidth(), enemy.getHeight());
        checkCollision();
    }


    public float getXLoc() {
        return x;
    }


    public float getYLoc() {
        return y;
    }


    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {

        return position;
    }


    public void checkCollision() {

        if (this.x < -375)
            this.x = -375;

        if (this.y < -225)
            this.y = -225;


        if (this.x > 350)
            this.x = 350;


        if (this.y > 225)
            this.y = 225;




    }

    public Rectangle getBoundingBox() {

        return boundingBox;
    }

    public boolean isAlive() {

        return isAlive;
    }
}