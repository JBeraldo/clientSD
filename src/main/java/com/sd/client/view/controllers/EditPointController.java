package com.sd.client.view.controllers;

import com.sd.client.app.models.Point;
import com.sd.client.app.models.User;
import com.sd.client.app.repositories.AuthRepository;
import com.sd.client.app.repositories.PointRepository;
import com.sd.client.app.repositories.UserRepository;
import com.sd.client.view.Client;
import com.sd.client.view.validators.UserValidator;
import com.sd.client.view.validators.ValidationResponse;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditPointController extends BaseController implements Initializable {
    public Button edit_btn;
    public TextArea obs_ta;
    public TextField name_tf;

    public Point point;

    PointRepository pointRepository = new PointRepository();


    public void edit(ActionEvent actionEvent) {
        String name = name_tf.getText();
        String obs = obs_ta.getText();
        Point point = new Point(getState_id(),name,obs);
        Client.changeScreen(getStage(edit_btn),pointRepository.update(point));
    }

    public void back(){
        Client.changeScreen(getStage(edit_btn),"menu/menu_admin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        state_idProperty().addListener((ob,n,n1)->{
            point = pointRepository.find(n1.longValue());
            name_tf.setText(point.getName());
            obs_ta.setText(point.getObservation());
        });

    }
}
