package com.example.metabus.presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegController {

    @FXML
    private TextField txtName, txtId;
    @FXML
    private PasswordField txtPw;
    @FXML
    private Button btnReg;
    @FXML
    private Label lblErrName, lblErrId, lblErrPw;

    private final String ERROR_EMPTY_NAME = "이름을 입력해주세요";
    private final String ERROR_EMPTY_ID = "아이디를 입력해주세요";
    private final String ERROR_EMPTY_PW = "비밀번호를 입력해주세요";
    private final String ERROR_DUPLICATE_ID = "해당 아이디는 사용할 수 없어요";

    public void clearLabel(){
        lblErrName.setText("");
        lblErrId.setText("");
        lblErrPw.setText("");
    }

    public void register(){
        String name = txtName.getText().trim();
        String id = txtId.getText().trim();
        String pw = txtPw.getText().trim();

        if(isValidReq(name, id, pw)){
            if(isNewId(name, id, pw)){
                Stage stage = (Stage) btnReg.getScene().getWindow();
                stage.close();
            }
            else{
                lblErrId.setText(ERROR_DUPLICATE_ID);
            }
        }
    }

    private void clearInput(){
        txtName.clear();
        txtId.clear();
        txtPw.clear();
    }

    private boolean isValidReq(String name, String id, String pw){
        boolean res = true;
        if(name.equals("")){
            lblErrName.setText(ERROR_EMPTY_NAME);
            res = false;
        }
        if(id.equals("")){
            lblErrId.setText(ERROR_EMPTY_ID);
            res = false;
        }
        if(pw.equals("")){
            lblErrPw.setText(ERROR_EMPTY_PW);
            res = false;
        }
        return res;
    }

    private boolean isNewId(String name, String id, String pw){
        // query -> error occur(duplicate id) -> false
        try{

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
