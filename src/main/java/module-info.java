module com.example.metabus {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires com.fasterxml.jackson.databind;
    requires javafx.web;


    opens com.example.metabus to javafx.fxml;
    exports com.example.metabus;
    exports com.example.metabus.view;
    opens com.example.metabus.view to javafx.fxml;
    exports com.example.metabus.controller;
    opens com.example.metabus.controller to javafx.fxml;
}