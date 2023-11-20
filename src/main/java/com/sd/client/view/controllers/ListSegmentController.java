package com.sd.client.view.controllers;

import com.sd.client.app.models.Segment;
import com.sd.client.app.repositories.SegmentRepository;
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


public class ListSegmentController extends BaseController implements Initializable {

    public List<Segment> segment_ll = new LinkedList<>();
    public SegmentRepository segmentRepository = new SegmentRepository();
    public SelectionModel<Segment> selected_segment_model;
    public Segment selected_segment;
    public ObservableList<Segment> segments = FXCollections.observableList(segment_ll);
    public ListView<Segment> segment_list;
    public Button refreshButton;
    public Button edit_btn;
    public Button remove_btn;

    public void refresh() {
        segments.setAll(segmentRepository.get());
        segment_list.setItems(segments);
        segment_list.refresh();
    }

    public void removeSegment(ActionEvent actionEvent) {
        segmentRepository.destroy(selected_segment);
        refresh();
    }

    public void editSegment(ActionEvent actionEvent) {
        Client.changeScreen(getStage(remove_btn),"segment/edit_segment.fxml",selected_segment.getId());
    }

    public void back(){
        Client.changeScreen(getStage(remove_btn),"menu/menu_admin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        segment_list.setCellFactory(ComboBoxListCell.forListView(segments));

        selected_segment_model = segment_list.getSelectionModel();
        selected_segment_model.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Handle the selection change here
            selected_segment = newValue;
            remove_btn.setDisable(false);
            edit_btn.setDisable(false);
        });
        refresh();
    }
}
