package ru.rsreu.lutikov.objects;

import ru.rsreu.lutikov.settings.Settings;

import java.awt.*;

public class Bullet {
    private Bullet() {
    }

    private GameField gameField;

    private Point location;
    private Dimension dimension = Settings.MONEY_DIMENSION;

    private int shiftY = Settings.MONEY_SHIFT_Y;

    public Bullet(GameField gameField, Point location) {
        this.gameField = gameField;
        this.location = location;
    }

    public Point getLocation() {
        return this.location;
    }

}
