package com.sd.client.view.controllers;

import com.sd.client.app.models.User;
import com.sd.client.app.repositories.UserRepository;
import com.sd.client.view.Client;
import com.sd.client.view.validators.ValidationResponse;
import com.sd.client.view.validators.UserValidator;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class CreateUserController extends BaseController {
    public TextField name_tf;
    public TextField email_tf;
    public TextField passwd_tf;
    public Button create_btn;
    public CheckBox admin_chk;

    UserRepository userRepository = new UserRepository();


    public void create(ActionEvent actionEvent) {
        ValidationResponse validationResponse;
        String name = name_tf.getText();
        String email = email_tf.getText();
        String password = passwd_tf.getText();
        boolean admin = admin_chk.isSelected();
        validationResponse = UserValidator.validate(password,email);
        if (validationResponse.isError()){
            UserValidator.errorAlert(validationResponse);
            return;
        }
        User new_usr = new User(name,password,email,admin);
        Client.changeScreen(getStage(create_btn),userRepository.create(new_usr));

    }

    public void back(){
        Client.changeScreen(getStage(create_btn),"menu/menu_admin.fxml");
    }
}
