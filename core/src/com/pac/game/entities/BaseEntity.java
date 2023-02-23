package com.pac.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.pac.game.mapping.TileGrid;

public abstract class BaseEntity {

    // Position of entity
    Vector2 position = new Vector2();

    public BaseEntity(TileGrid tileGrid, Vector2 position) {

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



}
