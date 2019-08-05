
/**
 * GameScreen - contains the game and rendering
 * @author James Caldwell
 * @version 4/29/2015
 */
package com.javawars.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;


/**
 * The type Game screen.
 */
public class GameScreen  implements InputProcessor, Screen {



    private SpriteBatch batch;
    private ShapeRenderer renderer;
    private ScreenManager game;

    private Bullet b;
    private Enemy e;
    private ArrowEnemy a;
    private FollowEnemy f;
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<ArrowEnemy> arrowEnemies = new ArrayList<ArrowEnemy>();
    private ArrayList<FollowEnemy> followEnemies = new ArrayList<FollowEnemy>();
    private Sprite player;

    private int score;
    private int enemySize;
    private String scoreText;
    private String time;
    private String playerCoords;
    private long startTime;
    private long currentTime;

    private Rectangle playerBox;

    private Texture shipImg;
    private Texture border;
    private Texture horizBorder;

    private World world;

    private Body body;
    private Body bodyEdgeScreenBottom;
    private Body bodyEdgeScreenLeft;
    private Body bodyEdgeScreenTop;
    private Body bodyEdgeScreenRight;

    private Box2DDebugRenderer debugRenderer;

    private Matrix4 debugMatrix;

    private OrthographicCamera camera;

    private BitmapFont font;



    private float torque = 0.0f;
    private boolean drawSprite = true;

    private final float PIXELS_TO_METERS = 100f;

    /**
     * Instantiates a new Game screen.
     *
     * @param _game the _ game
     */
    public GameScreen(ScreenManager _game){

        this.game = _game;

    }
    @Override
    public void show() {

        batch = new SpriteBatch();
        renderer = new ShapeRenderer();
        startTime = TimeUtils.millis();
        score = 0;


        shipImg = new Texture("core/assets/player.png");
        border = new Texture("core/assets/border.png");
        horizBorder = new Texture("core/assets/horizBorder.png");


        player = new Sprite(shipImg);
        player.setPosition(-player.getWidth() / 2, -player.getHeight() / 2);

        playerBox = new Rectangle(player.getX(),player.getY(),player.getWidth(),player.getHeight());



        world = new World(new Vector2(0, 0), true);

        //level 1

        for (int i = 0; i < 10; i++) {
            e = new Enemy(MathUtils.random(-300, 275), MathUtils.random(-300, 275));
            enemies.add(e);

        }

        //level 2
        for (int i = 0; i < 10; i++) {
            a = new ArrowEnemy(-300, MathUtils.random(-300, 275));
            arrowEnemies.add(a);

        }

        //level 3
        for (int i = 0; i < 3; i++) {
            f = new FollowEnemy(MathUtils.random(200,300), MathUtils.random(-300, 275));

           followEnemies.add(f);

        }


        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set((player.getX() + player.getWidth() / 2) /
                        PIXELS_TO_METERS,
                (player.getY() + player.getHeight() / 2) / PIXELS_TO_METERS);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(player.getWidth() / 2 / PIXELS_TO_METERS, player.getHeight()
                / 2 / PIXELS_TO_METERS);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;
        fixtureDef.restitution = 0.5f;

        body.createFixture(fixtureDef);
        shape.dispose();

        BodyDef bodyDef2 = new BodyDef();
        BodyDef bodyDef3 = new BodyDef();
        BodyDef bodyDef4 = new BodyDef();
        BodyDef bodyDef5 = new BodyDef();

        bodyDef3.type = BodyDef.BodyType.StaticBody;
        bodyDef2.type = BodyDef.BodyType.StaticBody;
        bodyDef4.type = BodyDef.BodyType.StaticBody;
        bodyDef5.type = BodyDef.BodyType.StaticBody;

        float w = Gdx.graphics.getWidth() / PIXELS_TO_METERS - 25 / PIXELS_TO_METERS;

        float h = Gdx.graphics.getHeight() / PIXELS_TO_METERS - 25 / PIXELS_TO_METERS;

        bodyDef2.position.set(0, 0);
        bodyDef3.position.set(0, 0);
        bodyDef4.position.set(0, h);
        bodyDef5.position.set(w, 0);


        FixtureDef fixtureDef2 = new FixtureDef();
        FixtureDef fixtureDef3 = new FixtureDef();
        FixtureDef fixtureDef4 = new FixtureDef();
        FixtureDef fixtureDef5 = new FixtureDef();

        EdgeShape screenBottom = new EdgeShape();
        EdgeShape screenLeft = new EdgeShape();
        EdgeShape screenTop = new EdgeShape();
        EdgeShape screenRight = new EdgeShape();

        screenBottom.set(-w / 2, -h / 2, w / 2, -h / 2);
        screenLeft.set(-w / 2, h / 2, -w / 2, -h / 2);
        screenTop.set(-w / 2, h / 2, w / 2, h / 2);
        screenRight.set(-w / 2, -h / 2, -w / 2, h / 2);

        fixtureDef2.shape = screenBottom;
        fixtureDef3.shape = screenLeft;
        fixtureDef4.shape = screenTop;
        fixtureDef5.shape = screenRight;

        bodyEdgeScreenBottom = world.createBody(bodyDef2);
        bodyEdgeScreenLeft = world.createBody(bodyDef3);
        bodyEdgeScreenTop = world.createBody(bodyDef4);
        bodyEdgeScreenRight = world.createBody(bodyDef5);

        bodyEdgeScreenBottom.createFixture(fixtureDef2);
        bodyEdgeScreenLeft.createFixture(fixtureDef3);
        bodyEdgeScreenTop.createFixture(fixtureDef2);
        bodyEdgeScreenRight.createFixture(fixtureDef5);

        screenBottom.dispose();

        Gdx.input.setInputProcessor(this);

        debugRenderer = new Box2DDebugRenderer();

        font = new BitmapFont();
        font.setColor(Color.WHITE);

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.
                getHeight());
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        camera.update();
        // Step the physics simulation forward at a rate of 60hz
        world.step(1f / 60f, 6, 2);
        scoreText = "" + score + " points";
        time = "" + currentTime + " seconds";

