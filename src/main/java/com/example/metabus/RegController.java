package com.example.metabus;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegController implements Initializable {

    @FXML
    TextField txtName, txtId;
    @FXML
    PasswordField txtPw;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void register(){
        // 가입이 성공하면 창이 꺼지도록 설계
    }

    private void checkId(){

    }

}
