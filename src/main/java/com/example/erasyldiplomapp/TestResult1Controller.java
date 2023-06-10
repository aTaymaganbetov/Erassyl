package com.example.erasyldiplomapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestResult1Controller extends WindowFunctionality implements Initializable {

    private Connection connection;

    ObservableList<Result> observableList = FXCollections.observableArrayList();

    String INSERT_INTO_RESULT = "INSERT INTO result_1 (city, org, points, date)" +
            " VALUES (?, ?, ?, ?)";

    private final Answers answers = Answers.getInstance();
    @FXML
    private Text resultText;
    @FXML
    private Text redAVG;

    private final List<Double> X = new ArrayList<>();
    private double average;


    @FXML
    void backToMenuAction() {
        X.clear();
        answers.leftAnswers.clear();
        answers.rightAnswers.clear();
        answers.recommendList.clear();
        openWindowWithStage("hello-view.fxml", 900, 600, StageInstance.getInstance().stage);
    }

    @FXML
    void onFullRecommendAction() {
        openWindowWithStage("firstMethodResultFull.fxml", 600, 400, new Stage());
    }

    @FXML
    void onDbAction() {
        openWindowWithStage("result_first_detail.fxml", 900, 600, StageInstance.getInstance().stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Answers answers = Answers.getInstance();

        try{
            connection = new DatabaseConnection().getConnection();
        } catch (Exception e){
            Logger.getLogger(TestResult1Controller.class.getName()).log(Level.SEVERE,null,e);
        }

        for(int i = 0; i < answers.rightAnswers.size(); i++) {
            double result = (answers.leftAnswers.get(i)+answers.rightAnswers.get(i))/20.0;
            X.add(result);
        }

        double sum = 0;
        for(double item : X) {
            sum = sum + item;
        }
        average = sum/8.0;

        redAVG.setText(String.valueOf(average));

        String text = null;
        String textDb = null;
        if(average >= 0 && average <= 0.3) {
            text = "Объектідегі қауіпті жүзеге асыру мүмкіндігі ТӨМЕН деп танылады.";
            textDb = "ТӨМЕН қауіп";
        } else if(average > 0.3 && average <= 0.6) {
            text="Объектіде қауіпті іске асыру мүмкіндігі ОРТАША деп танылады (қатерді іске асыру болмашы жағымсыз салдарға әкелуі мүмкін);";
            textDb = "ОРТАША қауіп";
        } else if(average > 0.6 && average <= 0.8) {
            text="Объектіде қауіптің жүзеге асу мүмкіндігі ЖОҒАРЫ деп танылады (қатерді жүзеге асыру жағымсыз салдарға әкелуі мүмкін);";
            textDb = "ЖОҒАРЫ қауіп";
        } else if(average > 0.8) {
            text="Объектіде қауіптің жүзеге асу мүмкіндігі ӨТЕ ЖОҒАРЫ деп танылады (қатерді жүзеге асыру елеулі теріс салдарға әкелуі мүмкін).";
            textDb = "ӨТЕ ЖОҒАРЫ қауіп";
        }
        resultText.setText(text);

        ///////// DATABASE
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_RESULT);
            preparedStatement.setString(1, Answers.getInstance().city);
            preparedStatement.setString(2, Answers.getInstance().org);
            preparedStatement.setString(3, textDb);
            preparedStatement.setString(4, getTime());

            preparedStatement.executeUpdate();
            System.out.println("Данные о туре успешно добавлены!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        addToRecommendedList(
                1,
                "\tПайдаланушы енгізген деректерді тексеру.",
                "\tФайлдық жүйенің кейбір нысандарына кіру құқығын шектеу.",
                "\tПайдаланушы енгізген деректерді тексеру;\n" +
                        "\tФайлдық жүйенің кейбір нысандарына кіру құқығын шектеу."
        );

        addToRecommendedList(
                2,
                "\tБағдарламалық жасақтаманы қолданар алдында оның осалдығын немесе бағдарламалық жасақтаманы қолданар алдында тексеру.",
                "\tБағдарламалық жасақтаманы жаңарту.",
                "\tБағдарламалық жасақтаманы қолданар алдында ондағы осалдықтардың бар-жоғын немесе бағдарламалық жасақтаманы қолданар алдында тексеру.\n" +
                        "\tБағдарламалық жасақтаманы толығымен жаңарту."
        );

        addToRecommendedList(
                3,
                "\tВиртуалды инфрақұрылымның құрамына кіретін белсенді және (немесе) пассивті виртуалды және (немесе) физикалық желілік жабдықтың функционалдық мүмкіндіктерін (әлсіздіктердің болуымен) шектеу.",
                "\tАталған жабдықтың бағдарламалық және (немесе) микробағдарламалық қамтамасыз етудің осалдықтарын пайдалану жолымен теңшелеу.",
                "\tВиртуалды инфрақұрылымның құрамына кіретін белсенді және (немесе) пассивті виртуалды және (немесе) физикалық желілік жабдықтың функционалдық мүмкіндіктерін (әлсіздіктердің болуымен) шектеу;\n" +
                        "\tАталған жабдықтың бағдарламалық және (немесе) микробағдарламалық қамтамасыз етудің осалдықтарын пайдалану жолымен теңшелеу."
        );

        addToRecommendedList(
                4,
                "\tАқпаратты сұрыптау және сыныптарға бөлу, пайдаланушылар үшін деректерге төзімділік деңгейлерін анықтау.",
                "\tПайдаланушылар арасында ақпарат беру мүмкіндіктерін бағалау (қызметкерлердің бір-бірімен байланысын орнату).",
                "\tАқпаратты сұрыптау және сыныптарға бөлу, пайдаланушылар үшін деректерге төзімділік деңгейлерін анықтау;\n" +
                        "\tПайдаланушылар арасында ақпарат беру мүмкіндіктерін бағалау (қызметкерлердің бір-бірімен байланысын орнату)."
        );

        addToRecommendedList(
                5,
                "\tАқпаратты ағып кетуден және деректер ағынын бақылаудан қорғау шараларын тұжырымдау.",
                "\tКриптографиялық құралдардың көмегімен перифериялық құрылғыларға енгізілетін және шығарылатын ақпаратты қорғауды жүзеге асыру.",
                "\tАқпаратты ағып кетуден қорғау және деректер ағынын бақылау шараларын тұжырымдау;\n" +
                        "\tКриптографиялық құралдардың көмегімен перифериялық құрылғыларға енгізілетін және шығарылатын ақпаратты қорғауды жүзеге асыру."
        );

        addToRecommendedList(
                6,
                "\tЖелілік өзара әрекеттесу механизмдерін теңшеңіз.",
                "\tЖелілерді тексеру арқылы деректер ағынын жүзеге асыру мүмкіндігін болдырмаңыз.",
                "\tЖелілік өзара әрекеттесу механизмдерін теңшеңіз;\n" +
                        "\tЖелілерді тексеру арқылы деректер ағынын жүзеге асыру мүмкіндігін болдырмаңыз."
        );

        addToRecommendedList(
                7,
                "\tҰйым деңгейінде желілік трафикті және антивирустық бақылауды сүзіңіз.",
                "\tПайдаланушылардың жүйеге жұмыс орындарынан сенімсіз мазмұны бар сайттарға кіруін бақылау.",
                "\tҰйым деңгейінде желілік трафикті және антивирустық бақылауды сүзіңіз;\n" +
                        "\tПайдаланушылардың жүйеге жұмыс орындарынан сенімсіз мазмұны бар сайттарға кіруін бақылаңыз."
        );

        addToRecommendedList(
                8,
                "\tНормативтік құқықтық базаның толықтығын қамтамасыз ету; бақылау-өткізу режимін жүргізуді қайта қарау және күшейту.",
                "\tҚұпия сипаттағы мәліметтердің сақталуына жауапкершілікті қамтамасыз ету.",
                "\tПайдаланушы енгізген деректерді тексеріңіз;\n" +
                        "\tФайлдық жүйенің кейбір нысандарына кіру құқығын шектеңіз."
        );

    }

    public void addDataToDB() {

    }



    private void addToRecommendedList(
            int questionNum,
            String text1,
            String text2,
            String text3
    ) {
        if(X.get(0) > 0.3 && X.get(0) < 0.6) {
            answers.recommendList.add("\t" + questionNum + "-сұрақ\n" + text1);
        } else if(X.get(0) > 0.6 && X.get(0) < 0.8) {
            answers.recommendList.add("\t" + questionNum + "-сұрақ\n" + text2);
        } else if(X.get(0) > 0.8) {
            answers.recommendList.add("\t" + questionNum + "-сұрақ\n" + text3);
        }
    }
}
