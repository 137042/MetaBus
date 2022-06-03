package com.example.metabus.presentation.controller;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

import com.example.metabus.persistence.domain.BusNumber;
import com.example.metabus.persistence.domain.BusStation;
import com.example.metabus.presentation.view.Popup;
import com.example.metabus.service.BusService;

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
import java.util.ArrayList;
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
    private TableColumn<StationTableData, String> startCheckCol, endCheckCol;

    @FXML
    private Button btnOut;
    @FXML
    public Label lblStart, lblEnd;

    private BusService busService;
    private ObservableList<ArrivalTableData> routeList;

    @Override
    public void initialize(URL location, ResourceBundle resources){
//        mapViewer = new MapViewer();
//        mapViewer.setMaxSize(550.0, 550.0);
//        mapViewer.setPadding(new Insets(10, 10, 10, 100));
//        layoutGrid.add(mapViewer, 0, 1);
        routeList = FXCollections.observableArrayList();
        busService = new BusService();
    }

    public void openMyPage() throws IOException {
        Popup.myPageDisplay();
        if(MyPageController.facInfoFor == 1){
            lblStart.setText(MyPageController.facInfo);
            MyPageController.facInfo = "";
            fillTblStart();
        }
        else if(MyPageController.facInfoFor == 2){
            lblEnd.setText(MyPageController.facInfo);
            MyPageController.facInfo = "";
            fillTblEnd();
        }
    }

    public void clearBusStop(){
        final String START_FAC_NOTICE = "출발 시설이 이곳에 노출됩니다";
        final String END_FAC_NOTICE = "도착 시설이 이곳에 노출됩니다";
        tblStart.setItems(null);
        tblEnd.setItems(null);
        lblStart.setText(START_FAC_NOTICE);
        lblEnd.setText(END_FAC_NOTICE);
    }

    public void refreshBus(){
        setLeftTime();
        startCol.setCellValueFactory(cellData -> cellData.getValue().getStartStation().asObject());
        endCol.setCellValueFactory(cellData -> cellData.getValue().getEndStation().asObject());
        busCol.setCellValueFactory(cellData -> cellData.getValue().getBus());
        leftCol.setCellValueFactory(cellData -> cellData.getValue().getLeftTime().asObject());
        tblArrival.setItems(routeList);
    }

    public void searchStartFac() throws IOException {
        Popup.searchFacDisplay();
        if(SearchFacController.isSelected){
            lblStart.setText(SearchFacController.facInfo);
            fillTblStart();
            SearchFacController.facInfo = "";
            SearchFacController.isSelected = false;
        }
    }

    public void searchEndFac() throws IOException {
        Popup.searchFacDisplay();
        if(SearchFacController.isSelected){
            lblEnd.setText(SearchFacController.facInfo);
            fillTblEnd();
            SearchFacController.facInfo = "";
            SearchFacController.isSelected = false;
        }
    }

    public void searchRoute(){
        makeRouteList();
        refreshBus();
    }

    public void logOut() {
        final String PATH_LOGIN = "src/main/resources/com/example/metabus_client/scene/login.fxml";
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

    private void fillTblStart(){
        List<BusStation> tmpList = busService.getAroundBusStation(lblStart.getText());
        ObservableList<StationTableData> startList = FXCollections.observableArrayList();
        for (BusStation busStation : tmpList) {
            startList.addAll(
                    new StationTableData(
                            new SimpleIntegerProperty(busStation.getServiceId()),
                            new SimpleStringProperty(busStation.getName())
                    )
            );
        }

        startCheckCol.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        startIdCol.setCellValueFactory(cellData -> cellData.getValue().getStationId().asObject());
        startNameCol.setCellValueFactory(cellData -> cellData.getValue().getStationName());
        tblStart.setItems(startList);
    }

    private void fillTblEnd(){
        List<BusStation> tmpList = busService.getAroundBusStation(lblEnd.getText());
        ObservableList<StationTableData> endList = FXCollections.observableArrayList();
        for (BusStation busStation : tmpList) {
            endList.addAll(
                new StationTableData(
                    new SimpleIntegerProperty(busStation.getServiceId()),
                    new SimpleStringProperty(busStation.getName())
                )
            );
        }

        endCheckCol.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        endIdCol.setCellValueFactory(cellData -> cellData.getValue().getStationId().asObject());
        endNameCol.setCellValueFactory(cellData -> cellData.getValue().getStationName());
        tblEnd.setItems(endList);
    }

    private List<StationTableData> makeStopList(boolean isForStart){
        ObservableList<StationTableData> tblCols;
        List<StationTableData> stopList = new ArrayList<>();
        if(isForStart){
            tblCols = tblStart.getItems();
        }
        else{
            tblCols = tblEnd.getItems();
        }

        for (StationTableData tmpData : tblCols) {
            if (tmpData.getCheckBox().isSelected()) {
                stopList.add(tmpData);
            }
        }
        return stopList;
    }

    private void makeRouteList(){
        List<StationTableData> startList = makeStopList(true);
        List<StationTableData> endList = makeStopList(false);
        List<BusNumber> tmpList;

        ObservableList<ArrivalTableData> tmpTbl = FXCollections.observableArrayList();
        for(int i = 0; i < startList.size(); i++){
            for(int j = 0; j < endList.size(); j++) { // 버스 이름 넘어가도록 수정
                System.out.println(startList.get(i).getStationId().getValue() + " " + endList.get(j).getStationId().getValue());
                tmpList = busService.getDirectBusFromDepartureToArrival(startList.get(i).getStationId().getValue(), endList.get(j).getStationId().getValue());
                for (BusNumber busNumber : tmpList) {

                    tmpTbl.addAll(
                        new ArrivalTableData(
                            new SimpleIntegerProperty(startList.get(i).getStationId().getValue()),
                            new SimpleIntegerProperty(endList.get(j).getStationId().getValue()),
                            new SimpleStringProperty(busNumber.getBusNumber()),
                            new SimpleIntegerProperty(0)
                        )
                    );

                }
            }
        }
        System.out.println("\n\n\n" + tmpTbl + "\n\n\n");
        startCol.setCellValueFactory(cellData -> cellData.getValue().getStartStation().asObject());
        endCol.setCellValueFactory(cellData -> cellData.getValue().getEndStation().asObject());
        busCol.setCellValueFactory(cellData -> cellData.getValue().getBus());
        leftCol.setCellValueFactory(cellData -> cellData.getValue().getLeftTime().asObject());
        tblArrival.setItems(tmpTbl);
    }

    private void setLeftTime(){
        for (ArrivalTableData arrivalTableData : routeList) {
            // bus api 요청해서 밑에 넣어주기 routeList.get(i).getBus()
            int lt = 0;
            arrivalTableData.setLeftTime(new SimpleIntegerProperty(lt));
        }
    }

}