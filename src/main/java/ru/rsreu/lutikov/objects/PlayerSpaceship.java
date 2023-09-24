package ru.rsreu.lutikov.objects;

import java.awt.*;
import java.util.Queue;
import java.util.Iterator;

public class PlayerSpaceship {
    private PlayerSpaceship() {
    }

    private GameField gameField;

    private Point location;
    private Dimension dimension;

    private int shiftX;
    private int shiftY;

    private Score score;

    private Queue<EnemySpaceship> enemySpaceshipQueue;

    private Queue<Money> moneyQueue;

    private Queue<Bullet> enemyBulletQueue;

    private Queue<Bullet> playerBulletQueue;

    public PlayerSpaceship(GameField gameField, Point location, Dimension dimension, int shiftX, int shiftY, Score score, Queue enemySpaceshipQueue, Queue moneyQueue, Queue enemyBulletQueue, Queue playerBulletQueue) {
        this.gameField = gameField;
        this.location = location;
        this.dimension = dimension;
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        this.score = score;
        this.enemySpaceshipQueue = enemySpaceshipQueue;
        this.moneyQueue = moneyQueue;
        this.enemyBulletQueue = enemyBulletQueue;
        this.playerBulletQueue = playerBulletQueue;
    }

    void getMoney() {
        if ((this.location.x == moneyQueue.peek().getLocation().getX()) && (this.location.y == moneyQueue.peek().getLocation().getY())) {
            moneyQueue.poll();
            this.score.addMoney();
        }
    }

    void getDestruction() {
        Iterator<Bullet> bulletIterator = playerBulletQueue.iterator();

        while (bulletIterator.hasNext()) {
            Iterator<EnemySpaceship> enemySpaceshipIterator = enemySpaceshipQueue.iterator();
            Bullet bullet = bulletIterator.next();
            while (enemySpaceshipIterator.hasNext()) {
                EnemySpaceship enemySpaceship = enemySpaceshipIterator.next();
                if ((bullet.getLocation().getX() == enemySpaceship.getLocation().getX()) && (bullet.getLocation().getY() == enemySpaceship.getLocation().getY())) {
                    System.out.println("Пуля уничтожила вражеский корабль");
                    System.out.printf("Счет %d", score.getScoreValue());
                    this.score.addDestruction();
                    enemySpaceshipIterator.remove();
                    bulletIterator.remove();
                }
            }
        }


        if ((this.location.x == moneyQueue.peek().getLocation().getX()) && (this.location.y == moneyQueue.peek().getLocation().getY())) {
            moneyQueue.poll();
            this.score.addMoney();
            System.out.println("Монета получена");
            System.out.printf("Счет %d", score.getScoreValue());
        }
    }

    // TODO
    void makeShot() {
        Bullet bullet = new Bullet(this.gameField, this.location);
        playerBulletQueue.add(bullet);
    }

    // TODO
    void checkCollision() {
        if ((!enemyBulletQueue.isEmpty()) && (this.location.x == enemyBulletQueue.peek().getLocation().getX()) && (this.location.y == enemyBulletQueue.peek().getLocation().getY())) {
            System.out.println("Корабль столкнулся с пулей");
            System.exit(0);
        }
        if ((!enemySpaceshipQueue.isEmpty()) && (this.location.x == enemySpaceshipQueue.peek().getLocation().getX()) && (this.location.y == enemySpaceshipQueue.peek().getLocation().getY())) {
            System.out.println("Корабли столкнулись");
            System.exit(0);
        }
    }


    public void move() {
        checkCollision();
        Dimension gameFieldDimension = this.gameField.getDimension();

        this.location.x += this.shiftX;

        if (this.location.x < 0) {
            this.location.x = 0;
            this.shiftX = -this.shiftX;
            System.out.println("Корабль отскочил от левой стены");
        }

        if (this.location.x + this.dimension.width > gameFieldDimension.width) {
            this.location.x = gameFieldDimension.width - this.dimension.width;
            this.shiftX = -this.shiftX;
            System.out.println("Корабль отскочил от правой стены");
        }

        System.out.printf("Координаты X, Y = %d, %3d\n", this.location.x, this.location.y);
    }

    public Point getLocation() {
        return this.location;
    }
}
