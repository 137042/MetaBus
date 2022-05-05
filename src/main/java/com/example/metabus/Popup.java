package com.example.metabus;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Popup {

    public static void regDisplay() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("reg.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
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
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("findPw.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 300);
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
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("myPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
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
