package com.example.clientsd.view.login;

import com.example.clientsd.app.repositories.LoginRepository;
import com.example.clientsd.view.Client;
import com.example.clientsd.view.base.BaseController;
import com.example.clientsd.view.helpers.Validator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController extends BaseController {
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
        if(password.length() < 6){
            warningAlert("Aviso","Senha inválida","A senha precisa possuir ao menos 6 caractéres");
            return;
        }
        if(!Validator.isValidEmail(email)){
            warningAlert("Aviso","Email inválido","Verifique seu email");
            return;
        }
        if(!validateEmpty(email,password)){
            warningAlert("Aviso","Preencha todos os campos","Preencha todos os campos");
            return;
        }
        login_repository.login(email,password);
    }

    protected boolean validateEmpty(String email,String password){
        if(email == null || email.isEmpty()){
            return false;
        }
        if(email == null || email.isEmpty()){
            return false;
        }
        return true;
    }

}