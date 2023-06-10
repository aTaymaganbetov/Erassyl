package com.example.erasyldiplomapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultFirstDetailController extends WindowFunctionality implements Initializable {

    @FXML
    private TableColumn<Result, String> AuthorColumn;

    @FXML
    private TableColumn<Result, String> DateColumn;

    @FXML
    private TableColumn<Result, Integer> IdColumn;

    @FXML
    private TableColumn<Result, String> PointsColumn;

    @FXML
    private TableColumn<Result, String> StatusColumn;

    @FXML
    private TableView<Result> resultTableView;

    private Connection connection;

    ObservableList<Result> observableList = FXCollections.observableArrayList();

    @FXML
    protected void backWindowAction() {
        openWindowWithStage("firstMethodResult.fxml", 900, 600, StageInstance.getInstance().stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            connection = new DatabaseConnection().getConnection();
            updateTable();
        } catch (Exception e){
            Logger.getLogger(ResultFirstDetailController.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    String SELECT_ALL_FROM_RESULT = "SELECT * FROM result_1";

    StringBuilder text = new StringBuilder();

    private void updateTable (){

        observableList.clear();

        try {
            ResultSet rs = connection.createStatement().executeQuery(SELECT_ALL_FROM_RESULT);
            text.append(String.format("%5s | %10s | %10s | %15s | %20s |\n",
                    "ID", "Қала", "Ұйым атауы", "Нәтиже", "Уақыты"));
            text.append(String.format("%5s | %10s | %10s | %15s | %20s |\n",
                    "-----", "----------", "----------", "---------------", "--------------------"));
            while (rs.next()){
                Integer id = Integer.valueOf(rs.getString("id"));
                String city = rs.getString("city");
                String org = rs.getString("org");
                String points = rs.getString("points");
                String date = rs.getString("date");

                observableList.add(new Result(id, city, org, points, date));


                text.append(
                        String.format("%5d | %10s | %10s | %15s | %20s |\n",
                                id, city, org, points, date)
                );
            }

        } catch (SQLException e){
            Logger.getLogger(ResultFirstDetailController.class.getName()).log(Level.SEVERE,null,e);
        }

        IdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        PointsColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("org"));
        AuthorColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        resultTableView.setItems(observableList);

    }

    @FXML
    public void exportAction() throws FileNotFoundException {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\export_result.txt")))
        {
            bw.write(text.toString());
            showAlert(Alert.AlertType.INFORMATION, "Деректер сәтті сақталды", "Жалғастыру үшін OK батырмасын басыңыз", "");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
