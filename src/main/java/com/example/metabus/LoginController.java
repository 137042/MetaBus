package com.example.metabus;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField txtId;
    @FXML
    private PasswordField txtPw;
    @FXML
    private Button btnLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void register() throws IOException {
        txtId.clear();
        txtPw.clear();
        Popup.regDisplay();
    }

    public void checkValidId() {
        String tmp = txtId.getText();
        if(tmp.equals("smth")) {
            txtId.clear();
            txtId.setPromptText("retype valid id");
        }
    }

    public void checkValidPw() throws InterruptedException{
        String tmp = txtPw.getText();
        if(tmp.equals("smth")) {
            txtPw.clear();
            txtPw.setPromptText("retype valid pw");
        }
    }

    public void login(){
        // login
        logIn();
    }

    public void findPw() throws IOException {
        Popup.findPwDisplay();
    }

    public void logIn() {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        try {
            Parent second = FXMLLoader.load(getClass().getResource("main.fxml"));
            Scene scene = new Scene(second);
            stage.setResizable(false);
            stage.setMaximized(false);
            stage.setFullScreen(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("ERROR, login -> mainpage");
        }
    }

}