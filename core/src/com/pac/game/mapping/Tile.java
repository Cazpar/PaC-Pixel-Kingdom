package com.pac.game.mapping;

import com.pac.game.entities.BaseEntity;

public class Tile {
    private int row;
    private int col;
    private int tileSize;
    private BaseEntity entity;

    public Tile(int row, int col, int tileSize) {
        this.row = row;
        this.col = col;
        this.tileSize = tileSize;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getTileSize() {
        return tileSize;
    }

    public BaseEntity getEntity() {
        return entity;
    }

    public void setEntity(BaseEntity entity) {
        this.entity = entity;
    }

    public float getX() {
        return col * tileSize;
    }

    public float getY() {
        return row * tileSize;
    }

    public float getCenterX() {
        return getX() + tileSize / 2f;
    }

    public float getCenterY() {
        return getY() + tileSize / 2f;
    }
    public boolean isOccupied() {
        return entity != null;
    }

}
