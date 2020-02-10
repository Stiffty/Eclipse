package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class Controller {
    public TextField text1;
    public ProgressIndicator prozent;
    public Button button1;
    public TableView table;
    public TextField columnName;
    public Button addColumn;
    private final ObservableList<Testdata> data =  FXCollections.observableArrayList(new Testdata("23","Tom"),new Testdata("33","Tim"));

    public void gh(ActionEvent actionEvent) {
        text1.setText("Hallo");
    }

    public void prozentup(MouseEvent mouseEvent) {
        prozent.setProgress(prozent.getProgress()+0.1);
    }

    public void add(MouseEvent mouseEvent) {
        System.out.println(columnName.getText());
        var tb =  new TableColumn(columnName.getText());
        tb.setMinWidth(200);
       tb.setCellValueFactory(
                new PropertyValueFactory<Testdata, String>("name"));
        table.getColumns().addAll(tb);
        table.setItems(data);
    }
}

