package com.example.metabus;

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
    private TableView<BusTableData> myTableView;
    @FXML
    private TableColumn<BusTableData, String> busColumn;
    @FXML
    private TableColumn<BusTableData, String> scheColumn;
    @FXML
    private TableColumn<BusTableData, String> stopColumn;
    @FXML
    private TableColumn<BusTableData, String> leftColumn;
    @FXML
    private GridPane layoutGrid;
    private MapViewer mapViewer;
    @FXML
    Button btnOut;

    public void initialize(URL location, ResourceBundle resources){
        ObservableList<BusTableData> myList = FXCollections.observableArrayList(
                new BusTableData(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new BusTableData(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장"))
                );

        busColumn.setCellValueFactory(cellData -> cellData.getValue().getBus());
        scheColumn.setCellValueFactory(cellData -> cellData.getValue().getSchedule());
        stopColumn.setCellValueFactory(cellData -> cellData.getValue().getCurrentStop());
        leftColumn.setCellValueFactory(cellData -> cellData.getValue().getLeftTime());
        myTableView.setItems(myList);


        mapViewer = new MapViewer();
        mapViewer.setMaxSize(550.0, 550.0);
        mapViewer.setPadding(new Insets(10, 10, 10, 100));
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

    public void logOut(){
        Stage stage = (Stage) btnOut.getScene().getWindow();
        try {
            Parent second = FXMLLoader.load(getClass().getResource("login.fxml"));
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
