package com.example.erasyldiplomapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends WindowFunctionality implements Initializable {

    @FXML
    private TextField cityField;

    @FXML
    private Button clear1;

    @FXML
    private Button clear2;

    @FXML
    private Button closeButton;

    @FXML
    private Button enterButton;

    @FXML
    private TextField orgField;

    @FXML
    private ImageView pic;

    @FXML
    void clearAction() {

    }

    @FXML
    void enterAction() {
        if(cityField.getText().isEmpty() || orgField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "", "Сіз қала немесе ұйым атын енгізбедіңіз", "");
        } else {
            Answers instance = Answers.getInstance();
            instance.city = cityField.getText();
            instance.org = orgField.getText();
            showAlert(Alert.AlertType.INFORMATION, "", "Сіз енгізген мәліметтер сақталды", "");
            openWindowWithStage("hello-view.fxml", 900, 600, StageInstance.getInstance().stage);
        }
    }

    @FXML
    void exitAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("pictures/logotip.jpeg");
        Image bulbImage = new Image(brandingFile.toURI().toString());
        pic.setImage(bulbImage);
    }
}
