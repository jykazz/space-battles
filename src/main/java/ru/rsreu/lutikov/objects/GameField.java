package ru.rsreu.lutikov.objects;
import java.awt.*;

public class GameField {
    private Dimension dimension;

    public GameField(Dimension dimension) {
        this.dimension = dimension;
    }

    public Dimension getDimension() {
        return this.dimension;
    }
}