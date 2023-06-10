package com.example.erasyldiplomapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Result2_2Controller extends WindowFunctionality implements Initializable {

    private final Answers2_2 instance = Answers2_2.getInstance();

    double ratio1 = 0.0841;
    double ratio2 = 0.0933;
    double ratio3 = 0.0616;
    double ratio4 = 0.1339;
    double ratio5 = 0.0365;
    double ratio6 = 0.0126;


    @FXML
    private Text redText;

    @FXML
    private Text resultText;

    @FXML
    private Button mainButton;

    @FXML
    void buttonAction() {
        if(instance.avg < 0.25) {
            openWindowWithStage("test2_3.fxml", 900, 600, StageInstance.getInstance().stage);
        } else {
            openWindowWithStage("resultDOP.fxml", 900, 600, StageInstance.getInstance().stage);
            instance.avg = 0;
            instance.first.clear();
            instance.second.clear();
            instance.third.clear();
            instance.fourth.clear();
            instance.fifth.clear();
            instance.sixth.clear();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double first = ((instance.first.get(2)*1.0) / (instance.first.get(1)-instance.first.get(0)))*ratio1;
        double second = ((instance.second.get(2)*1.0) / (instance.second.get(1)-instance.second.get(0)))*ratio2;
        double third = ((instance.third.get(2)*1.0) / (instance.third.get(1)-instance.third.get(0)))*ratio3;
        double fourth = ((instance.fourth.get(2)*1.0) / (instance.fourth.get(1)-instance.fourth.get(0)))*ratio4;
        double fifth = ((instance.fifth.get(2)*1.0) / (instance.fifth.get(1)-instance.fifth.get(0)))*ratio5;
        double sixth = ((instance.sixth.get(2)*1.0) / (instance.sixth.get(1)-instance.sixth.get(0)))*ratio6;

        instance.avg = (first+second+third+fourth+fifth+sixth)/6.0;

        redText.setText(String.valueOf(instance.avg));

        String text = null;

        if(instance.avg < 0.25) {
            mainButton.setText("Келесі кезеңге өту");
            text = "Сіз келесі кезеңге өттіңіз";
        } else {
            mainButton.setText("Нәтижелерді көру");
            text = "Өкінішке орай сіз келесі кезеңге өте алмадыңыз";
        }
        resultText.setText(text);
    }
}
