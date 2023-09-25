package ru.rsreu.lutikov.objects;

import java.awt.*;
import java.util.Queue;
import java.util.List;
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

    private List<EnemySpaceship> enemySpaceshipList;

    private List<Money> moneyList;

    private List<Bullet> enemyBulletList;

    private List<Bullet> playerBulletList;

    public PlayerSpaceship(GameField gameField, Point location, Dimension dimension, int shiftX, int shiftY, Score score,
                           List enemySpaceshipList,
                           List moneyList, List enemyBulletList, List playerBulletList) {
        this.gameField = gameField;
        this.location = location;
        this.dimension = dimension;
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        this.score = score;
        this.enemySpaceshipList = enemySpaceshipList;
        this.moneyList = moneyList;
        this.enemyBulletList = enemyBulletList;
        this.playerBulletList = playerBulletList;
    }

    void getMoney() {
        if ((!this.moneyList.isEmpty()) && (this.location.x == this.moneyList.get(0).getLocation().x) && (this.location.y == this.moneyList.get(0).getLocation().y)) {
            this.moneyList.remove(0);
            this.score.addMoney();
            System.out.println("Монета получена");
            System.out.printf("Счет %d\n", score.getScoreValue());
        }
    }

    void getDestruction() {
        Iterator<Bullet> bulletIterator = playerBulletList.iterator();

        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            if ((bullet.getLocation().getX() == enemySpaceshipList.get(0).getLocation().getX()) && (bullet.getLocation().getY() == enemySpaceshipList.get(0).getLocation().getY())) {
                System.out.println("Пуля уничтожила вражеский корабль");
                System.out.printf("Счет %d", score.getScoreValue());
                this.score.addDestruction();
                bulletIterator.remove();
            }
        }
    }

    void makeShot() {
        Bullet bullet = new Bullet(this.gameField, this.location);
        this.playerBulletList.add(bullet);
    }

    void checkCollision() {
        if ((!enemyBulletList.isEmpty()) && (this.location.x == enemyBulletList.get(0).getLocation().getX()) && (this.location.y == enemyBulletList.get(0).getLocation().getY())) {
            System.out.println("Корабль столкнулся с пулей");
            System.exit(0);
        }
        if ((this.location.x == enemySpaceshipList.get(0).getLocation().getX()) && (this.location.y == enemySpaceshipList.get(0).getLocation().getY())) {
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
            System.out.println("Корабль сопрокоснулся с левой границей");
        }

        if (this.location.x + this.dimension.width > gameFieldDimension.width) {
            this.location.x = gameFieldDimension.width - this.dimension.width;
            this.shiftX = -this.shiftX;
            System.out.println("Корабль соприкоснулся с правой границей");
        }

        System.out.printf("Координаты корабля игрока X, Y = %d, %3d\n", this.location.x, this.location.y);
        this.getMoney();
        this.makeShot();
        this.getDestruction();
    }

    public void setMoneyList(List<Money> moneyList) {
        this.moneyList = moneyList;
    }

    public Point getLocation() {
        return this.location;
    }

    public void setEnemySpaceshipList(List enemySpaceshipList) {
        this.enemySpaceshipList = enemySpaceshipList;
    }

    public List<Money> getMoneyList() {
        return this.moneyList;
    }
}