         playerCoords = "" +player.getX() +"," + player.getY();
        // System.out.println("Time elapsed in seconds = " + currentTime);

        currentTime = ((System.currentTimeMillis() - startTime) / 1000);

        playerBox.set(player.getX(), player.getY(), player.getWidth(), player.getHeight());

        body.applyTorque(torque, false);


        player.setPosition((body.getPosition().x * PIXELS_TO_METERS) - player.
                        getWidth() / 2,
                (body.getPosition().y * PIXELS_TO_METERS) - player.getHeight() / 2);
        player.setRotation((float) Math.toDegrees(body.getAngle()));

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        debugMatrix = batch.getProjectionMatrix().cpy().scale(PIXELS_TO_METERS,
                PIXELS_TO_METERS, 0);



        /** Begin batch rendering here! */

        batch.begin();

        font.draw(batch, scoreText, 0, 300);
        font.draw(batch,time,-150,300);

      // debugging for player coordinates
      //  font.draw(batch,playerCoords,150,300);

        if (drawSprite)
            batch.draw(player, player.getX(), player.getY(), player.getOriginX(),
                    player.getOriginY(),
                    player.getWidth(), player.getHeight(), player.getScaleX(), player.
                            getScaleY(), player.getRotation());

        //draw the 4 game borders
        batch.draw(border, -Gdx.graphics.getWidth() / 2, -Gdx.graphics.getHeight() / 2);
        batch.draw(border, Gdx.graphics.getWidth() / 2 - 15, -Gdx.graphics.getHeight() / 2);

        batch.draw(horizBorder, -Gdx.graphics.getWidth() / 2 + 15, -Gdx.graphics.getHeight() / 2);
        batch.draw(horizBorder, -Gdx.graphics.getWidth() / 2 + 15, Gdx.graphics.getHeight() / 2 - 15);


