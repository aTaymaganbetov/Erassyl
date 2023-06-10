package com.example.erasyldiplomapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TestP2Controller extends WindowFunctionality implements Initializable {

    @FXML
    private ImageView bulb = new ImageView();

    @FXML
    private Button clue1 = new Button();

    @FXML
    private Button clue2;

    @FXML
    private Button clue3;

    @FXML
    private Button clue4;

    @FXML
    private Button clue5;

    @FXML
    private Button clue6;

    @FXML
    private Button clue7;

    @FXML
    private Button clue8;
    @FXML
    private TextField firstField1;

    @FXML
    private TextField firstField2;

    @FXML
    private TextField fourthField1;

    @FXML
    private TextField fourthField2;

    @FXML
    private TextField secondField1;

    @FXML
    private TextField secondField2;

    @FXML
    private TextField thirdField1;

    @FXML
    private TextField thirdField2 = new TextField();

    @FXML
    private TextField[] textFieldsLeft;
    @FXML
    private TextField[] textFieldsRight;

    @FXML
    protected void instructionAction() {
        openWindowWithStage("instruction.fxml", 900, 600, StageInstance.getInstance().stage);
    }

    @FXML
    void finishButtonAction(ActionEvent event) {
        if(isEmptyTextFields(textFieldsLeft) || isEmptyTextFields(textFieldsRight)) {

            showAlert(
                    Alert.AlertType.ERROR,
                    "Input data is empty",
                    "Қателік! Сіз барлық ұяшықтарға жауап енгізбедіңіз.",
                    "Барлық ұяшықтардың толтырылғанын тексеріп, әрекетті қайталаңыз."
            );

        } else {
            try {

                if (isCorrectNumberLeft(textFieldsLeft) && isCorrectNumberRight(textFieldsRight)) {
                    Answers answers = Answers.getInstance();

                    answers.leftAnswers.add(Integer.parseInt(firstField1.getText()));
                    answers.leftAnswers.add(Integer.parseInt(secondField1.getText()));
                    answers.leftAnswers.add(Integer.parseInt(thirdField1.getText()));
                    answers.leftAnswers.add(Integer.parseInt(fourthField1.getText()));

                    answers.rightAnswers.add(Integer.parseInt(firstField2.getText()));
                    answers.rightAnswers.add(Integer.parseInt(secondField2.getText()));
                    answers.rightAnswers.add(Integer.parseInt(thirdField2.getText()));
                    answers.rightAnswers.add(Integer.parseInt(fourthField2.getText()));

                    openWindowWithStage("firstMethodResult.fxml", 900, 600, StageInstance.getInstance().stage);

                } else {
                    showAlert(
                            Alert.AlertType.ERROR,
                            "Input data is not correct",
                            "Қателік! Сіз қате САН енгіздіңіз.",
                            "Ұяшықтарға дұрыс мәндердің енгізілгеніне көз жеткізіп, әрекетті қайталаңыз."
                    );
                }

            } catch (NumberFormatException exception) {
                showAlert(
                        Alert.AlertType.ERROR,
                        "Input data is not correct",
                        "Қателік! Сіз енгізген мән САН емес.",
                        "Ұяшықтарға дұрыс мәндердің енгізілгеніне көз жеткізіп, әрекетті қайталаңыз."
                );
            }
        }
    }

    protected Boolean isCorrectNumberLeft(TextField[] textFields) {
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

    protected Boolean isCorrectNumberRight(TextField[] textFields) {
        boolean result = true;
        for(TextField textField : textFields) {
            int num = Integer.parseInt(textField.getText());
            if(num != 0 && num != 5 && num != 10 && num != 2) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textFieldsLeft = new TextField[] {
                firstField1, secondField1,
                thirdField1, fourthField1
        };

        textFieldsRight = new TextField[] {
                firstField2, secondField2,
                thirdField2, fourthField2
        };


        File brandingFile = new File("pictures/bulb.png");
        Image bulbImage = new Image(brandingFile.toURI().toString());
        bulb.setImage(bulbImage);
        bulb.setFitWidth(20);
        bulb.setFitHeight(20);

        Tooltip clueTooltip = new Tooltip("Здесь будет высвечиваться какая-нибудь\nподсказка");
        clueTooltip.setTextAlignment(TextAlignment.JUSTIFY);
        clueTooltip.setGraphic(bulb);

        clue1.setTooltip(clueTooltip);
        clue2.setTooltip(clueTooltip);
        clue3.setTooltip(clueTooltip);
        clue4.setTooltip(clueTooltip);
        clue5.setTooltip(clueTooltip);
        clue6.setTooltip(clueTooltip);
        clue7.setTooltip(clueTooltip);
        clue8.setTooltip(clueTooltip);
    }
}
