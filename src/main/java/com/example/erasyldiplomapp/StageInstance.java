package com.example.erasyldiplomapp;

import javafx.stage.Stage;

public class StageInstance {

    private static StageInstance instance;
    private StageInstance(){}

    public static StageInstance getInstance() {
        if (instance == null) {
            instance = new StageInstance();
        }
        return instance;
    }

    public Stage stage = new Stage();
}
