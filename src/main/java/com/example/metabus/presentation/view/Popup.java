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
        final String PATH_REGISTER = "src/main/resources/com/example/metabus/scene/register.fxml";
        URL location = new File(PATH_REGISTER).toURI().toURL();
        Scene scene = new Scene(FXMLLoader.load(location), 300, 300);
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("MetaBus - Register");
        popup.setResizable(false);
        popup.setMaximized(false);
        popup.setFullScreen(false);
        popup.setScene(scene);
        popup.showAndWait();
    }

    public static void findPwDisplay() throws IOException {
        final String PATH_FIND_PW = "src/main/resources/com/example/metabus/scene/findPw.fxml";
        URL location = new File(PATH_FIND_PW).toURI().toURL();
        Scene scene = new Scene(FXMLLoader.load(location), 300, 300);
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("MetaBus - Find Password");
        popup.setResizable(false);
        popup.setMaximized(false);
        popup.setFullScreen(false);
        popup.setScene(scene);
        popup.showAndWait();
    }

    public static void myPageDisplay() throws IOException {
        final String PATH_MY_PAGE = "src/main/resources/com/example/metabus/scene/myPage.fxml";
        URL location = new File(PATH_MY_PAGE).toURI().toURL();
        Scene scene = new Scene(FXMLLoader.load(location), 600, 400);
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("MetaBus - MyPage");
        popup.setResizable(false);
        popup.setMaximized(false);
        popup.setFullScreen(false);
        popup.setScene(scene);
        popup.showAndWait();
    }

    public static void searchFacDisplay() throws IOException {
        final String PATH_SEARCH_FAC = "src/main/resources/com/example/metabus/scene/searchFac.fxml";
        URL location = new File(PATH_SEARCH_FAC).toURI().toURL();
        Scene scene = new Scene(FXMLLoader.load(location), 600, 400);
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("MetaBus - Search Facility");
        popup.setResizable(false);
        popup.setMaximized(false);
        popup.setFullScreen(false);
        popup.setScene(scene);
        popup.showAndWait();
    }

}
