
package com.pac.game.entities.resources;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pac.game.entities.BaseEntity;
import com.pac.game.mapping.Tile;
import com.pac.game.mapping.TileGrid;

public class Tree extends BaseEntity {

    private final ShapeRenderer shapeRenderer;
    private final Tile tile;

    public Tree(TileGrid tileGrid) {
        super(tileGrid.getRandomUnoccupiedTile());
        shapeRenderer = new ShapeRenderer();
        tile = this.getTile();
        tile.setEntity(this);
    }



    @Override
    public void update(float delta) {

    }

    @Override
    public void render() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(
                tile.getCenterX(),
                tile.getCenterY(),
                tile.getTileSize() / 3f
        );
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}