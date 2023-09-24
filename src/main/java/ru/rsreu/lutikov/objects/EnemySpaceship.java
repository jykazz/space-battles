package ru.rsreu.lutikov.objects;

import java.awt.*;
import java.util.Queue;

public class EnemySpaceship {
    private EnemySpaceship() {
    }

    private GameField gameField;

    private Point location;
    private Dimension dimension;


    private int shiftX;
    private int shiftY;

    private Bullet bullet;

    private PlayerSpaceship playerSpaceship;

    private Queue enemyBulletQueue;

    private Queue playerBulletQueue;

    public EnemySpaceship(GameField gameField, Point location, Dimension dimension, int shiftX, int shiftY, PlayerSpaceship playerSpaceship, Queue enemyBulletQueue, Queue playerBulletQueue) {
        this.gameField = gameField;
        this.location = location;
        this.dimension = dimension;
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        this.playerSpaceship = playerSpaceship;
        this.enemyBulletQueue = enemyBulletQueue;
        this.playerBulletQueue = playerBulletQueue;
    }

    public void move() {
        this.makeBullet();
        Dimension gameFieldDimension = this.gameField.getDimension();
        checkCollision();
        System.out.printf("Координаты вражеского корабля X, Y = %d, %3d\n", this.location.x, this.location.y);
        if (this.location.y == 0) {
            System.out.println("Вражеский корабль улетел за поле");
        }
        this.location.y -= this.shiftY;
    }

    private void makeBullet() {
        if (this.location.x == playerSpaceship.getLocation().x) {
            Bullet bullet = new Bullet(this.gameField, this.location);
            enemyBulletQueue.add(bullet);
        }
    }

    void checkCollision() {
        if ((this.location.x == playerSpaceship.getLocation().x) && (this.location.y == playerSpaceship.getLocation().y)) {
            System.out.println("Корабли столкнулись");
            System.exit(0);
        }
    }

    public Point getLocation() {
        return this.location;
    }
}

