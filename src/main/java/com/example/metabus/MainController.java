package com.example.metabus;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableView<TableRowDataModel> myTableView;
    @FXML
    private TableColumn<TableRowDataModel, String> busColumn;
    @FXML
    private TableColumn<TableRowDataModel, String> scheColumn;
    @FXML
    private TableColumn<TableRowDataModel, String> stopColumn;
    @FXML
    private TableColumn<TableRowDataModel, String> leftColumn;

    public void initialize(URL location, ResourceBundle resources){
        ObservableList<TableRowDataModel> myList = FXCollections.observableArrayList(
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장")),
                new TableRowDataModel(new SimpleStringProperty("버스 번호"), new SimpleStringProperty("남은 시간"), new SimpleStringProperty("현재 위치"), new SimpleStringProperty("남은 정류장"))
                );

        busColumn.setCellValueFactory(cellData -> cellData.getValue().getBus());
        scheColumn.setCellValueFactory(cellData -> cellData.getValue().getSchedule());
        stopColumn.setCellValueFactory(cellData -> cellData.getValue().getCur_stop());
        leftColumn.setCellValueFactory(cellData -> cellData.getValue().getLeft());

        myTableView.setItems(myList);
    }
}