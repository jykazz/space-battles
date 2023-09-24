package ru.rsreu.lutikov.models;

import ru.rsreu.lutikov.objects.*;
import ru.rsreu.lutikov.settings.Settings;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class MoveCheckingPlayerSpaceshipModel implements PlayerSpaceshipModel, EnemySpaceshipModel {

    PlayerSpaceship playerSpaceship;

    EnemySpaceship enemySpaceship;


    GameField gameField;

    Score score;
    Queue<EnemySpaceship> enemySpaceshipQueue = new LinkedList<>();
    Queue<Money> moneyQueue = new LinkedList<>();
    Queue<Bullet> enemyBulletQueue = new LinkedList<>();
    Queue<Bullet> playerBulletQueue = new LinkedList<>();


    public MoveCheckingPlayerSpaceshipModel() {
        this.gameField = new GameField(Settings.GAME_FIELD_DIMENSION);
        this.score = new Score();
        this.playerSpaceship = new PlayerSpaceship(this.gameField, Settings.PLAYER_SPACESHIP_INITIAL_LOCATION, Settings.PLAYER_SPACESHIP_DIMENSION, Settings.PLAYER_SPACESHIP_SHIFT_X, Settings.PLAYER_SPACESHIP_SHIFT_Y, score, enemySpaceshipQueue, moneyQueue, enemyBulletQueue, playerBulletQueue);
        Point location = new Point(8, 8);
        this.enemySpaceship = new EnemySpaceship(this.gameField, location, Settings.ENEMY_SPACESHIP_DIMENSION, Settings.ENEMY_SPACESHIP_SHIFT_X, Settings.ENEMY_SPACESHIP_SHIFT_Y, playerSpaceship, enemyBulletQueue, playerBulletQueue);
        enemySpaceshipQueue.add(enemySpaceship);
    }

    @Override
    public void movePlayerSpaceship() {
        this.playerSpaceship.move();
    }

    @Override
    public void moveEnemySpaceship() {
        this.enemySpaceship.move();
    }
}
