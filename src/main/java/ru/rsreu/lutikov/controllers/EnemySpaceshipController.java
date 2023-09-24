package ru.rsreu.lutikov.controllers;

import ru.rsreu.lutikov.models.EnemySpaceshipModel;

public class EnemySpaceshipController {

    private EnemySpaceshipModel spaceshipModel;

    public EnemySpaceshipController(EnemySpaceshipModel spaceshipModel) {
        this.spaceshipModel = spaceshipModel;
    }

    public void moveEnemySpaceship() {
        this.spaceshipModel.moveEnemySpaceship();
    }
}
