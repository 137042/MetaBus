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
        final String PATH_LOGIN = "src/main/resources/com/example/metabus/scene/login.fxml";
        final String PATH_MAIN_PAGE = "src/main/resources/com/example/metabus/scene/main.fxml";
        URL location = new File(PATH_LOGIN).toURI().toURL();
        Scene scene = new Scene(FXMLLoader.load(location), 1000, 600);
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

