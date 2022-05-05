package com.example.metabus;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegController implements Initializable {

    @FXML
    TextField txtName, txtId;
    @FXML
    PasswordField txtPw;
    @FXML
    Button btnReg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void register(){
        Stage stage = (Stage) btnReg.getScene().getWindow();
        stage.close();
        // 가입이 성공하면 창이 꺼지도록 설계
    }

    private void checkId(){

    }

}
