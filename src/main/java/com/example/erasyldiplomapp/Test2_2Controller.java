package com.example.erasyldiplomapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Test2_2Controller extends WindowFunctionality implements Initializable {

    @FXML
    private final ImageView bulb = new ImageView();

    private final Answers2_2 instance = Answers2_2.getInstance();

    @FXML
    private Button clue1;

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
    private TextField fifthField1;

    @FXML
    private TextField fifthField2;

    @FXML
    private TextField fifthField3;

    @FXML
    private TextField firstField1;

    @FXML
    private TextField firstField2;

    @FXML
    private TextField firstField3;

    @FXML
    private TextField fourthField1;

    @FXML
    private TextField fourthField2;

    @FXML
    private TextField fourthField3;

    @FXML
    private Button nextButton;

    @FXML
    private Text questionText1;

    @FXML
    private Text questionText2;

    @FXML
    private Text questionText3;

    @FXML
    private Text questionText4;

    @FXML
    private Text questionText5;

    @FXML
    private Text questionText6;

    @FXML
    private TextField secondField1;

    @FXML
    private TextField secondField2;

    @FXML
    private TextField secondField3;

    @FXML
    private TextField sixthField1;

    @FXML
    private TextField sixthField2;

    @FXML
    private TextField sixthField3;

    @FXML
    private TextField thirdField1;

    @FXML
    private TextField thirdField2;

    @FXML
    private TextField thirdField3;

    @FXML
    private TextField[] textFieldsMin;

    @FXML
    private TextField[] textFieldsMax;
    @FXML
    private TextField[] textFieldsAVG;

    @FXML
    void instructionAction() {
        openWindowWithStage("instruction2_2", 900, 600, StageInstance.getInstance().stage);
    }

    @FXML
    void nextButtonAction() {
        if(isEmptyTextFields(textFieldsMin) || isEmptyTextFields(textFieldsMax) || isEmptyTextFields(textFieldsAVG)) {
            showAlert(
                    Alert.AlertType.ERROR,
                    "Input data is empty",
                    "Қателік! Сіз барлық ұяшықтарға жауап енгізбедіңіз.",
                    "Барлық ұяшықтардың толтырылғанын тексеріп, әрекетті қайталаңыз."
            );
        } else {
            try {
                if (isCorrectNumber(textFieldsMin) && isCorrectNumber(textFieldsMax)
                && isCorrectNumber(textFieldsAVG) && isCorrectAVG(textFieldsAVG)
                && isMaxMoreThanMin()) {

                    instance.first.add(Integer.parseInt(firstField1.getText()));
                    instance.first.add(Integer.parseInt(firstField2.getText()));
                    instance.first.add(Integer.parseInt(firstField3.getText()));

                    instance.second.add(Integer.parseInt(secondField1.getText()));
                    instance.second.add(Integer.parseInt(secondField2.getText()));
                    instance.second.add(Integer.parseInt(secondField3.getText()));

                    instance.third.add(Integer.parseInt(thirdField1.getText()));
                    instance.third.add(Integer.parseInt(thirdField2.getText()));
                    instance.third.add(Integer.parseInt(thirdField3.getText()));

                    instance.fourth.add(Integer.parseInt(fourthField1.getText()));
                    instance.fourth.add(Integer.parseInt(fourthField2.getText()));
                    instance.fourth.add(Integer.parseInt(fourthField3.getText()));

                    instance.fifth.add(Integer.parseInt(fifthField1.getText()));
                    instance.fifth.add(Integer.parseInt(fifthField2.getText()));
                    instance.fifth.add(Integer.parseInt(fifthField3.getText()));

                    instance.sixth.add(Integer.parseInt(sixthField1.getText()));
                    instance.sixth.add(Integer.parseInt(sixthField2.getText()));
                    instance.sixth.add(Integer.parseInt(sixthField3.getText()));

                    openWindowWithStage("result2_2.fxml", 900, 600, StageInstance.getInstance().stage);

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
                        "Ұяшықтарға САН мәндерінің енгізілгеніне көз жеткізіп, әрекетті қайталаңыз."
                );
            }
        }
    }

    @Override
    protected Boolean isCorrectNumber(TextField[] textFields) {
        boolean result = true;
        for(TextField textField : textFields) {
            int num = Integer.parseInt(textField.getText());
            if(num < 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    protected Boolean isCorrectAVG(TextField[] textFieldsAVG) {
        boolean result = true;
        int count = 0;
        for(TextField textFieldAVG : textFieldsAVG) {
            int avg = Integer.parseInt(textFieldAVG.getText());
            if((avg > Integer.parseInt(textFieldsMax[count].getText())) || (avg < Integer.parseInt(textFieldsMin[count].getText()))) {
                result = false;
                break;
            }
            count++;
        }
        return result;
    }

    protected Boolean isMaxMoreThanMin() {
        boolean result = true;
        int count = 0;
        for(TextField textFieldMax : textFieldsMax) {
            int max = Integer.parseInt(textFieldMax.getText());
            int min = Integer.parseInt(textFieldsMin[count].getText());
            count++;
            if(max < min) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textFieldsMin = new TextField[] {
                firstField1,
                secondField1,
                thirdField1,
                fourthField1,
                fifthField1,
                sixthField1
        };

        textFieldsMax = new TextField[] {
                firstField2,
                secondField2,
                thirdField2,
                fourthField2,
                fifthField2,
                sixthField2
        };

        textFieldsAVG = new TextField[] {
                firstField3,
                secondField3,
                thirdField3,
                fourthField3,
                fifthField3,
                sixthField3
        };

        File brandingFile = new File("pictures/bulb.png");
        Image bulbImage = new Image(brandingFile.toURI().toString());
        bulb.setImage(bulbImage);
        bulb.setFitWidth(20);
        bulb.setFitHeight(20);

        Tooltip clueTooltip = new Tooltip("X_i - көрсеткіштердің нақты мәні;\n" +
                "Min және Max - тиісінше индикатордың ең төменгі және ең жоғары мәні");
        clueTooltip.setTextAlignment(TextAlignment.JUSTIFY);
        clueTooltip.setGraphic(bulb);

        clue1.setTooltip(clueTooltip);
        clue2.setTooltip(clueTooltip);
        clue3.setTooltip(clueTooltip);
        clue4.setTooltip(clueTooltip);
        clue5.setTooltip(clueTooltip);
        clue6.setTooltip(clueTooltip);
    }
}
