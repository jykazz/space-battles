package ru.rsreu.lutikov;

import ru.rsreu.lutikov.controllers.EnemySpaceshipController;
import ru.rsreu.lutikov.controllers.PlayerSpaceshipController;
import ru.rsreu.lutikov.models.EnemySpaceshipModel;
import ru.rsreu.lutikov.models.MoveCheckingPlayerSpaceshipModel;
import ru.rsreu.lutikov.models.PlayerSpaceshipModel;


public class MvcTester {
    public static final int CYCLE_COUNT = 50;

    public static void main(String[] args) {
        System.out.println("\nПроверка движения корабля");
        PlayerSpaceshipModel moveCheckingInPlayerSpaceshipModel = new MoveCheckingPlayerSpaceshipModel();
        EnemySpaceshipModel moveCheckingInEnemySpaceshipModel = new MoveCheckingPlayerSpaceshipModel();
        MvcTester.testMvc(moveCheckingInPlayerSpaceshipModel, moveCheckingInEnemySpaceshipModel, MvcTester.CYCLE_COUNT);
    }

    private static void testMvc(PlayerSpaceshipModel playerSpaceshipModel, EnemySpaceshipModel enemySpaceshipModel, int cycleCount) {

        PlayerSpaceshipController playerSpaceshipController = new PlayerSpaceshipController(playerSpaceshipModel);
        EnemySpaceshipController enemySpaceshipController = new EnemySpaceshipController(enemySpaceshipModel);

        for (int i = 0; i < cycleCount; i++) {
            playerSpaceshipController.movePlayerSpaceship();
            enemySpaceshipController.moveEnemySpaceship();

        }
    }
}
