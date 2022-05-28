package com.example.metabus.presentation.controller;

import com.example.metabus.service.MemberService;

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

    public void clearLabel(){
        lblErrName.setText("");
        lblErrId.setText("");
        lblErrPw.setText("");
    }

    public void register(){
        final String ERROR_DUPLICATE_ID = "해당 아이디는 사용할 수 없어요";

        String name = txtName.getText().trim();
        String id = txtId.getText().trim();
        String pw = txtPw.getText().trim();

        if(isValidReq(name, id, pw)){
            if(canRegister(name, id, pw)){
                Stage stage = (Stage) btnReg.getScene().getWindow();
                stage.close();
            }
            else{
                lblErrId.setText(ERROR_DUPLICATE_ID);
            }
        }
    }

    private boolean isValidReq(String name, String id, String pw){
        final String ERROR_EMPTY_NAME = "이름을 입력해주세요";
        final String ERROR_EMPTY_ID = "아이디를 입력해주세요";
        final String ERROR_EMPTY_PW = "비밀번호를 입력해주세요";

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

    private boolean canRegister(String name, String id, String pw){
        MemberService memberService = new MemberService();
        return memberService.signUp(name, id, pw);
    }

}
