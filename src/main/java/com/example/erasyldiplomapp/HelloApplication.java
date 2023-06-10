package com.example.erasyldiplomapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
        StageInstance.getInstance().stage.setScene(scene);
        StageInstance.getInstance().stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}