package com.example.clientsd.view.login;

import com.example.clientsd.app.App;
import com.example.clientsd.app.repositories.LoginRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    public TextField email_tf;
    @FXML
    public TextField passwd_tf;
    public Button login_btn;

    private LoginRepository login_repository;

    public LoginController(){
        this.login_repository = new LoginRepository();
    }

    @FXML
    protected void login() throws InterruptedException {
        String email = email_tf.getText();
        String password = passwd_tf.getText();
        login_repository.login(email,password);
    }
}