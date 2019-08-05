/**
 * Enemy Class - creates enemies
 * @author James Caldwell
 * @version 4/29/2015
 */
package com.javawars.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Enemy {

    private float speed = 0.7f;

    private Vector2 position = new Vector2();
    private  Vector2 velocity = new Vector2();

    private Texture texture;
    private Sprite enemy;
    private float x,y;
    private float xDir,yDir;
    private boolean isAlive;
    private Rectangle boundingBox;



    public Enemy(float orgX, float orgY) {

        this.texture = new Texture("core/assets/enemy1.png");
        this.x = orgX;
        this.y = orgY;
        this.position.x = orgX;
        this.position.y = orgY;
        this.enemy = new Sprite(texture);

        this.xDir += MathUtils.random(-1,1) * speed;
        this.yDir += MathUtils.random(-1,1) * speed;

        this.isAlive = true;

        this.boundingBox = new Rectangle(position.x,position.y,enemy.getWidth(),enemy.getHeight());



    }


    public Sprite getSprite(){
        return enemy;
    }


    public void update(float deltaTime) {
        // position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        x+= xDir;
        y+= yDir;
        checkCollision();
        position.x = x;
        position.y = y;
        boundingBox.set(position.x, position.y, enemy.getWidth(), enemy.getHeight());
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
    public Vector2 getPosition(){

        return position;
    }


    public void checkCollision(){

        if(this.x < -375) {
            this.xDir = 0;
            this.xDir += MathUtils.random(0, 1) * 0.5;
        }
        if(this.y < -225) {
            this.yDir = 0;
            this.yDir += MathUtils.random(0, 1) * 0.5;
        }
        if(this.x > 350) {
            this.xDir = 0;
            this.xDir += MathUtils.random(-1, 0) * 0.5;
        }
        if(this.y > 225) {
            this.yDir = 0;
            this.yDir += MathUtils.random(-1, 0) * 0.5;
        }


    }

    public Rectangle getBoundingBox(){

        return boundingBox;
    }

    public boolean isAlive(){

        return  isAlive;
    }
}
