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


public class TestPage extends javafx.application.Application{

    MyBrowser myBrowser;
    double lat;
    double lon;

    @Override
    public void start(Stage stage) throws IOException {
        myBrowser = new MyBrowser();
        Scene scene = new Scene(myBrowser);

        stage.setScene(scene);
        stage.setWidth(1200);
        stage.setHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public class MyBrowser extends Pane {

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        public MyBrowser() {
            final URL kakaoMap = getClass().getResource("demo.html");
            webEngine.load("http://localhost:8080/map.html");
            webEngine.setOnAlert(new EventHandler<WebEvent<String>>() {
                @Override
                public void handle(WebEvent<String> e) {
                    System.out.println(e.toString());
                }
            });
            getChildren().add(webView);
        }
    }
}
