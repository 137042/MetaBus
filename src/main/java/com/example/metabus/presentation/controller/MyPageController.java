package com.example.metabus.presentation.controller;

import com.example.metabus.service.FacilityService;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MyPageController implements Initializable {

    @FXML
    private Button btnSend;
    @FXML
    private RadioButton rdoStart, rdoEnd;
    @FXML
    private TableView<FacilityTableData> tblFacility;
    @FXML
    private TableColumn<FacilityTableData, String> groupCol, nameCol, addressCol;

    public static String facInfo = "";
    public static int facInfoFor = 0;

    private ToggleGroup toggleGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggleGroup = new ToggleGroup();
        rdoStart.setToggleGroup(toggleGroup);
        rdoEnd.setToggleGroup(toggleGroup);
        setTblFacility();
    }

    public void sendData(){
        setFacInfo();
        Stage stage = (Stage) btnSend.getScene().getWindow();
        stage.close();
    }

    private void setTblFacility(){
        FacilityService facilityService = new FacilityService();
        // 사용자 시설 기록 조회 기능 없어서 불가
        ObservableList<FacilityTableData> fufList = FXCollections.observableArrayList(
                new FacilityTableData(new SimpleStringProperty("그룹"), new SimpleStringProperty("시설명"), new SimpleStringProperty("주소"))
        );
        groupCol.setCellValueFactory(cellData -> cellData.getValue().getGroup());
        nameCol.setCellValueFactory(cellData -> cellData.getValue().getName());
        addressCol.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        tblFacility.setItems(fufList);
    }

    private void setFacInfo(){
        try{
            if(tblFacility.getSelectionModel().getSelectedItem().getGroup() != null){
                Toggle toggle = toggleGroup.getSelectedToggle();

                String name = tblFacility.getSelectionModel().getSelectedItem().getName().get();
                String address = tblFacility.getSelectionModel().getSelectedItem().getAddress().get();
                facInfo = name + "(" + address + ")";

                if(toggle == rdoStart){
                    facInfoFor = 1;
                }
                else{
                    facInfoFor = 2;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
