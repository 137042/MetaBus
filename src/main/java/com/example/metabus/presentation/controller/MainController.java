package com.example.metabus.presentation.controller;

import com.example.metabus.presentation.view.Popup;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MainController implements Initializable {

    public class MapViewer extends StackPane {

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        public MapViewer() {
            webEngine.load("http://mare137042.dothome.co.kr/");
            webEngine.setOnAlert(new EventHandler<WebEvent<String>>() {
                @Override
                public void handle(WebEvent<String> e) {
                    System.out.println(e.toString());
                }
            });
            getChildren().add(webView);
        }
    }

    @FXML
    private TableView<ArrivalTableData> tblArrival;
    @FXML
    private TableColumn<ArrivalTableData, String> busColumn;
    @FXML
    private TableColumn<ArrivalTableData, String> scheColumn;
    @FXML
    private TableColumn<ArrivalTableData, String> stopColumn;
    @FXML
    private TableColumn<ArrivalTableData, String> leftColumn;
    @FXML
    private GridPane layoutGrid;
    private MapViewer mapViewer;
    @FXML
    private Button btnOut;

    public void initialize(URL location, ResourceBundle resources){
        ObservableList<ArrivalTableData> myList = FXCollections.observableArrayList(
                new ArrivalTableData(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new ArrivalTableData(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장"))
                );

        busColumn.setCellValueFactory(cellData -> cellData.getValue().getBus());
        scheColumn.setCellValueFactory(cellData -> cellData.getValue().getSchedule());
        stopColumn.setCellValueFactory(cellData -> cellData.getValue().getCurrentStop());
        leftColumn.setCellValueFactory(cellData -> cellData.getValue().getLeftTime());
        tblArrival.setItems(myList);


        mapViewer = new MapViewer();
        mapViewer.setMaxSize(550.0, 550.0);
        mapViewer.setPadding(new Insets(10, 10, 10, 100));
        layoutGrid.add(mapViewer, 0, 1);
    }

    public void openMyPage() throws IOException {
        Popup.myPageDisplay();
    }

    public void logOut(){
        Stage stage = (Stage) btnOut.getScene().getWindow();
        try {
            URL location = new File("src/main/resources/com/example/metabus/scene/login.fxml").toURI().toURL();
            Parent second = FXMLLoader.load(location);
            Scene scene = new Scene(second);
            stage.setResizable(false);
            stage.setMaximized(false);
            stage.setFullScreen(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("ERROR, mainpage -> login");
        }
    }

}
