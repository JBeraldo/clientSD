package com.sd.client.view.login;

import com.sd.client.app.repositories.LoginRepository;
import com.sd.client.view.Client;
import com.sd.client.view.base.BaseController;
import com.sd.client.view.base.ValidationResponse;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController extends BaseController {
    @FXML
    public TextField email_tf;
    @FXML
    public TextField passwd_tf;
    public Button login_btn;

    private LoginRepository login_repository;

    public LoginController() {
    }

    @FXML
    protected void login() {
        this.login_repository = new LoginRepository(super.getApp());
        String email = email_tf.getText();
        String password = passwd_tf.getText();
        if(login_repository.login(email,password)){
            Client.changeScreen(getStage(login_btn),"menu/menu.fxml",getApp());
        }
    }


}