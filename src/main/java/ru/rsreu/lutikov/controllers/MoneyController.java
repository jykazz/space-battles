package ru.rsreu.lutikov.controllers;

import ru.rsreu.lutikov.models.MoneyModel;

public class MoneyController {
    private MoneyModel moneyModel;

    public MoneyController (MoneyModel moneyModel) {
        this.moneyModel = moneyModel;
    }

    public void moveMoney() {
        this.moneyModel.moveMoney();
    }
}
