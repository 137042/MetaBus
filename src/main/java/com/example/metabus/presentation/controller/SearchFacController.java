package com.example.metabus.presentation.controller;

import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.persistence.domain.FacilityGroup;
import com.example.metabus.service.FacilityService;

import com.example.metabus.service.HistoryService;
import com.example.metabus.service.MemberService;
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
        List<Facility> tmpList = facilityService.getFacilities(input);
        if(tmpList.size() == 0){
            // 해당 키워드를 group 으로 간주해서 group 해당하는 시설 조회로 변경
            // 하려고 했으나 table 연관관계가 설계대로 안 나와서 불가능해짐
        }
        setTableData(tmpList);
    }

    public void sendData(){
        setFacInfo();
        Stage stage = (Stage) btnSend.getScene().getWindow();
        stage.close();
    }

    private void setTableData(List<Facility> tmpList){
        FacilityService facilityService = new FacilityService();
        ObservableList<FacilityTableData> facilityList = FXCollections.observableArrayList();
        for(int i = 0; i < tmpList.size(); i++){
            facilityList.addAll(
                new FacilityTableData(
                    new SimpleStringProperty(
                            facilityService.getFacilityGroupCategoryName(tmpList.get(i).getName()).get(0).getCategoryName()),
                    new SimpleStringProperty(tmpList.get(i).getName()),
                    new SimpleStringProperty(tmpList.get(i).getAddress())
                )
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
                insertHistory(name);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    private void insertHistory(String name){
        MemberService memberService = new MemberService();
        HistoryService historyService = new HistoryService();
        int userId = memberService.getPI(LoginController.user_id);
        historyService.insertUserFacilityHistory(userId, name, 0);
    }
}
