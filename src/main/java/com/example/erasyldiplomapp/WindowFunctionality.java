package com.example.erasyldiplomapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WindowFunctionality {
    protected Boolean isEmptyTextFields(TextField[] textFields) {
        boolean result = false;
        for(TextField textField : textFields) {
            if(textField.getText().isEmpty()) {
                result = true;
            }
        }
        return result;
    }

    protected Boolean isCorrectNumber(TextField[] textFields) {
        boolean result = true;
        for(TextField textField : textFields) {
            int num = Integer.parseInt(textField.getText());
            if(num != 0 && num != 5 && num != 10) {
                result = false;
                break;
            }
        }
        return result;
    }

    protected void showAlert(
            Alert.AlertType type,
            String titleText,
            String headerText,
            String contentText
    ) {
        Alert alertErrorEdit = new Alert(type);
        alertErrorEdit.setTitle(titleText);
        alertErrorEdit.setHeaderText(headerText);
        alertErrorEdit.setContentText(contentText);
        alertErrorEdit.showAndWait();
    }

    protected String getTime() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss");
        return dateFormat.format(currentDate);
    }

    void openWindowWithStage(String nameOfWindow, int width, int height, Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(nameOfWindow));
            stage.setScene(new Scene(root, width, height));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
