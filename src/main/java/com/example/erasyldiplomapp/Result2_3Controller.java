package com.example.erasyldiplomapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Result2_3Controller extends WindowFunctionality implements Initializable {

    private static final String YES = "ИӘ";
    private static final String NO = "ЖОҚ";
    private final Answers2_3 instance = Answers2_3.getInstance();
    private final Answers2_2 instance2_2 = Answers2_2.getInstance();
    @FXML
    private Button mainButton;

    @FXML
    private Text redText;

    @FXML
    private Text resultText;

    double result = 0;

    @FXML
    void buttonAction() {
        openWindowWithStage("hello-view.fxml", 900, 600, StageInstance.getInstance().stage);
        instance.answers.clear();
        instance2_2.avg = 0;
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> answers = instance.answers;

            if (answers.get(0).equals(YES))
                result = instance2_2.avg + 0.0841;
            else if (answers.get(0).equals(NO))
                result = instance2_2.avg * 1;

            if (answers.get(1).equals(YES))
                result = result + 0.11;
            else if (answers.get(1).equals(NO))
                result = result * 1;

            if (answers.get(2).equals(YES))
                result = result + 0.126;
            else if (answers.get(2).equals(NO))
                result = result * 1;

//        double scale = Math.pow(10, 3);
//        result = Math.ceil(result * scale) / scale;

        redText.setText(String.valueOf(result));

        String text = null;
        if(result >= 0.45) {
            text = "IV  деңгей - тұтастай алғанда мемлекет үшін АСА МАҢЫЗЫ ЖОҒАРЫ және басқа объектілерге елеулі ықпал етуге қабілетті объектілер";
        } else if(result >= 0.35 && result < 0.45) {
            text = "III  деңгей - өмірлік маңызы бар объектілер және олардың жұмысын тоқтату немесе бұзу аймақтық МАҢЫЗЫ бар дағдарыстық жағдайға әкеледі.";
        } else if(result >= 0.25 && result < 0.35) {
            text = "II деңгей - жұмыстың бұзылуы немесе тоқтатылуы жергілікті маңызы бар дағдарыстық жағдайға әкеп соғатын АЙНАЛМА объектілер.";
        } else if(result < 0.25) {
            text = "I деңгей - жергілікті маңызы бар дағдарыстық жағдайды бұзатын немесе тоқтататын объектілер.";
        }
        resultText.setText(text);

    }
}
