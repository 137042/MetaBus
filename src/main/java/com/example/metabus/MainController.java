package com.example.metabus;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainController implements Initializable {

    public class MapViewer extends Pane {

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        public MapViewer() {
//            final URL kakaoMap = getClass().getResource("map.html");
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

    @FXML
    private TableView<TableRowDataModel> myTableView;
    @FXML
    private TableColumn<TableRowDataModel, String> busColumn;
    @FXML
    private TableColumn<TableRowDataModel, String> scheColumn;
    @FXML
    private TableColumn<TableRowDataModel, String> stopColumn;
    @FXML
    private TableColumn<TableRowDataModel, String> leftColumn;
    @FXML
    private GridPane layoutGrid;
    private MapViewer mapViewer;

    public void initialize(URL location, ResourceBundle resources){
        ObservableList<TableRowDataModel> myList = FXCollections.observableArrayList(
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장"))
                );

        busColumn.setCellValueFactory(cellData -> cellData.getValue().getBus());
        scheColumn.setCellValueFactory(cellData -> cellData.getValue().getSchedule());
        stopColumn.setCellValueFactory(cellData -> cellData.getValue().getCur_stop());
        leftColumn.setCellValueFactory(cellData -> cellData.getValue().getLeft());
        myTableView.setItems(myList);


        mapViewer = new MapViewer();
        layoutGrid.add(mapViewer, 0, 1);
    }

//    public JSONObject loadLocation() {
//        String REST_KEY = "{ec53c4bbdb7d799553813f1b58828a49}";
//        Double lat = 0.0;
//        Double lon = 0.0;
//        String tmpUrl = "https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x=" + lon + "&y=" + lat;
//        BufferedReader br = null;
//        JSONObject obj = new JSONObject();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            URL url = new URL(tmpUrl);
//            URLConnection conn = url.openConnection();
//            conn.setRequestProperty("Authorization", "KakaoAK " + REST_KEY);
//            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            if(br != null) obj = mapper.readValue(br, JSONObject.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                br.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } return obj;
//    }

    public void openMyPage() throws IOException {
        Popup.myPageDisplay();
    }

}
