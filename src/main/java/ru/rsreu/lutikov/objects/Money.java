package ru.rsreu.lutikov.objects;

import java.awt.*;

public class Money {
    private Money() {
    }

    private GameField gameField;

    private Point location;
    private Dimension dimension;

    public Money(GameField gameField, Point location, Dimension dimension) {
        this.gameField = gameField;
        this.location = location;
        this.dimension = dimension;
    }

    public Point getLocation() {
        return this.location;
    }

}
