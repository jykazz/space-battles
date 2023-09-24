package ru.rsreu.lutikov.settings;

import java.awt.*;

public final class Settings {
    private Settings() {
    }
    public static final int PLAYER_SPACESHIP_INITIAL_POSITION_X = 5;
    public static final int PLAYER_SPACESHIP_INITIAL_POSITION_Y = 1;
    public static final Point PLAYER_SPACESHIP_INITIAL_LOCATION = new Point(Settings.PLAYER_SPACESHIP_INITIAL_POSITION_X, Settings.PLAYER_SPACESHIP_INITIAL_POSITION_Y);
    public static final int PLAYER_SPACESHIP_SHIFT_X = 1;
    public static final int PLAYER_SPACESHIP_SHIFT_Y = 0;

    public static final int PLAYER_SPACESHIP_WIDTH = 1;
    public static final int PLAYER_SPACESHIP_HEIGHT = 1;
    public static final Dimension PLAYER_SPACESHIP_DIMENSION = new Dimension(Settings.PLAYER_SPACESHIP_WIDTH, Settings.PLAYER_SPACESHIP_HEIGHT);


    public static final int ENEMY_SPACESHIP_SHIFT_X = 0;
    public static final int ENEMY_SPACESHIP_SHIFT_Y = 1;
    public static final int ENEMY_SPACESHIP_WIDTH = 2;
    public static final int ENEMY_SPACESHIP_HEIGHT = 2;
    public static final Dimension ENEMY_SPACESHIP_DIMENSION = new Dimension(Settings.ENEMY_SPACESHIP_WIDTH, Settings.ENEMY_SPACESHIP_HEIGHT);

    public static final int MONEY_WIDTH = 1;
    public static final int MONEY_HEIGHT = 1;
    public static final Dimension MONEY_DIMENSION = new Dimension(Settings.MONEY_WIDTH, Settings.MONEY_HEIGHT);
    public static final int MONEY_VALUE = 1;

    public static final int MONEY_SHIFT_Y = 1;


    public static final int BULLET_SHIFT = 1;
    public static final int BULLET_WIDTH = 1;
    public static final int BULLET_HEIGHT = 1;
    public static final Dimension BULLET_DIMENSION = new Dimension(Settings.PLAYER_SPACESHIP_WIDTH, Settings.PLAYER_SPACESHIP_HEIGHT);
    public static final int BULLET_VALUE = 10;

    public static final int GAME_FIELD_WIDTH = 9;
    public static final int GAME_FIELD_HEIGHT = 9;
    public static final Dimension GAME_FIELD_DIMENSION = new Dimension(Settings.GAME_FIELD_WIDTH, Settings.GAME_FIELD_HEIGHT);

    public static final int INITIAL_SCORE_VALUE = 0;

}
