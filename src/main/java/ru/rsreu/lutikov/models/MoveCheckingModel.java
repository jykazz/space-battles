package ru.rsreu.lutikov.models;

import ru.rsreu.lutikov.objects.*;
import ru.rsreu.lutikov.settings.Settings;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MoveCheckingModel implements PlayerSpaceshipModel, EnemySpaceshipModel, EnemyBulletModel, MoneyModel {

    PlayerSpaceship playerSpaceship;

    EnemySpaceship enemySpaceship;


    GameField gameField;

    Score score;
    List<EnemySpaceship> enemySpaceshipList = new ArrayList<>();
    List<Money> moneyList;
    List<Bullet> enemyBulletList = new ArrayList<>();
    List<Bullet> playerBulletList = new ArrayList<>();


    public MoveCheckingModel() {
        this.gameField = new GameField(Settings.GAME_FIELD_DIMENSION);
        this.score = new Score();
        this.playerSpaceship = new PlayerSpaceship(this.gameField, Settings.PLAYER_SPACESHIP_INITIAL_LOCATION, Settings.PLAYER_SPACESHIP_DIMENSION, Settings.PLAYER_SPACESHIP_SHIFT_X, Settings.PLAYER_SPACESHIP_SHIFT_Y, score,
                null,
                null, enemyBulletList, playerBulletList);
        Point location = new Point(8, 8);
        this.enemySpaceship = new EnemySpaceship(this.gameField, location, Settings.ENEMY_SPACESHIP_DIMENSION, Settings.ENEMY_SPACESHIP_SHIFT_X, Settings.ENEMY_SPACESHIP_SHIFT_Y, playerSpaceship, enemyBulletList, playerBulletList);
        this.enemySpaceshipList.add(this.enemySpaceship);
        Point moneyLocation = new Point(7, 1);
        Money money = new Money(this.gameField, moneyLocation);
        this.moneyList = new ArrayList<>();
        this.moneyList.add(money);
        this.playerSpaceship.setMoneyList(this.moneyList);
        this.playerSpaceship.setEnemySpaceshipList(this.enemySpaceshipList);

    }

    @Override
    public void movePlayerSpaceship() {
        this.playerSpaceship.move();
    }

    @Override
    public void moveEnemySpaceship() {
        if (!this.enemySpaceshipList.isEmpty()) {
            for (int i = 0; i < this.enemySpaceshipList.size(); i++) {
                EnemySpaceship enemySpaceship = this.enemySpaceshipList.get(i);
                enemySpaceship.move();
                this.enemySpaceshipList.set(i, enemySpaceship);
            }
        }
    }

    @Override
    public void moveEnemyBullet() {
        if (!this.enemyBulletList.isEmpty()) {
            Iterator<Bullet> iterator = this.enemyBulletList.iterator();

            while (iterator.hasNext()) {
                iterator.next().move();
            }
        }
    }

    @Override
    public void moveMoney() {
        this.moneyList.clear();
        this.moneyList.addAll(this.playerSpaceship.getMoneyList());
        if (!this.moneyList.isEmpty()) {
            for (int i = 0; i < this.moneyList.size(); i++) {
                Money money = this.moneyList.get(i);
                money.move();
                this.moneyList.set(i, money);
            }
            this.playerSpaceship.setMoneyList(moneyList);
        }
    }

}
