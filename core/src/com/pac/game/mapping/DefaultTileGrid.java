// DefaultTileGrid.java
package com.pac.game.mapping;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class DefaultTileGrid implements TileGrid {

    private static final int TILE_SIZE = 64;
    private static final int NUM_ROWS = 10;
    private static final int NUM_COLS = 10;
    private final Tile[][] tiles;

    public DefaultTileGrid() {
        tiles = new Tile[NUM_ROWS][NUM_COLS];
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                tiles[row][col] = new Tile(col, row, TILE_SIZE);
            }
        }
    }

    public int getNumCols() {
        return NUM_COLS;
    }

    public int getNumRows() {
        return NUM_ROWS;
    }

    public int getTileSize() {
        return TILE_SIZE;
    }

    public Tile getTile(int row, int col) {
        if (row < 0 || row >= NUM_ROWS || col < 0 || col >= NUM_COLS) {
            return null;
        }
        return tiles[row][col];
    }

    @Override
    public int[] getClosestUnoccupiedTile(int row, int col) {
        // Check the clicked tile first
        if (!tiles[row][col].isOccupied()) {
            return new int[] {row, col};
        }

        // Check tiles in a spiral pattern, starting from the closest tile
        int size = 1;
        do {
            int r = row - size;
            int c = col - size;
            for (int i = 0; i < size * 2; i++) {
                if (isValidTile(r, c) && !tiles[r][c].isOccupied()) {
                    return new int[]{r, c};
                }
                c++;
            }
            for (int i = 0; i < size * 2; i++) {
                if (isValidTile(r, c) && !tiles[r][c].isOccupied()) {
                    return new int[]{r, c};
                }
                r++;
            }
            for (int i = 0; i < size * 2; i++) {
                if (isValidTile(r, c) && !tiles[r][c].isOccupied()) {
                    return new int[]{r, c};
                }
                c--;
            }
            for (int i = 0; i < size * 2; i++) {
                if (isValidTile(r, c) && !tiles[r][c].isOccupied()) {
                    return new int[]{r, c};
                }
                r--;
            }
            size++;
        } while (size <= Math.max(getNumRows(), getNumCols()));

        // No unoccupied tile found
        return null;
    }

    private boolean isValidTile(int row, int col) {
        return row >= 0 && row < getNumRows() && col >= 0 && col < getNumCols();
    }

    public void draw(ShapeRenderer shapeRenderer) {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                Tile tile = tiles[row][col];
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(tile.getX(), tile.getY(), TILE_SIZE, TILE_SIZE);
                shapeRenderer.setColor(Color.BLACK);
                shapeRenderer.rect(tile.getX() + 2, tile.getY() + 2, TILE_SIZE - 4, TILE_SIZE - 4);
            }
        }
    }
}
