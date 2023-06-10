module com.example.erasyldiplomapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.web;


    opens com.example.erasyldiplomapp to javafx.fxml;
    exports com.example.erasyldiplomapp;
}