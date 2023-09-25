package ru.rsreu.lutikov.objects;

import ru.rsreu.lutikov.settings.Settings;

import java.awt.*;

public class Money {
    private Money() {
    }

    private GameField gameField;

    private Point location;
    private Dimension dimension = Settings.MONEY_DIMENSION;

    private int shiftY = Settings.MONEY_SHIFT_Y;


    public Money(GameField gameField, Point location) {
        this.gameField = gameField;
        this.location = location;
    }

    public Point getLocation() {
        return this.location;
    }

    public void move() {
        if (this.location.y >= 0) {
            Dimension gameFieldDimension = this.gameField.getDimension();
            System.out.printf("Координаты монеты X, Y = %d, %3d\n", this.location.x, this.location.y);
            if (this.location.y == 0) {
                System.out.println("Монета улетела за поле");
            }
            this.location.y -= this.shiftY;
        }
    }

}
