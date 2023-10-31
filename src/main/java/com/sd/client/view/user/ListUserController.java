package com.sd.client.view.user;

import com.sd.client.app.models.User;
import com.sd.client.app.repositories.UserRepository;
import com.sd.client.view.Client;
import com.sd.client.view.base.BaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.cell.ComboBoxListCell;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;


public class ListUserController extends BaseController implements Initializable {

    public List<User> users_ll = new LinkedList<>();
    public UserRepository userRepository = new UserRepository();
    public SelectionModel<User> selected_user_model;
    public User selected_user;
    public ObservableList<User> users = FXCollections.observableList(users_ll);
    public ListView<User> user_list;
    public Button refreshButton;
    public Button edit_btn;
    public Button remove_btn;

    public void refresh() {
        users.setAll(userRepository.get());
        user_list.setItems(users);
        user_list.refresh();
    }

    public void removeUser(ActionEvent actionEvent) {
        userRepository.destroy(selected_user);
        refresh();
    }

    public void editUser(ActionEvent actionEvent) {
        Client.changeScreen(getStage(remove_btn),"user/edit_user.fxml",selected_user.getId());
    }

    public void back(){
        Client.changeScreen(getStage(remove_btn),"menu/menu_admin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user_list.setCellFactory(ComboBoxListCell.forListView(users));

        selected_user_model = user_list.getSelectionModel();
        selected_user_model.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Handle the selection change here
            selected_user = newValue;
            remove_btn.setDisable(false);
            edit_btn.setDisable(false);
        });
        refresh();
    }
}
