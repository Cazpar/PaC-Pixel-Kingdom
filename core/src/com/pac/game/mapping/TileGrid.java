// TileGrid.java
package com.pac.game.mapping;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pac.game.entities.BaseEntity;

public interface TileGrid {
    void draw(ShapeRenderer shapeRenderer);

    int getTileSize();

    int getNumRows();

    int getNumCols();

    int[] getClosestUnoccupiedTile(int row, int col);

    Tile getTile(int row, int col);

    Tile getRandomUnoccupiedTile();
}
