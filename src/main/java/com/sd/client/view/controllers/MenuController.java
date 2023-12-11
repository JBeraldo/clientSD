package com.sd.client.view.controllers;

import com.sd.client.app.models.User;
import com.sd.client.app.repositories.LoginRepository;
import com.sd.client.app.repositories.UserRepository;
import com.sd.client.app.storage.LoggedUser;
import com.sd.client.view.Client;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class MenuController extends BaseController {
    public MenuItem add_usr_btn;
    public MenuBar menu_bar;
    public MenuItem list_usr_btn;
    public MenuItem edit_self_btn;
    public MenuItem destroy_self_btn1;
    public TextField password_tf;
    public Button back_btn;
    public Button destroy_btn;
    public MenuItem list_pnt_btn;
    public MenuItem add_pnt_btn;
    public MenuItem add_segment_btn;
    public MenuItem list_segments_btn;
    public MenuItem gen_route_btn;
    LoginRepository loginRepository = new LoginRepository();
    UserRepository userRepository = new UserRepository();

    public void createUser(ActionEvent actionEvent) {
        Client.changeScreen(getStage(menu_bar),"user/create_user.fxml");
    }
    public void listUsers(ActionEvent actionEvent) {
        Client.changeScreen(getStage(menu_bar),"user/list_user.fxml");
    }
    public void logout(ActionEvent actionEvent) {
        if(loginRepository.logout()){
            Client.changeScreen(getStage(menu_bar),"login/login.fxml");
        }
    }

    public void editSelf(ActionEvent actionEvent) {
        Client.changeScreen(getStage(menu_bar),"user/edit_user.fxml", LoggedUser.id());
    }



    public void destroySelf(ActionEvent actionEvent) {
        String password = User.passwordMD5(password_tf.getText());
        if(userRepository.destroySelf(password)){
            this.loginRepository.logout();
            Client.changeScreen(getStage(password_tf),"login/login.fxml");
        }
    }

    public void back(ActionEvent actionEvent) {
        Client.changeScreen(getStage(menu_bar),"menu/menu_user.fxml");
    }

    public void openDestroySelfModal(ActionEvent actionEvent) {
        Client.changeScreen(getStage(menu_bar),"user/password_modal.fxml");
    }

    public void createPoint(ActionEvent actionEvent) {
        Client.changeScreen(getStage(menu_bar),"point/create_point.fxml");
    }

    public void listPoints(ActionEvent actionEvent) {
        Client.changeScreen(getStage(menu_bar),"point/list_points.fxml");
    }

    public void createSegment(ActionEvent actionEvent) {
        Client.changeScreen(getStage(menu_bar),"segment/create_segment.fxml");

    }

    public void listSegments(ActionEvent actionEvent) {
        Client.changeScreen(getStage(menu_bar),"segment/list_segments.fxml");

    }

    public void generateRoute(ActionEvent actionEvent) {
        Client.changeScreen(getStage(menu_bar),"route/generate_route.fxml");
    }
}
