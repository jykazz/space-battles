package ru.rsreu.lutikov.controllers;

import ru.rsreu.lutikov.models.EnemyBulletModel;
import ru.rsreu.lutikov.objects.Bullet;

public class EnemyBulletController {
    private EnemyBulletModel bulletModel;

    public EnemyBulletController(EnemyBulletModel enemyBulletModel) {
        this.bulletModel = enemyBulletModel;
    }

    public void moveEnemyBullet() {
        this.bulletModel.moveEnemyBullet();
    }
}