        for (int i = 0; i < enemies.size(); i++) {
            enemySize = 3;
            if (enemies != null) {
                Enemy e = enemies.get(i);

                if(currentTime > 10)
                    enemySize = 5;
                if(currentTime > 20)
                    enemySize = 7;
                if(currentTime > 30)
                    enemySize = 10;

                if (!e.isAlive()) {
                    enemies.remove(i);
                }
                if (enemies.size() < enemySize) {
                    e = new Enemy(MathUtils.random(-300, 275), MathUtils.random(-300, 275));
                    enemies.add(e);
                }






                e.update(Gdx.graphics.getDeltaTime());

                batch.draw(e.getSprite(), e.getXLoc(), e.getYLoc());

            }
        }

         if( currentTime > 10) {
                for (int j = 0; j < arrowEnemies.size(); j++) {
                    if (arrowEnemies != null) {
                        ArrowEnemy a = arrowEnemies.get(j);
                        enemySize = 3;
                        if(currentTime > 20)
                            enemySize = 5;
                        if(currentTime > 45)
                            enemySize = 10;
                        if(currentTime > 90)
                            enemySize = 15;

                        if (!a.isAlive()) {
                            arrowEnemies.remove(a);
                        }
                        if (arrowEnemies.size() < enemySize) {
                            a = new ArrowEnemy(-300, MathUtils.random(-300, 275));
                            arrowEnemies.add(a);
                        }
                        if (currentTime/2 == 0) {
                            a = new ArrowEnemy(-300, MathUtils.random(-300, 275));
                            arrowEnemies.add(a);
                        }


                        a.update(Gdx.graphics.getDeltaTime());

                        batch.draw(a.getSprite(), a.getXLoc(), a.getYLoc());

                    }

                }
         }

        if( currentTime > 20) {
            for (int j = 0; j < followEnemies.size(); j++) {
                if (followEnemies != null) {
                    FollowEnemy f = followEnemies.get(j);
                       enemySize = 4;

                    if(currentTime > 45)
                        enemySize = 5;
                    if(currentTime > 60)
                        enemySize = 6;
                    if(currentTime > 90)
                        enemySize = 7;

                    if (!f.isAlive()) {
                        followEnemies.remove(f);
                    }
                    if (followEnemies.size() < enemySize) {
                        f = new FollowEnemy(MathUtils.random(100,300), MathUtils.random(-300, 275));
                       followEnemies.add(f);
                    }


                    f.update(Gdx.graphics.getDeltaTime(),player.getX(),player.getY());

                    batch.draw(f.getSprite(), f.getXLoc(), f.getYLoc());

                }

            }
        }


            batch.end();
            /** Batch rendering has finished for this frame*/


            renderer.setProjectionMatrix(camera.combined);
            renderer.begin(ShapeRenderer.ShapeType.Line);
            renderer.setColor(1.0f, 1.0f, 1.0f, 1.0f);


            for (int i = 0; i < bullets.size(); i++) {
                Bullet b = bullets.get(i);

                b.update(Gdx.graphics.getDeltaTime());
                if (removeBullet(b))
                    bullets.remove(b);

                renderer.circle(b.position.x, b.position.y, 2);
            }

            /** For debugging - show the direction of bullet fire

             if (Gdx.app.getType() == Application.ApplicationType.Desktop || Gdx.app.getType() ==
             Application.ApplicationType.WebGL) {
             renderer.setColor(0.2f, 0.2f, 0.2f, 1.0f);
             renderer.line(player.getX() + 17, player.getY() + 20, Gdx.input.getX() -
             Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Gdx.input.getY());
             }

             */

            renderer.end();
            if (Gdx.input.justTouched()) {
                // Invert the the y to accommodate difference in coordinate systems
                b = new Bullet(player.getX() + 17, player.getY() + 20, Gdx.input.getX() -
                        Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Gdx.input.getY());
                bullets.add(b);
            }

            if (currentTime > 2) {
                collides();
                isPlayerDead();
            }

            //Physics debug renderer
            // debugRenderer.render(world, debugMatrix);

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

