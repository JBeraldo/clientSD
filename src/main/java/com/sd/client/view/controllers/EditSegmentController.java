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
import java.util.ResourceBundle;

public class EditSegmentController extends BaseController implements Initializable {
    public Button edit_btn;
    public ComboBox<Point> origin_cmb;
    public ComboBox<Point> destination_cmb;
    public ComboBox<String> direction_cmb;
    public TextField distance_tf;
    public TextArea obs_ta;

    Segment segment = new Segment();

    PointRepository pointRepository = new PointRepository();
    SegmentRepository segmentRepository = new SegmentRepository();

    public ObservableList<Point> points;

    public void edit(ActionEvent actionEvent) {
        String obs = obs_ta.getText();
        Point origin = origin_cmb.getValue();
        Point destination = destination_cmb.getValue();
        String direction = direction_cmb.getValue();
        int distance = Integer.parseInt(distance_tf.getText());
        Segment segment = new Segment(getState_id(),direction,origin,destination,distance,obs);
        Client.changeScreen(getStage(edit_btn),segmentRepository.update(segment));
    }

    public void back(){
        Client.changeScreen(getStage(edit_btn),"menu/menu_admin.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        state_idProperty().addListener((ob,n,n1)->{
            points = FXCollections.observableList(pointRepository.get());
            destination_cmb.getItems().addAll(points);
            origin_cmb.getItems().addAll(points);
            direction_cmb.getItems().addAll("Frente","Esquerda","Direita","Atrás");
            segment = segmentRepository.find(n1.longValue());
            destination_cmb.setValue(segment.getDestination());
            origin_cmb.setValue(segment.getOrigin());
            direction_cmb.setValue(segment.getDirection());
            distance_tf.setText(Integer.toString(segment.getDistance()));
            obs_ta.setText(segment.getObservation());
        });
    }
}
