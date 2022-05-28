package com.example.metabus.presentation.controller;

import com.example.metabus.presentation.view.Popup;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainController implements Initializable {

//    public class MapViewer extends StackPane {
//
//        WebView webView = new WebView();
//        WebEngine webEngine = webView.getEngine();
//
//        public MapViewer() {
//            webEngine.load("http://mare137042.dothome.co.kr/");
//            webEngine.setOnAlert(new EventHandler<WebEvent<String>>() {
//                @Override
//                public void handle(WebEvent<String> e) {
//                    System.out.println(e.toString());
//                }
//            });
//            getChildren().add(webView);
//        }
//    }

//    @FXML
//    private GridPane layoutGrid;
//    private MapViewer mapViewer;

    @FXML
    private TableView<ArrivalTableData> tblArrival;
    @FXML
    private TableColumn<ArrivalTableData, Integer> startCol;
    @FXML
    private TableColumn<ArrivalTableData, Integer> endCol;
    @FXML
    private TableColumn<ArrivalTableData, String> busCol;
    @FXML
    private TableColumn<ArrivalTableData, Integer> leftCol;

    @FXML
    private TableView<StationTableData> tblStart, tblEnd;
    @FXML
    private TableColumn<StationTableData, Integer> startIdCol, endIdCol;
    @FXML
    private TableColumn<StationTableData, String> startNameCol, endNameCol;
    @FXML
    private TableColumn startCheckCol, endCheckCol;

    @FXML
    private Button btnOut;
    @FXML
    public Label lblStart, lblEnd;

    private final String PATH_LOGIN = "src/main/resources/com/example/metabus/scene/login.fxml";
    private final String START_FAC_NOTICE = "출발 시설이 이곳에 노출됩니다";
    private final String END_FAC_NOTICE = "도착 시설이 이곳에 노출됩니다";

    @Override
    public void initialize(URL location, ResourceBundle resources){
//        mapViewer = new MapViewer();
//        mapViewer.setMaxSize(550.0, 550.0);
//        mapViewer.setPadding(new Insets(10, 10, 10, 100));
//        layoutGrid.add(mapViewer, 0, 1);
    }

    public void openMyPage() throws IOException {
        Popup.myPageDisplay();
    }

    public void clearBusStop(){
        tblStart.setItems(null);
        tblEnd.setItems(null);
        lblStart.setText(START_FAC_NOTICE);
        lblEnd.setText(END_FAC_NOTICE);
    }

    public void refreshBus(){

//        ObservableList<ArrivalTableData> arrivalList  = jsonparse.getList();
        ObservableList<ArrivalTableData> arrivalList = FXCollections.observableArrayList(
                new ArrivalTableData(
                        new SimpleIntegerProperty(10167),
                        new SimpleIntegerProperty(10080),
                        new SimpleStringProperty("191-3"),
                        new SimpleIntegerProperty(30)
                )
        );

        startCol.setCellValueFactory(cellData -> cellData.getValue().getStartStation().asObject());
        endCol.setCellValueFactory(cellData -> cellData.getValue().getEndStation().asObject());
        busCol.setCellValueFactory(cellData -> cellData.getValue().getBus());
        leftCol.setCellValueFactory(cellData -> cellData.getValue().getLeftTime().asObject());
        tblArrival.setItems(arrivalList);
    }

    public void searchStartFac() throws IOException {
        Popup.searchFacDisplay();
        lblStart.setText(SearchFacController.facInfo);
        SearchFacController.facInfo = "";
        fillTblStart();
    }

    public void searchEndFac() throws IOException {
        Popup.searchFacDisplay();
        lblEnd.setText(SearchFacController.facInfo);
        SearchFacController.facInfo = "";
        fillTblEnd();
    }

    public void checkRoute(){
        // start table과 end table의 체크된 객체를 받아서 연결하는 쿼리 전송해서 refresh로 날리기
        refreshBus();
    }

    public void logOut() {
        Stage stage = (Stage) btnOut.getScene().getWindow();
        try {
            URL location = new File(PATH_LOGIN).toURI().toURL();
            Parent second = FXMLLoader.load(location);
            Scene scene = new Scene(second);
            stage.setResizable(false);
            stage.setMaximized(false);
            stage.setFullScreen(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getStopsNearByFac(){
        //query get list 파싱 필요? dao로 바로 받으면 메소드 합치기
    }

    private void fillTblStart(){
        ObservableList<StationTableData> startList = FXCollections.observableArrayList(
                new StationTableData(
                        new SimpleIntegerProperty(10167),
                        new SimpleStringProperty("신나리")
                ),
                new StationTableData(
                        new SimpleIntegerProperty(10168),
                        new SimpleStringProperty("신나리")
                ),
                new StationTableData(
                        new SimpleIntegerProperty(10169),
                        new SimpleStringProperty("신나리")
                ),
                new StationTableData(
                        new SimpleIntegerProperty(10163),
                        new SimpleStringProperty("신나리")
                ),
                new StationTableData(
                        new SimpleIntegerProperty(10162),
                        new SimpleStringProperty("신나리")
                )
        );

        startCheckCol.setCellValueFactory(new PropertyValueFactory<StationTableData, String>("checkBox"));
        startIdCol.setCellValueFactory(cellData -> cellData.getValue().getStationId().asObject());
        startNameCol.setCellValueFactory(cellData -> cellData.getValue().getStationName());
        tblStart.setItems(startList);
    }

    private void fillTblEnd(){
        ObservableList<StationTableData> endList = FXCollections.observableArrayList(
                new StationTableData(
                        new SimpleIntegerProperty(90167),
                        new SimpleStringProperty("신나리")
                ),
                new StationTableData(
                        new SimpleIntegerProperty(90367),
                        new SimpleStringProperty("신나리")
                ),
                new StationTableData(
                        new SimpleIntegerProperty(90467),
                        new SimpleStringProperty("신나리")
                ),
                new StationTableData(
                        new SimpleIntegerProperty(90267),
                        new SimpleStringProperty("신나리")
                )
        );

        endCheckCol.setCellValueFactory(new PropertyValueFactory<StationTableData, String>("checkBox"));
        endIdCol.setCellValueFactory(cellData -> cellData.getValue().getStationId().asObject());
        endNameCol.setCellValueFactory(cellData -> cellData.getValue().getStationName());
        tblEnd.setItems(endList);
    }

    private void makeStopList(){
        ObservableList<StationTableData> startTblCols = tblStart.getItems();
        ObservableList<StationTableData> endTblCols = tblEnd.getItems();

        List<Integer> startList = null, endList = null;

        for (StationTableData tmpData : startTblCols) {
            if (tmpData.getCheckBox().isSelected()) {
                System.out.println(tmpData.getStationId());
                startList.add(tmpData.getStationId().getValue());
            }
        }

        for(StationTableData tmpData : endTblCols){
            if (tmpData.getCheckBox().isSelected()) {
                System.out.println(tmpData.getStationId().getValue());
                endList.add(tmpData.getStationId().getValue());
            }
        }

        System.out.println();
    }

}
