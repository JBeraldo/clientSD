package com.sd.client.view.menu;

import com.sd.client.app.repositories.LoginRepository;
import com.sd.client.app.storage.LoggedUser;
import com.sd.client.view.Client;
import com.sd.client.view.base.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuController extends BaseController {
    public MenuItem add_usr_btn;
    public MenuBar menu_bar;
    public MenuItem list_usr_btn;
    public MenuItem edit_self_btn;
    LoginRepository loginRepository = new LoginRepository();

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
}
