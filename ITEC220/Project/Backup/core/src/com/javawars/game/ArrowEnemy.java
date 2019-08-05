/**
 * ArrowEnemy Class - creates arrow enemies that move in one direction
 * @author James Caldwell
 * @version 4/29/2015
 */
package com.javawars.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;



public class ArrowEnemy {

    private float speed = 3.5f;

    private Vector2 position = new Vector2();
    private Vector2 velocity = new Vector2();

    private Texture texture;
    private Sprite enemy;
    private float x, y;
    private float xDir, yDir;
    private boolean isAlive;
    private Rectangle boundingBox;


    /**
     * Instantiates a new Arrow enemy.
     *
     * @param orgX the org x
     * @param orgY the org y
     */
    public ArrowEnemy(float orgX, float orgY) {

        this.texture = new Texture("core/assets/enemy2.png");
        this.x = orgX;
        this.y = orgY;
        this.position.x = orgX;
        this.position.y = orgY;
        this.enemy = new Sprite(texture);

        this.xDir += 1 * speed;
        this.yDir = 0;

        this.isAlive = true;

        this.boundingBox = new Rectangle(position.x, position.y, enemy.getWidth(), enemy.getHeight());


    }


    /**
     * Gets sprite.
     *
     * @return the sprite
     */
    public Sprite getSprite() {
        return enemy;
    }


    /**
     * Update void.
     *
     * @param deltaTime the delta time
     */
    public void update(float deltaTime) {
        // position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        x += xDir;
      //  y += yDir;
        checkCollision();
        position.x = x;
     //   position.y = y;
        boundingBox.set(position.x, position.y, enemy.getWidth(), enemy.getHeight());
    }


    /**
     * Gets x loc.
     *
     * @return the x loc
     */
    public float getXLoc() {
        return x;
    }


    /**
     * Gets y loc.
     *
     * @return the y loc
     */
    public float getYLoc() {
        return y;
    }


    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Vector2 getPosition() {

        return position;
    }


    /**
     * Check collision.
     */
    public void checkCollision() {

        if (this.x < -375) {
            this.xDir = 0;
            this.xDir += MathUtils.random(0, 1) * speed;
        }
        if (this.y < -225) {
            this.yDir = 0;
            this.yDir += MathUtils.random(0, 1) * speed;
        }
        if (this.x > 350) {
            this.xDir = 0;
            this.xDir += MathUtils.random(-1, 0) * speed;
        }
        if (this.y > 225) {
            this.yDir = 0;
            this.yDir += MathUtils.random(-1, 0) * speed;
        }


    }

    /**
     * Gets bounding box.
     *
     * @return the bounding box
     */
    public Rectangle getBoundingBox() {

        return boundingBox;
    }

    /**
     * Is alive.
     *
     * @return the boolean
     */
    public boolean isAlive() {

        return isAlive;
    }
}