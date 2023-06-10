package com.example.erasyldiplomapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController extends WindowFunctionality implements Initializable {

    @FXML
    private Button closeButton;

    @FXML
    void closeWindowAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void firstMethod() {
        openWindowWithStage("firstMethod_1.fxml", 900, 600, StageInstance.getInstance().stage);
    }

    @FXML
    void secondMethod() {
        openWindowWithStage("test2_1.fxml", 900, 600, StageInstance.getInstance().stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}