package com.example.metabus.presentation.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FindPwController {

    @FXML
    private TextField txtId;
    @FXML
    private Label lblPw, lblNoticeUpper, lblNoticeLower;

    private final String NOTICE_UPPER = "입력한 아이디가 존재하면";
    private final String NOTICE_LOWER = "비밀번호가 위에 노출됩니다";
    private final String ERROR_ID = "해당 아이디가 존재하지 않아요";

    public void findPw(){
        String id = txtId.getText().trim();
        if(!id.equals("")){
            String pw = getPwFromDB(id);
            if(!pw.equals("")){
                lblPw.setText(pw);
                lblPw.getStyleClass().add("input");
            }
            else{
                clearNotice();
                lblPw.setText(ERROR_ID);
            }
        }
    }

    public void showNotice(){
        lblNoticeUpper.setText(NOTICE_UPPER);
        lblNoticeLower.setText(NOTICE_LOWER);
        lblPw.setText("");
        lblPw.getStyleClass().remove("input");
    }

    private void clearNotice(){
        lblNoticeUpper.setText("");
        lblNoticeLower.setText("");
    }

    private String getPwFromDB(String id){
        // query -> getPw
        return "";
    }

}