package ru.rsreu.lutikov.objects;

import ru.rsreu.lutikov.settings.Settings;

import java.awt.*;

public class Bullet {
    private Bullet() {
    }

    private GameField gameField;

    private Point location;
    private Dimension dimension = Settings.BULLET_DIMENSION;

    private int shiftY = Settings.BULLET_SHIFT_Y;

    public Bullet(GameField gameField, Point location) {
        this.gameField = gameField;
        this.location = location;
    }

    public Point getLocation() {
        return this.location;
    }

    public void move() {
        if (this.location.y >= 0) {
            Dimension gameFieldDimension = this.gameField.getDimension();
            System.out.printf("Координаты пули X, Y = %d, %3d\n", this.location.x, this.location.y);
            if (this.location.y == 0) {
                System.out.println("Пуля улетела за поле");
            }
            this.location.y -= this.shiftY;
        }
    }

}
