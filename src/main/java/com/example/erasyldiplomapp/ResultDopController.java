package com.example.erasyldiplomapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultDopController extends WindowFunctionality implements Initializable {


    @FXML
    private ImageView img;

    @FXML
    private Button mainButton;

    @FXML
    void backButtonAction() {
        openWindowWithStage("hello-view.fxml", 900, 600, StageInstance.getInstance().stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("pictures/img.png");
        Image bulbImage = new Image(brandingFile.toURI().toString());
        img.setImage(bulbImage);
    }
}
