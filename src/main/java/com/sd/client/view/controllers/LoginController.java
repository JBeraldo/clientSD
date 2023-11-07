package com.sd.client.view.controllers;

import com.sd.client.app.repositories.LoginRepository;
import com.sd.client.view.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController extends BaseController {
    @FXML
    public TextField email_tf;
    @FXML
    public TextField passwd_tf;
    public Button login_btn;

    LoginRepository login_repository = new LoginRepository();


    public LoginController() {
    }

    @FXML
    protected void login() {
        String email = email_tf.getText();
        String password = passwd_tf.getText();
        String next_screen = login_repository.login(email,password);
        Client.changeScreen(getStage(login_btn),next_screen);
    }


}