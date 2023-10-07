package com.sd.client.view.login;

import com.sd.client.app.repositories.LoginRepository;
import com.sd.client.view.Client;
import com.sd.client.view.base.BaseController;
import com.sd.client.view.helpers.Validator;
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
        boolean isLogged = login_repository.login(email,password);
        if(isLogged){
            Client.changeScreen(getStage(login_btn),"menu/menu.fxml",getApp());
        }
    }

    protected boolean validateEmpty(String email,String password){
        if(email == null || email.isEmpty()) return false;
        return password != null && !password.isEmpty();
    }

}