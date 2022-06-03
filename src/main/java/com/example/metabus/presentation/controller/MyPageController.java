package com.example.metabus.presentation.controller;

import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.service.FacilityService;
import com.example.metabus.service.HistoryService;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
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
        HistoryService historyService = new HistoryService();
        List<Facility> visitedList = historyService.getUserHistoryOfFacility(LoginController.user_id);

        try{
            ObservableList<FacilityTableData> facList = FXCollections.observableArrayList();
            for(int i = 0; i < visitedList.size(); i++){
                facList.addAll(
                    new FacilityTableData(
                        new SimpleStringProperty(
                                facilityService.getFacilityGroupCategoryName(visitedList.get(i).getName()).get(0).getCategoryName()),
                        new SimpleStringProperty(visitedList.get(i).getName()),
                        new SimpleStringProperty(visitedList.get(i).getAddress())
                    )
                );
            }

            groupCol.setCellValueFactory(cellData -> cellData.getValue().getGroup());
            nameCol.setCellValueFactory(cellData -> cellData.getValue().getName());
            addressCol.setCellValueFactory(cellData -> cellData.getValue().getAddress());
            tblFacility.setItems(facList);
        } catch(Exception e){
            e.printStackTrace();
        }
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
