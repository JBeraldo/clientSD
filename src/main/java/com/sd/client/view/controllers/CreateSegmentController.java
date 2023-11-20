package com.sd.client.view.controllers;

import com.sd.client.app.models.Point;
import com.sd.client.app.models.Segment;
import com.sd.client.app.repositories.PointRepository;
import com.sd.client.app.repositories.SegmentRepository;
import com.sd.client.view.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateSegmentController extends BaseController implements Initializable {
    public Button create_btn;
    public ComboBox<Point> origin_cmb;
    public ComboBox<Point> destination_cmb;
    public ComboBox<String> direction_cmb;
    public TextField distance_tf;
    public TextArea obs_ta;

    PointRepository pointRepository = new PointRepository();
    SegmentRepository segmentRepository = new SegmentRepository();

    public ObservableList<Point> points;

    public void create(ActionEvent actionEvent) {
        String obs = obs_ta.getText();
        Point origin = origin_cmb.getValue();
        Point destination = destination_cmb.getValue();
        String direction = direction_cmb.getValue();
        String distance = distance_tf.getText();
        Segment segment = new Segment(direction,origin,destination,distance,obs);
        Client.changeScreen(getStage(create_btn),segmentRepository.create(segment));
    }

    public void back(){
        Client.changeScreen(getStage(create_btn),"menu/menu_admin.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        points = FXCollections.observableList(pointRepository.get());
        destination_cmb.getItems().addAll(points);
        origin_cmb.getItems().addAll(points);
        direction_cmb.getItems().addAll("Frente","Esquerda","Direita","Atrás");
    }
}
