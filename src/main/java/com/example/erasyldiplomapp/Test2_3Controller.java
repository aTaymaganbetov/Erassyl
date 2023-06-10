package com.example.erasyldiplomapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Test2_3Controller extends WindowFunctionality implements Initializable {
    @FXML
    private RadioButton firstNo;

    @FXML
    private RadioButton firstYes;

    @FXML
    private Button nextButton;

    @FXML
    private Text questionText1;

    @FXML
    private Text questionText2;

    @FXML
    private Text questionText3;

    @FXML
    private RadioButton secondNo;

    @FXML
    private RadioButton secondYes;

    @FXML
    private RadioButton thirdNo;

    @FXML
    private RadioButton thirdYes;

    ToggleGroup group1 = new ToggleGroup();
    ToggleGroup group2 = new ToggleGroup();
    ToggleGroup group3 = new ToggleGroup();

    Answers2_3 instance = Answers2_3.getInstance();

    @FXML
    void instructionAction() {
        openWindowWithStage("instruction2_3", 900, 600, StageInstance.getInstance().stage);
    }

    @FXML
    void nextAction() {
        try {

            RadioButton selection1 = (RadioButton) group1.getSelectedToggle();
            String selectedText1 = selection1.getText();

            RadioButton selection2 = (RadioButton) group2.getSelectedToggle();
            String selectedText2 = selection2.getText();

            RadioButton selection3 = (RadioButton) group3.getSelectedToggle();
            String selectedText3 = selection3.getText();

            instance.answers = new ArrayList<>(Arrays.asList(
                    selectedText1, selectedText2, selectedText3
            ));

            openWindowWithStage("result2_3.fxml", 900, 600, StageInstance.getInstance().stage);


        } catch (RuntimeException e) {
            showAlert(
                    Alert.AlertType.INFORMATION,
                    "Incomplete data",
                    "Сіз барлық сұрақтарға жауап бермедіңіз",
                    "Барлық сұрақтарға жауап беріп, әрекетті қайталаңыз"
            );
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstYes.setToggleGroup(group1);
        firstNo.setToggleGroup(group1);
        secondYes.setToggleGroup(group2);
        secondNo.setToggleGroup(group2);
        thirdYes.setToggleGroup(group3);
        thirdNo.setToggleGroup(group3);
    }
}
