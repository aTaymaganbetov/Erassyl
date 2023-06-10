package com.example.erasyldiplomapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class InstructionController extends WindowFunctionality implements Initializable {

    @FXML
    private WebView webView;

    @FXML
    private WebEngine webEngine;

    private double webZoom = 0;


    @FXML
    void backButtonAction() {
        if(Answers.getInstance().leftAnswers.size()>=4) {
            openWindowWithStage("firstMethod_2.fxml", 900, 600, StageInstance.getInstance().stage);
        } else {
            openWindowWithStage("firstMethod_1.fxml", 900, 600, StageInstance.getInstance().stage);
        }
    }

    @FXML
    void zoomIn() {
        webZoom+=0.25;
        webView.setZoom(webZoom);
    }

    @FXML
    void zoomOut() {
        webZoom-=0.25;
        webView.setZoom(webZoom);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webEngine = webView.getEngine();
        webEngine.load("https://adilet.zan.kz/kaz/docs/P1600000529#z0");
    }
}
