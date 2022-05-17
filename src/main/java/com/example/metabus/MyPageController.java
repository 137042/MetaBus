package com.example.metabus;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MyPageController implements Initializable {

    @FXML
    private Label lblName;
    @FXML
    private Button btnSend;
    @FXML
    private TableView<FacilityTableData> tblCF, tblFUF;
    @FXML
    private TableView<RouteTableData> tblCR, tblFUR;
    @FXML
    private TableColumn<FacilityTableData, String> cfGcol, cfNcol, cfAcol;
    @FXML
    private TableColumn<RouteTableData, String> crScol, crEcol;
    @FXML
    private TableColumn<FacilityTableData, String> fufGcol, fufNcol, fufAcol;
    @FXML
    private TableColumn<RouteTableData, String> furScol, furEcol;

    private String[] route = {"startSt", "endSt"};
    private String[] facility = {"fGroup", "fName", "fAddress"};
    private boolean routeSelected;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblName.setText(getUserName());
        setCF();
        setCR();
        setFUF();
        setFUR();
    }

    private String getUserName (){
        String name = "user";
        // 접속된 유저의 이름 받기
        return name;
    }

    private void setCF(){
        ObservableList<FacilityTableData> cfList = FXCollections.observableArrayList(
                new FacilityTableData(new SimpleStringProperty("그룹"), new SimpleStringProperty("시설명"), new SimpleStringProperty("주소"))
        );
        cfGcol.setCellValueFactory(cellData -> cellData.getValue().getGroup());
        cfNcol.setCellValueFactory(cellData -> cellData.getValue().getName());
        cfAcol.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        tblCF.setItems(cfList);
    }

    private void setCR(){
        ObservableList<RouteTableData> crList = FXCollections.observableArrayList(
                new RouteTableData(new SimpleStringProperty("출발 정류장"), new SimpleStringProperty("도착 정류장"))
        );
        crScol.setCellValueFactory(cellData -> cellData.getValue().getStartSt());
        crEcol.setCellValueFactory(cellData -> cellData.getValue().getEndSt());
        tblCR.setItems(crList);
    }

    private void setFUF(){
        ObservableList<FacilityTableData> fufList = FXCollections.observableArrayList(
                new FacilityTableData(new SimpleStringProperty("그룹"), new SimpleStringProperty("시설명"), new SimpleStringProperty("주소"))
        );
        fufGcol.setCellValueFactory(cellData -> cellData.getValue().getGroup());
        fufNcol.setCellValueFactory(cellData -> cellData.getValue().getName());
        fufAcol.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        tblFUF.setItems(fufList);
    }

    private void setFUR(){
        ObservableList<RouteTableData> furList = FXCollections.observableArrayList(
                new RouteTableData(new SimpleStringProperty("출발 정류장"), new SimpleStringProperty("도착 정류장"))
        );
        furScol.setCellValueFactory(cellData -> cellData.getValue().getStartSt());
        furEcol.setCellValueFactory(cellData -> cellData.getValue().getEndSt());
        tblFUR.setItems(furList);
    }

    @FXML
    public void clickFacilityFromCF(MouseEvent event) {
        if(event.getClickCount() == 2){
            facility[0] = tblCF.getSelectionModel().getSelectedItem().getGroup().toString();
            facility[1] = tblCF.getSelectionModel().getSelectedItem().getName().toString();
            facility[2] = tblCF.getSelectionModel().getSelectedItem().getAddress().toString();
            routeSelected = false;
        }
    }

    @FXML
    public void clickRouteFromCR(MouseEvent event){
        if(event.getClickCount() == 2){
            route[0] = tblCR.getSelectionModel().getSelectedItem().getStartSt().toString();
            route[1] = tblCR.getSelectionModel().getSelectedItem().getEndSt().toString();
            routeSelected = true;
        }
    }

    @FXML
    public void clickFacilityFromFUF(MouseEvent event) {
        if(event.getClickCount() == 2){
            facility[0] = tblFUF.getSelectionModel().getSelectedItem().getGroup().toString();
            facility[1] = tblFUF.getSelectionModel().getSelectedItem().getName().toString();
            facility[2] = tblFUF.getSelectionModel().getSelectedItem().getAddress().toString();
            routeSelected = false;
        }
    }

    @FXML
    public void clickRouteFromFUR(MouseEvent event){
        if(event.getClickCount() == 2){
            route[0] = tblFUR.getSelectionModel().getSelectedItem().getStartSt().toString();
            route[1] = tblFUR.getSelectionModel().getSelectedItem().getEndSt().toString();
            routeSelected = false;
        }
    }

    public void sendData(){
        if(routeSelected){
            // 루트 저보 전송
        }
        else{
            //시설 정보 전송
        }

        Stage stage = (Stage) btnSend.getScene().getWindow();
        stage.close();
    }

}
