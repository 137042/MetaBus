package com.example.metabus.presentation.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Popup {

    public static void regDisplay() throws IOException {
        URL location = new File("src/main/resources/com/example/metabus/scene/register.fxml").toURI().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Scene scene = new Scene(fxmlLoader.load(location), 300, 300);
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("MetaBus - Register");
        popup.setResizable(false);
        popup.setMaximized(false);
        popup.setFullScreen(false);
        popup.setScene(scene);
        popup.show();
    }

    public static void findPwDisplay() throws IOException {
        URL location = new File("src/main/resources/com/example/metabus/scene/findPw.fxml").toURI().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Scene scene = new Scene(fxmlLoader.load(location), 300, 300);
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("MetaBus - Find Password");
        popup.setResizable(false);
        popup.setMaximized(false);
        popup.setFullScreen(false);
        popup.setScene(scene);
        popup.show();
    }

    public static void myPageDisplay() throws IOException {
        URL location = new File("src/main/resources/com/example/metabus/scene/myPage.fxml").toURI().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Scene scene = new Scene(fxmlLoader.load(location), 600, 400);
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("MetaBus - MyPage");
        popup.setResizable(false);
        popup.setMaximized(false);
        popup.setFullScreen(false);
        popup.setScene(scene);
        popup.show();
    }

}
