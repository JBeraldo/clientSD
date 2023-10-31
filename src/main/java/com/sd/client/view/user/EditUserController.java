package com.sd.client.view.user;

import com.sd.client.app.models.User;
import com.sd.client.app.repositories.AuthRepository;
import com.sd.client.app.repositories.UserRepository;
import com.sd.client.view.Client;
import com.sd.client.view.base.BaseController;
import com.sd.client.view.base.ValidationResponse;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditUserController extends BaseController implements Initializable {
    public TextField name_tf;
    public TextField email_tf;
    public TextField passwd_tf;
    public Button edit_btn;
    public CheckBox admin_chk;

    public User user;
    UserRepository userRepository = new UserRepository();


    public void edit(ActionEvent actionEvent) {
        ValidationResponse validationResponse;
        String name = name_tf.getText();
        String email = email_tf.getText();
        String password = passwd_tf.getText();
        boolean admin = admin_chk.isSelected();
        validationResponse = UserValidator.validate(password,email,true);
        if (validationResponse.isError()){
            UserValidator.errorAlert(validationResponse);
            return;
        }
        User updated_usr = new User(user.getId(),name,password,email,admin);
        Client.changeScreen(getStage(edit_btn),userRepository.update(updated_usr));
    }

    public void back(){
        Client.changeScreen(getStage(edit_btn),"menu/menu_admin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        state_idProperty().addListener((ob,n,n1)->{
            user = AuthRepository.isCurrentUserAdmin() ? userRepository.find(n1.longValue()) : userRepository.findSelf();
            name_tf.setText(user.getName());
            email_tf.setText(user.getEmail());
            admin_chk.setSelected(user.isAdm());
            if(AuthRepository.isCurrentUserAdmin()){
                admin_chk.setDisable(false);
            }
        });

    }
}
