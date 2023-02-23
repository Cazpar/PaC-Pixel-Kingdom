package com.pac.game.entities.player;

import aurelienribon.tweenengine.TweenAccessor;

public class PlayerAccessor implements TweenAccessor<Player> {

    public static final int POSITION_XY = 1;

    @Override
    public int getValues(Player target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case POSITION_XY:
                returnValues[0] = target.getPositionX();
                returnValues[1] = target.getPositionY();
                return 2;
            default:
                return 0;
        }
    }

    @Override
    public void setValues(Player target, int tweenType, float[] newValues) {
        switch (tweenType) {
            case POSITION_XY:
                target.setPosition(newValues[0], newValues[1]);
                break;
            default:
                break;
        }
    }
}