    @Override
    public void dispose() {
        shipImg.dispose();
        world.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        float angle = 90 * MathUtils.degRad;

        if (keycode == Input.Keys.RIGHT) {
            body.setLinearVelocity(2f, 0f);
            body.setTransform(body.getPosition(), 3 * angle);
        }
        if (keycode == Input.Keys.LEFT) {
            body.setLinearVelocity(-2f, 0f);
            body.setTransform(body.getPosition(), angle);
        }

        if (keycode == Input.Keys.UP) {
            //	body.applyForceToCenter(0f,20f,true);
            body.setLinearVelocity(0f, 2f);
            body.setTransform(body.getPosition(), 0 * angle);
        }
        if (keycode == Input.Keys.DOWN) {
            //	body.applyForceToCenter(0f, -20f, true);
            body.setLinearVelocity(0f, -2f);
            body.setTransform(body.getPosition(), 2 * angle);
        }


/**
       reset the spaceship for debugging

        if (keycode == Input.Keys.SPACE || keycode == Input.Keys.NUM_2) {
            body.setLinearVelocity(0f, 0f);
            body.setAngularVelocity(0f);
            torque = 0f;
            player.setPosition(0f, 0f);
            body.setTransform(0f, 0f, 0f);
        }
*/

        if (keycode == Input.Keys.ESCAPE || keycode == Input.Keys.NUM_1){

        }

        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //body.applyForce(1f,1f,screenX,screenY,true);
        //body.applyTorque(0.4f,true);


        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }


    /**
     * Collides boolean.
     *
     * @return the boolean
     */
    public boolean collides() {

        Bullet bullet;
        Enemy enemy;
        ArrowEnemy arrowEnemy;
        FollowEnemy followEnemy;

        for (int j = 0; j < enemies.size(); j++) {
            for (int i = 0; i < bullets.size(); i++) {
                bullet = bullets.get(i);
                enemy = enemies.get(j);


                if (Intersector.overlaps(bullet.getBoundingCircle(), enemy.getBoundingBox())) {
                    enemies.remove(j);
                    bullets.remove(i);
                    score += 100;
                    return true;
                }
            }
        }

        for (int j = 0; j < arrowEnemies.size(); j++) {
            for (int i = 0; i < bullets.size(); i++) {
                bullet = bullets.get(i);
                arrowEnemy = arrowEnemies.get(j);


                if (Intersector.overlaps(bullet.getBoundingCircle(), arrowEnemy.getBoundingBox())) {
                   arrowEnemies.remove(j);
                    bullets.remove(i);
                    score += 200;
                    return true;
                }
            }
        }

        for (int j = 0; j < followEnemies.size(); j++) {
            for (int i = 0; i < bullets.size(); i++) {
                bullet = bullets.get(i);
                followEnemy = followEnemies.get(j);


                if (Intersector.overlaps(bullet.getBoundingCircle(), followEnemy.getBoundingBox())) {
                    followEnemies.remove(j);
                    bullets.remove(i);
                    score += 300;
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Is player dead.
     */
    public void isPlayerDead(){

        Enemy enemy;
        ArrowEnemy arrowEnemy;
        FollowEnemy followEnemy;

        for (int j = 0; j < enemies.size(); j++){
            enemy = enemies.get(j);

            if (Intersector.overlaps(playerBox, enemy.getBoundingBox())){
                game.setScreen(game.gameOverScreen);
            }
        }
        for (int i = 0; i < arrowEnemies.size(); i++){
            arrowEnemy = arrowEnemies.get(i);

            if (Intersector.overlaps(playerBox, arrowEnemy.getBoundingBox())){
                game.setScreen(game.gameOverScreen);
            }
        }

        for (int i = 0; i < followEnemies.size(); i++){
            followEnemy = followEnemies.get(i);

            if (Intersector.overlaps(playerBox, followEnemy.getBoundingBox())){
                game.setScreen(game.gameOverScreen);
            }
        }
    }

    /**
     * Remove bullet.
     *
     * @param bullet the bullet
     * @return the boolean
     */
    public boolean removeBullet(Bullet bullet) {

        if(bullet.position.x < -375) {
            return true;
        }
        if(bullet.position.y < -300) {
            return true;
        }
        if(bullet.position.x > 375) {
            return true;
        }
        if(bullet.position.y > 300) {
            return true;
        }
        return false;

    }




}