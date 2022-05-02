package com.example.metabus;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MyPageController implements Initializable {

    @FXML
    Label lblName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblName.setText(getUserName());
    }

    private String getUserName (){
        String name = "user";
        // 접속된 유저의 이름 받기
        return name;
    }
}
