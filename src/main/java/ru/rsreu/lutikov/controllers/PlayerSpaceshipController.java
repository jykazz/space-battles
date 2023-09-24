package ru.rsreu.lutikov.controllers;

import ru.rsreu.lutikov.models.PlayerSpaceshipModel;

public class PlayerSpaceshipController {

    private PlayerSpaceshipModel spaceshipModel;

    public PlayerSpaceshipController(PlayerSpaceshipModel spaceshipModel) {
        this.spaceshipModel = spaceshipModel;
    }

    public void movePlayerSpaceship() {
        this.spaceshipModel.movePlayerSpaceship();
    }
}
