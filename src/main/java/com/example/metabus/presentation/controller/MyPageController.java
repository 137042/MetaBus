package com.example.metabus.presentation.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MyPageController implements Initializable {

    @FXML
    private Button btnSend;
    @FXML
    private TableView<FacilityTableData> tblFacility;
    @FXML
    private TableColumn<FacilityTableData, String> groupCol, nameCol, addressCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTblFacility();
    }

    private void setTblFacility(){
        ObservableList<FacilityTableData> fufList = FXCollections.observableArrayList(
                new FacilityTableData(new SimpleStringProperty("그룹"), new SimpleStringProperty("시설명"), new SimpleStringProperty("주소"))
        );
        groupCol.setCellValueFactory(cellData -> cellData.getValue().getGroup());
        nameCol.setCellValueFactory(cellData -> cellData.getValue().getName());
        addressCol.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        tblFacility.setItems(fufList);
    }

    public void sendData(){

        Stage stage = (Stage) btnSend.getScene().getWindow();
        stage.close();
    }

}
