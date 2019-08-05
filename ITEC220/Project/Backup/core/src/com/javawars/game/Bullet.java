/**
 * Bullet class - creates the projectile shot
 * @author James Caldwell
 * @version 4/29/2015
 */
package com.javawars.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;


public class Bullet extends Sprite{

    public float speedMax = 500;

    private float radius = 2;
    public Vector2 position = new Vector2();
    public Vector2 velocity = new Vector2();

    private Circle boundingCircle;


    public Bullet(float orgX, float orgY, float targetX, float targetY) {
        position.set(orgX, orgY);

        velocity.set(targetX - position.x, targetY - position.y).nor().scl(Math.max(
                position.dst(targetX, targetY), speedMax));



        boundingCircle = new Circle();

    }


    public void update(float deltaTime) {
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);


        boundingCircle.set(position.x , position.y ,radius);

    }

    public Circle getBoundingCircle() {
        return boundingCircle;
    }





}

