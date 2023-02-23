package com.pac.game.entities.resources;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.pac.game.entities.BaseEntity;
import com.pac.game.mapping.TileGrid;

public class Tree extends BaseEntity {

    private final TileGrid tileGrid;
    private final ShapeRenderer shapeRenderer;
    private final float positionX;
    private final float positionY;

    public Tree(TileGrid tileGrid, Vector2 position) {
        super(tileGrid, position);
        this.tileGrid = tileGrid;
        int numRows = tileGrid.getNumRows();
        int numCols = tileGrid.getNumCols();
        int randomRow = MathUtils.random(numRows - 1);
        int randomCol = MathUtils.random(numCols - 1);
        positionX = (randomCol * tileGrid.getTileSize()) + (tileGrid.getTileSize() / 2f);
        positionY = (randomRow * tileGrid.getTileSize()) + (tileGrid.getTileSize() / 2f);
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(
                positionX,
                positionY,
                tileGrid.getTileSize() / 3f
        );
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }
}
