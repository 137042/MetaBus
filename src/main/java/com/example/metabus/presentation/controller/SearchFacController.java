package com.example.metabus.presentation.controller;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchFacController {

    @FXML
    private TextField txtFac;
    @FXML
    private Button btnSearch, btnSend;
    @FXML
    private TableView<FacilityTableData> tblFacility;
    @FXML
    private TableColumn<FacilityTableData, String> groupCol, nameCol, addressCol;

    private boolean isSelected = false;
    public static String facInfo = "";

    public void searchFacility(){
        String input = txtFac.getText().trim();
        // query -> get facility list
        setTableData(input);
    }

    public void sendData(){
        setFacInfo();
        if(isSelected) {
            Stage stage = (Stage) btnSend.getScene().getWindow();
            stage.close();
        }
    }

    private void setTableData(String input){
        ObservableList<FacilityTableData> facilityList = FXCollections.observableArrayList(
                new FacilityTableData(
                        new SimpleStringProperty("그룹"),
                        new SimpleStringProperty("시설명"),
                        new SimpleStringProperty("주소")
                ),
                new FacilityTableData(
                        new SimpleStringProperty("asdff"),
                        new SimpleStringProperty("asfa"),
                        new SimpleStringProperty("asf")
                ),
                new FacilityTableData(
                        new SimpleStringProperty("py8uol"),
                        new SimpleStringProperty("iop"),
                        new SimpleStringProperty("ipoiop")
                )
        );

        groupCol.setCellValueFactory(cellData -> cellData.getValue().getGroup());
        nameCol.setCellValueFactory(cellData -> cellData.getValue().getName());
        addressCol.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        tblFacility.setItems(facilityList);
    }

    private void setFacInfo(){
        if(tblFacility.getSelectionModel().getSelectedItem().getGroup() != null){
            isSelected = true;
            String name = tblFacility.getSelectionModel().getSelectedItem().getName().get();
            String address = tblFacility.getSelectionModel().getSelectedItem().getAddress().get();
            facInfo = name + "(" + address + ")";
        }
    }

}
