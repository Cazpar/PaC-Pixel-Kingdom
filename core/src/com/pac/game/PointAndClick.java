// PointAndClick.java
package com.pac.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.pac.game.entities.player.Player;
import com.pac.game.entities.resources.Tree;
import com.pac.game.factories.TileGridFactory;
import com.pac.game.mapping.TileGrid;

public class PointAndClick extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private TileGrid tileGrid;

    private Player player;

    private OrthographicCamera camera;
    private FitViewport viewport;
    private Tree tree;

    @Override
    public void create() {
        int screenWidth = 640;
        int screenHeight = 640;
        Gdx.graphics.setWindowedMode(screenWidth, screenHeight);
        shapeRenderer = new ShapeRenderer();
        tileGrid = TileGridFactory.create();
        player = Player.getInstance(tileGrid);
        tree = new Tree(tileGrid);

        // Set up the camera and viewport
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);
        viewport = new FitViewport(screenWidth, screenHeight, camera);
        viewport.apply();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setInputProcessor(player);



        camera.update();
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Call the draw method from TileGrid interface
        tileGrid.draw(shapeRenderer);
        //update the players position
        player.update(Gdx.graphics.getDeltaTime());

        shapeRenderer.end();
        //player render after the update has happened
        player.render();
        tree.render();

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
