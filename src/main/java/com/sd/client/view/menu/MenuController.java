package com.sd.client.view.menu;

import com.sd.client.app.repositories.LoginRepository;
import com.sd.client.view.Client;
import com.sd.client.view.base.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuController extends BaseController {
    public MenuItem add_usr_btn;
    public MenuBar menu_bar;


    public void createUser(ActionEvent actionEvent) {
        Client.changeScreen(getStage(menu_bar),"user/create_user.fxml",getApp());
    }
    public void logout(ActionEvent actionEvent) {
        LoginRepository loginRepository = new LoginRepository(getApp());
        if(loginRepository.logout()){
            Client.changeScreen(getStage(menu_bar),"login/login.fxml",getApp());
        }
    }
}
