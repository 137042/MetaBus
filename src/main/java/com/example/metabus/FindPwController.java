package com.example.metabus;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FindPwController implements Initializable {

    @FXML
    private TextField txtId;
    @FXML
    private Label lblStmt, lblPw;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void findPw(){
        txtId.getText();
        // checkId and get password
        lblStmt.setText("Your Password: ");
        lblPw.setText("samplePW");
    }

}