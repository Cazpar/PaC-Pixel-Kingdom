package com.pac.game.entities.player;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.pac.game.mapping.Tile;
import com.pac.game.mapping.TileGrid;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;


public class Player implements InputProcessor {
    private static Player instance;
    private final TileGrid tileGrid;
    private final ShapeRenderer shapeRenderer;
    private final TweenManager tweenManager;
    private float positionX;
    private float positionY;


    private Player(TileGrid tileGrid) {
        this.tileGrid = tileGrid;
        this.shapeRenderer = new ShapeRenderer();
        this.tweenManager = new TweenManager();

        // Set the starting position to a random tile
        int numRows = tileGrid.getNumRows();
        int numCols = tileGrid.getNumCols();
        int randomRow = MathUtils.random(numRows - 1);
        int randomCol = MathUtils.random(numCols - 1);
        float targetX = (randomCol * tileGrid.getTileSize()) + (tileGrid.getTileSize() / 2f);
        float targetY = (randomRow * tileGrid.getTileSize()) + (tileGrid.getTileSize() / 2f);
        setPosition(targetX, targetY);

        Tween.registerAccessor(Player.class, new PlayerAccessor());
    }

    public void render() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.circle(
                positionX,
                positionY,
                tileGrid.getTileSize() / 3f
        );
        shapeRenderer.end();
    }

    public static Player getInstance(TileGrid tileGrid) {
        if (instance == null) {
            instance = new Player(tileGrid);
        }
        return instance;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        int row = (tileGrid.getNumRows() - 1) - (screenY / tileGrid.getTileSize());
        int col = screenX / tileGrid.getTileSize();
        if (row >= 0 && row < tileGrid.getNumRows() && col >= 0 && col < tileGrid.getNumCols()) {
            // Check if the clicked tile is occupied by an entity
            Tile clickedTile = tileGrid.getTile(row, col);
            if (clickedTile.isOccupied()) {
                // Find the closest unoccupied tile next to the clicked tile
                int[] closestTile = tileGrid.getClosestUnoccupiedTile(row, col);
                if (closestTile != null) {
                    // Move the player to the closest unoccupied tile
                    float targetX = (closestTile[1] * tileGrid.getTileSize()) + (tileGrid.getTileSize() / 2f);
                    float targetY = (closestTile[0] * tileGrid.getTileSize()) + (tileGrid.getTileSize() / 2f);
                    Tween.to(this, PlayerAccessor.POSITION_XY, 0.5f)
                            .target(targetX, targetY)
                            .ease(TweenEquations.easeInOutQuad)
                            .start(tweenManager);
                    return true;
                }
            } else {
                // Move the player to the clicked tile
                float targetX = (col * tileGrid.getTileSize()) + (tileGrid.getTileSize() / 2f);
                float targetY = (row * tileGrid.getTileSize()) + (tileGrid.getTileSize() / 2f);
                Tween.to(this, PlayerAccessor.POSITION_XY, 0.5f)
                        .target(targetX, targetY)
                        .ease(TweenEquations.easeInOutQuad)
                        .start(tweenManager);
                return true;
            }
        }
        return false;
    }


    public void update(float deltaTime) {
        tweenManager.update(deltaTime);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
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
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    // other input processor methods
    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPosition(float newValue, float newValue1) {
        this.positionX = newValue;
        this.positionY = newValue1;
    }
}
