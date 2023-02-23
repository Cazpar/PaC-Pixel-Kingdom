// TileGridFactory.java
package com.pac.game.factories;

import com.pac.game.mapping.DefaultTileGrid;
import com.pac.game.mapping.TileGrid;

public class TileGridFactory {

    public static TileGrid create() {
        return new DefaultTileGrid();
    }
}
