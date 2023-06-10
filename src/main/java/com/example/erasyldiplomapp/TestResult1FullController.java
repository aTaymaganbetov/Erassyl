package com.example.erasyldiplomapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TestResult1FullController implements Initializable {

    private final Answers answers = Answers.getInstance();

    List<String> recommendeds;


    int counter = 0;

    @FXML
    private Text text;

    @FXML
    void backAction() {
        if(counter > 0) {
            counter--;
            text.setText(recommendeds.get(counter));
        }
    }

    @FXML
    void nextAction() {
        if(counter < recommendeds.size()-1) {
            counter++;
            text.setText(recommendeds.get(counter));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        counter = 0;
        text.setTextAlignment(TextAlignment.JUSTIFY);
        recommendeds = answers.recommendList;
        text.setText(recommendeds.get(counter));
    }
}
