module com.example.metabus {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.metabus to javafx.fxml;
    exports com.example.metabus;
}