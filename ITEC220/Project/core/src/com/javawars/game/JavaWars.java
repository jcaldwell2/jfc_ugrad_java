
/**
 * Java Wars - main game class with rendering
 * @author James Calwell
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
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.ArrayList;


public class JavaWars extends ApplicationAdapter implements InputProcessor {

    private	SpriteBatch batch;
    private ShapeRenderer renderer;

    private Bullet b;
    private Enemy e;
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private Sprite player;

    private long startTime;

    private Texture shipImg;
    private Texture border;
    private Texture horizBorder;
    private Texture enemy;

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

	@Override
	public void create() {

		batch = new SpriteBatch();
        renderer = new ShapeRenderer();

        shipImg = new Texture("core/assets/player.png");
		border = new Texture("core/assets/border.png");
        horizBorder = new Texture("core/assets/horizBorder.png");
        enemy = new Texture("core/assets/enemy1.png");

        player = new Sprite(shipImg);
		player.setPosition(-player.getWidth() / 2, -player.getHeight() / 2);


        //level 1

            for(int i = 0;i< 10;i++) {
                e = new Enemy(MathUtils.random(20,150), MathUtils.random(20,150),
                        player.getX() + 17, player.getY() + 20, enemy);
                enemies.add(e);
            }




		world = new World(new Vector2(0, 0),true);

		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set((player.getX() + player.getWidth()/2) /
						PIXELS_TO_METERS,
				(player.getY() + player.getHeight()/2) / PIXELS_TO_METERS);

		body = world.createBody(bodyDef);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(player.getWidth()/2 / PIXELS_TO_METERS, player.getHeight()
				/2 / PIXELS_TO_METERS);

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

		float w = Gdx.graphics.getWidth()/PIXELS_TO_METERS - 25/PIXELS_TO_METERS;
		// Set the height to just 25 pixels above the bottom of the screen so we can see the edge in the
		// debug renderer
		float h = Gdx.graphics.getHeight()/PIXELS_TO_METERS- 25/PIXELS_TO_METERS;
		//bodyDef2.position.set(0,
//                h-10/PIXELS_TO_METERS);
		bodyDef2.position.set(0,0);
        bodyDef3.position.set(0,0);
        bodyDef4.position.set(0,h);
        bodyDef5.position.set(w,0);


        FixtureDef fixtureDef2 = new FixtureDef();
        FixtureDef fixtureDef3 = new FixtureDef();
        FixtureDef fixtureDef4 = new FixtureDef();
        FixtureDef fixtureDef5 = new FixtureDef();

		EdgeShape screenBottom = new EdgeShape();
        EdgeShape screenLeft = new EdgeShape();
        EdgeShape screenTop = new EdgeShape();
        EdgeShape screenRight = new EdgeShape();

		screenBottom.set(-w/2,-h/2,w/2,-h/2);
        screenLeft.set(-w/2,h/2,-w/2,-h/2);
        screenTop.set(-w/2,h/2,w/2,h/2);
        screenRight.set(-w/2,-h/2,-w/2,h/2);

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
		font.setColor(Color.BLACK);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.
				getHeight());
	}


	@Override
	public void render() {
        camera.update();
        // Step the physics simulation forward at a rate of 60hz
        world.step(1f / 60f, 6, 2);
        startTime = (System.currentTimeMillis() - startTime) / 1000;

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
            if(enemies!= null) {
                Enemy e = enemies.get(i);

                e.update(Gdx.graphics.getDeltaTime());
                batch.draw(e, e.getXLoc(), e.getYLoc());

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

            renderer.circle(b.position.x, b.position.y, 2);
        }





            // For debugging - show the direction of bullet fire
            if (Gdx.app.getType() == Application.ApplicationType.Desktop || Gdx.app.getType() ==
                    Application.ApplicationType.WebGL) {
                renderer.setColor(0.2f, 0.2f, 0.2f, 1.0f);
                renderer.line(player.getX() + 17, player.getY() + 20, Gdx.input.getX() -
                        Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Gdx.input.getY());
            }


            renderer.end();
            if (Gdx.input.justTouched()) {
                // Invert the the y to accommodate difference in coordinate systems


                b = new Bullet(player.getX() + 17, player.getY() + 20, Gdx.input.getX() -
                        Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Gdx.input.getY());
                bullets.add(b);
            }


          //  debugRenderer.render(world, debugMatrix);
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

        float angle = 90* MathUtils.degRad;

		if(keycode == Input.Keys.RIGHT) {
            body.setLinearVelocity(2f, 0f);
            body.setTransform(body.getPosition(),3 * angle);
        }
		if(keycode == Input.Keys.LEFT) {
            body.setLinearVelocity(-2f, 0f);
            body.setTransform(body.getPosition(), angle);
        }

		if(keycode == Input.Keys.UP) {
            //	body.applyForceToCenter(0f,20f,true);
            body.setLinearVelocity(0f, 2f);
            body.setTransform(body.getPosition(), 0 * angle);
        }
		if(keycode == Input.Keys.DOWN) {
            //	body.applyForceToCenter(0f, -20f, true);
            body.setLinearVelocity(0f, -2f);
            body.setTransform(body.getPosition(), 2 * angle);
        }

		// On brackets ( [ ] ) apply torque, either clock or counterclockwise
		if(keycode == Input.Keys.RIGHT_BRACKET)
			torque += 0.1f;
		if(keycode == Input.Keys.LEFT_BRACKET)
			torque -= 0.1f;

		// Remove the torque using backslash /
		if(keycode == Input.Keys.BACKSLASH)
			torque = 0.0f;

		// If user hits spacebar, reset everything back to normal
		if(keycode == Input.Keys.SPACE|| keycode == Input.Keys.NUM_2) {
			body.setLinearVelocity(0f, 0f);
			body.setAngularVelocity(0f);
			torque = 0f;
			player.setPosition(0f, 0f);
			body.setTransform(0f,0f,0f);
		}

		if(keycode == Input.Keys.COMMA) {
			body.getFixtureList().first().setRestitution(body.getFixtureList().first().getRestitution()-0.1f);
		}
		if(keycode == Input.Keys.PERIOD) {
			body.getFixtureList().first().setRestitution(body.getFixtureList().first().getRestitution()+0.1f);
		}
		if(keycode == Input.Keys.ESCAPE || keycode == Input.Keys.NUM_1)
			drawSprite = !drawSprite;

		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}


	// On touch we apply force from the direction of the users touch.
	// This could result in the object "spinning"
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




   }