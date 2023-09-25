package ru.rsreu.lutikov.objects;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class EnemySpaceship {
    private EnemySpaceship() {
    }

    private GameField gameField;

    private Point location;
    private Dimension dimension;


    private int shiftX;
    private int shiftY;
    private PlayerSpaceship playerSpaceship;

    private List<Bullet> enemyBulletList;

    private List<Bullet> playerBulletList;

    public EnemySpaceship(GameField gameField, Point location, Dimension dimension, int shiftX, int shiftY, PlayerSpaceship playerSpaceship, List enemyBulletList, List playerBulletList) {
        this.gameField = gameField;
        this.location = location;
        this.dimension = dimension;
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        this.playerSpaceship = playerSpaceship;
        this.enemyBulletList = enemyBulletList;
        this.playerBulletList = playerBulletList;
    }

    public void move() {
        if (this.location.y >= 0) {
            this.makeBullet();
            this.checkCollision();
            System.out.printf("Координаты вражеского корабля X, Y = %d, %3d\n", this.location.x, this.location.y);
            if (this.location.y == 0) {
                System.out.println("Вражеский корабль улетел за поле");
            }
            this.location.y -= this.shiftY;
            if (!this.enemyBulletList.isEmpty()) {
                Iterator<Bullet> iterator = this.enemyBulletList.iterator();

                while (iterator.hasNext()) {
                    iterator.next().move();
                }
            }
        }
    }

    private void makeBullet() {
        if (this.location.x == playerSpaceship.getLocation().x) {
            System.out.println("Вражеский корабль выпустил пулю");
            Bullet bullet = new Bullet(this.gameField, this.location);
            this.enemyBulletList.add(bullet);

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

