package com.sd.client.view.controllers;

import com.sd.client.app.models.Point;
import com.sd.client.app.models.User;
import com.sd.client.app.repositories.PointRepository;
import com.sd.client.view.Client;
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


public class ListPointController extends BaseController implements Initializable {

    public List<Point> point_ll = new LinkedList<>();
    public PointRepository pointRepository = new PointRepository();
    public SelectionModel<Point> selected_point_model;
    public Point selected_point;
    public ObservableList<Point> points = FXCollections.observableList(point_ll);
    public ListView<Point> point_list;
    public Button refreshButton;
    public Button edit_btn;
    public Button remove_btn;

    public void refresh() {
        points.setAll(pointRepository.get());
        point_list.setItems(points);
        point_list.refresh();
    }

    public void removeUser(ActionEvent actionEvent) {
        pointRepository.destroy(selected_point);
        refresh();
    }

    public void editUser(ActionEvent actionEvent) {
        Client.changeScreen(getStage(remove_btn),"point/edit_point.fxml",selected_point.getId());
    }

    public void back(){
        Client.changeScreen(getStage(remove_btn),"menu/menu_admin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        point_list.setCellFactory(ComboBoxListCell.forListView(points));

        selected_point_model = point_list.getSelectionModel();
        selected_point_model.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Handle the selection change here
            selected_point = newValue;
            remove_btn.setDisable(false);
            edit_btn.setDisable(false);
        });
        refresh();
    }
}
