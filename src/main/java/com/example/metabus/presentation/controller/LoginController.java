package com.example.metabus.presentation.controller;

import com.example.metabus.presentation.view.Popup;
import com.example.metabus.service.MemberService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LoginController {

    @FXML
    private TextField txtId;
    @FXML
    private PasswordField txtPw;
    @FXML
    private Button btnLogin, btnClose;
    @FXML
    private Label lblErrId, lblErrPw;

    public static String user_id;

    public void clearLbl(){
        lblErrId.setText("");
        lblErrPw.setText("");
    }

    public void login() {
        String id = txtId.getText().trim();
        String pw = txtPw.getText().trim();

        if(isValidReq(id, pw)){
            if(isCorrectPw(id, pw)){
                user_id = id;
                goMainPage();
            }
        }
    }

    public void register() throws IOException {
        clearInput();
        Popup.regDisplay();
    }

    public void findPw() throws IOException {
        clearInput();
        Popup.findPwDisplay();
    }

    public void close(){
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    private void clearInput(){
        txtId.clear();
        txtPw.clear();
    }

    private boolean isValidReq(String id, String pw){
        final String ERROR_EMPTY_ID = "아이디를 입력해주세요";
        final String ERROR_EMPTY_PW = "비밀번호를 입력해주세요";
        boolean res = true;

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

    private boolean isCorrectPw(String id, String pw){
        final String ERROR_WRONG_ID = "아이디를 다시 입력해주세요";
        final String ERROR_WRONG_PW = "비밀번호를 다시 입력해주세요";

        MemberService memberService = new MemberService();
        try{

            if(memberService.UserValidation(id, pw)){
                return true;
            }
        } catch(Exception e){
            e.printStackTrace();
            lblErrId.setText(ERROR_WRONG_ID);
            lblErrPw.setText(ERROR_WRONG_PW);
            return false;
        }
        return true;
    }

    private void goMainPage() {
        final String PATH_MAIN_PAGE = "src/main/resources/com/example/metabus_client/scene/main.fxml";
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        try {
            URL location = new File(PATH_MAIN_PAGE).toURI().toURL();
            Parent second = FXMLLoader.load(location);
            Scene scene = new Scene(second);
            stage.setResizable(false);
            stage.setMaximized(false);
            stage.setFullScreen(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}