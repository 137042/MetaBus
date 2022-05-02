package com.example.metabus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEvent;
import javafx.stage.Stage;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;

import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {

    MyBrowser myBrowser;
    double lat;
    double lon;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        scene.getStylesheets().add("com/example/metabus/stylesheet.css");
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

    public class MyBrowser extends Pane {

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        public MyBrowser() {
            final URL urlGoogleMaps = getClass().getResource("demo.html");
            webEngine.load(urlGoogleMaps.toExternalForm());
            webEngine.setOnAlert(new EventHandler<WebEvent<String>>() {
                @Override
                public void handle(WebEvent<String> e) {
                    System.out.println(e.toString());
                }
            });

            getChildren().add(webView);

            final TextField latitude = new TextField("" + 35.857908 * 1.00007);
            final TextField longitude = new TextField("" + 10.598997 * 1.00007);
            Button update = new Button("Update");
            update.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent arg0) {
                    lat = Double.parseDouble(latitude.getText());
                    lon = Double.parseDouble(longitude.getText());

                    System.out.printf("%.2f %.2f%n", lat, lon);

                    webEngine.executeScript("" +
                            "window.lat = " + lat + ";" +
                            "window.lon = " + lon + ";" +
                            "document.goToLocation(window.lat, window.lon);"
                    );
                }
            });

            HBox toolbar  = new HBox();
            toolbar.getChildren().addAll(latitude, longitude, update);

            getChildren().addAll(toolbar);

        }
    }

}

