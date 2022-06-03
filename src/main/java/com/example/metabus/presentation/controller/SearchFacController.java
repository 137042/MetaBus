package com.example.metabus.presentation.controller;

import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.persistence.domain.FacilityGroup;
import com.example.metabus.service.FacilityService;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class SearchFacController {

    @FXML
    private TextField txtFac;
    @FXML
    private Button btnSend;
    @FXML
    private TableView<FacilityTableData> tblFacility;
    @FXML
    private TableColumn<FacilityTableData, String> groupCol, nameCol, addressCol;

    public static boolean isSelected = false;
    public static String facInfo = "";

    public void searchFacility(){
        FacilityService facilityService = new FacilityService();
        String input = txtFac.getText().trim();
        List<Facility> tmpList = facilityService.getFacility(input);
        if(tmpList.size() == 0){
            // 해당 키워드를 group 으로 간주해서 group 해당하는 모든? 특정 개수의 시설 조회로 변경
        }
        setTableData(tmpList);
    }

    public void sendData(){
        setFacInfo();
        Stage stage = (Stage) btnSend.getScene().getWindow();
        stage.close();
    }

    private void setTableData(List<Facility> tmpList){
        ObservableList<FacilityTableData> facilityList = FXCollections.observableArrayList();
        for(int i = 0; i < tmpList.size(); i++){
            facilityList.addAll(
//                new FacilityTableData(
//                    new SimpleStringProperty(tmpList.get(i).getGroup()),
//                    new SimpleStringProperty(tmpList.get(i).getName()),
//                    new SimpleStringProperty(tmpList.get(i).getAddress())
//                ) // facility 도메인에 group 포함되지 않아 코드 실행 불가
            );
        }

        groupCol.setCellValueFactory(cellData -> cellData.getValue().getGroup());
        nameCol.setCellValueFactory(cellData -> cellData.getValue().getName());
        addressCol.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        tblFacility.setItems(facilityList);
    }

    private void setFacInfo(){
        try{
            if(tblFacility.getSelectionModel().getSelectedItem().getGroup() != null){
                isSelected = true;
                String name = tblFacility.getSelectionModel().getSelectedItem().getName().get();
                String address = tblFacility.getSelectionModel().getSelectedItem().getAddress().get();
                facInfo = name + "(" + address + ")";
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
