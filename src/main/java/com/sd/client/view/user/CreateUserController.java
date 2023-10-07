package com.sd.client.view.user;

import com.sd.client.app.models.User;
import com.sd.client.app.repositories.UserRepository;
import com.sd.client.view.base.BaseController;
import com.sd.client.view.base.ValidationResponse;
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

    public void create(ActionEvent actionEvent) {
        UserRepository userRepository = new UserRepository(getApp());
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
        userRepository.create(new_usr);
    }
}
