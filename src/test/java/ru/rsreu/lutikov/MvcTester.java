package ru.rsreu.lutikov;

import ru.rsreu.lutikov.controllers.EnemyBulletController;
import ru.rsreu.lutikov.controllers.EnemySpaceshipController;
import ru.rsreu.lutikov.controllers.MoneyController;
import ru.rsreu.lutikov.controllers.PlayerSpaceshipController;
import ru.rsreu.lutikov.models.*;
import ru.rsreu.lutikov.settings.Settings;


public class MvcTester {

    public static void main(String[] args) {
        System.out.println("\nПроверка движения объектов");
        PlayerSpaceshipModel moveCheckingInPlayerSpaceshipModel = new MoveCheckingModel();
        EnemySpaceshipModel moveCheckingInEnemySpaceshipModel = new MoveCheckingModel();
        EnemyBulletModel moveCheckingBulletModel = new MoveCheckingModel();
        MoneyModel moveCheckingMoneyModel = new MoveCheckingModel();
        MvcTester.testMvc(moveCheckingInPlayerSpaceshipModel, moveCheckingInEnemySpaceshipModel, moveCheckingBulletModel, moveCheckingMoneyModel, Settings.CYCLE_COUNT);
    }

    private static void testMvc(PlayerSpaceshipModel playerSpaceshipModel, EnemySpaceshipModel enemySpaceshipModel, EnemyBulletModel enemyBulletModel, MoneyModel moneyModel, int cycleCount) {

        PlayerSpaceshipController playerSpaceshipController = new PlayerSpaceshipController(playerSpaceshipModel);
        EnemySpaceshipController enemySpaceshipController = new EnemySpaceshipController(enemySpaceshipModel);
        EnemyBulletController enemyBulletController = new EnemyBulletController(enemyBulletModel);
        MoneyController moneyController = new MoneyController(moneyModel);

        for (int i = 0; i < cycleCount; i++) {
            moneyController.moveMoney();
            playerSpaceshipController.movePlayerSpaceship();
            enemySpaceshipController.moveEnemySpaceship();
            enemyBulletController.moveEnemyBullet();

        }
    }
}
