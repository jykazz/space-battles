//package ru.rsreu.lutikov.objects;
//
//import java.awt.*;
//
//public class Spaceship {
//    private Spaceship() {
//    }
//
//    private GameField gameField;
//
//    private Point location;
//    private Dimension dimension;
//
//
//    private int shiftX;
//    private int shiftY;
//    public Spaceship(GameField gameField, Point location, Dimension dimension, int shiftX, int shiftY) {
//        this.gameField = gameField;
//        this.location = location;
//        this.dimension = dimension;
//        this.shiftX = shiftX;
//        this.shiftY = shiftY;
//    }
//
//    public void move() {
//        Dimension gameFieldDimension = this.gameField.getDimension();
//
//        this.location.x += this.shiftX;
//
//        if (this.location.x < 0) {
//            this.location.x = 0;
//            this.shiftX = -this.shiftX;
//            System.out.println("Корабль отскочил от левой стены");
//        }
//
//        if (this.location.x + this.dimension.width > gameFieldDimension.width) {
//            this.location.x = gameFieldDimension.width - this.dimension.width;
//            this.shiftX = -this.shiftX;
//            System.out.println("Корабль отскочил от правой стены");
//        }
//
//        System.out.printf("Координаты X, Y = %d, %3d\n", this.location.x, this.location.y);
//    }
//
//
//}
