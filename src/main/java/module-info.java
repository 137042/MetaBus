module com.example.metabus {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires org.mybatis;

    exports com.example.metabus;
    opens com.example.metabus to javafx.fxml;
    exports com.example.metabus.presentation.view;
    opens com.example.metabus.presentation.view to javafx.fxml;
    exports com.example.metabus.presentation.controller;
    opens com.example.metabus.presentation.controller to javafx.fxml;
    exports com.example.metabus.service;
    opens com.example.metabus.service to javafx.fxml;
    exports com.example.metabus.persistence.domain;

}