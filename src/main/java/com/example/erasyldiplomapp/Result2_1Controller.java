package com.example.erasyldiplomapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Result2_1Controller extends WindowFunctionality implements Initializable {

    private static final String YES = "ИӘ";
    private static final String NO = "ЖОҚ";
    private final Answers2_1 instance = Answers2_1.getInstance();

    @FXML
    private Text detailResult;

    @FXML
    private Button mainButton;

    @FXML
    private Text titleResult;;

    private boolean isAvailable = false;

    @FXML
    protected void mainButtonAction() {
        if(isAvailable) {
            openWindowWithStage("test2_2.fxml", 900, 600, StageInstance.getInstance().stage);
        } else {
            openWindowWithStage("hello-view.fxml", 900, 600, StageInstance.getInstance().stage);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<String> answers = instance.answers;

        for(String answer : answers) {
            if(answer.equals(YES))
                instance.yesCounter++;
            else if(answer.equals(NO))
                instance.noCounter++;
        }

        isAvailable = instance.yesCounter != 0;

        if(isAvailable) {
            mainButton.setText("Келесі кезеңге өту");
            titleResult.setText("Құттықтаймыз! Сіз келесі кезеңге өттіңіз.");
        } else {
            mainButton.setText("Басты мәзір");
            titleResult.setText("Сіз келесі кезеңге өте алмадыңыз.");
        }
    }
}
