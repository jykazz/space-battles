package ru.rsreu.lutikov.objects;

import ru.rsreu.lutikov.settings.Settings;

public class Score {
    private int scoreValue;

    public Score() {
        this.scoreValue = Settings.INITIAL_SCORE_VALUE;
    }

    public void addMoney() {
        this.scoreValue += Settings.MONEY_VALUE;
    }

    public void addDestruction() {
        this.scoreValue += Settings.BULLET_VALUE;
    }

    public int getScoreValue() {
        return this.scoreValue;
    }

}
