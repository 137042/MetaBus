package com.example.metabus.presentation.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        URL location = new File("src/main/resources/com/example/metabus/scene/login.fxml").toURI().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Scene scene = new Scene(fxmlLoader.load(location), 1000, 600);
        stage.setTitle("MetaBus");
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
