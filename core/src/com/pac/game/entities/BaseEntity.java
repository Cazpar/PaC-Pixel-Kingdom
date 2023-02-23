package com.pac.game.entities;

import com.pac.game.mapping.Tile;

public abstract class BaseEntity {

    // Position of entity
    Tile tile;

    public BaseEntity(Tile tile) {
        this.tile = tile;
    }

    /**
     * Updates the entity's state.
     * @param delta The time in seconds since the last update.
     */
    public abstract void update(float delta);

    /**
     * Renders the entity.
     */
    public abstract void render();

    /**
     * Disposes any resources used by the entity.
     */
    public abstract void dispose();

    public Tile getTile() {
        return tile;
    }
}