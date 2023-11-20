package com.sd.client.view.controllers;

import com.sd.client.app.models.Point;
import com.sd.client.app.models.User;
import com.sd.client.app.repositories.PointRepository;
import com.sd.client.app.repositories.UserRepository;
import com.sd.client.view.Client;
import com.sd.client.view.validators.ValidationResponse;
import com.sd.client.view.validators.UserValidator;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreatePointController extends BaseController {
    public Button create_btn;
    public TextArea obs_ta;
    public TextField name_tf;

    PointRepository pointRepository = new PointRepository();

    public void create(ActionEvent actionEvent) {
        String name = name_tf.getText();
        String obs = obs_ta.getText();
        Point point = new Point(name,obs);
        Client.changeScreen(getStage(create_btn),pointRepository.create(point));
    }

    public void back(){
        Client.changeScreen(getStage(create_btn),"menu/menu_admin.fxml");
    }
}
