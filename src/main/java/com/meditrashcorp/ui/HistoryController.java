package com.meditrashcorp.ui;

import com.mediTrash.app.Data.WasteDisposal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.meditrashcorp.ui.LoginController.usernameText_s;
import static com.meditrashcorp.ui.MainApplication.dcf;


public class HistoryController implements Initializable {

    @FXML
    private TableView<WasteDisposal> table;

    @FXML
    private TableColumn<WasteDisposal, String> datum;
    @FXML
    private TableColumn<WasteDisposal, String> col_tr;

    @FXML
    private Button del;
    @FXML
    private TableColumn<WasteDisposal, String> col_osoba;

    @FXML
    private TableColumn<WasteDisposal, String> col_zpusobNakl;

    @FXML
    private TableColumn<WasteDisposal, String> col_cat;

    @FXML
    private TableColumn<WasteDisposal, String> col_amount;

    @FXML
    private TableColumn<WasteDisposal, String> col_user;

    private WasteDisposal selected;
    private int index;
    private ObservableList<WasteDisposal> w;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_user.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_tr.setCellValueFactory(new PropertyValueFactory<>("trashName"));
        col_cat.setCellValueFactory(new PropertyValueFactory<>("category"));
        col_amount.setCellValueFactory(new PropertyValueFactory<>("count"));
        col_osoba.setCellValueFactory(new PropertyValueFactory<>("ico"));
        col_zpusobNakl.setCellValueFactory(new PropertyValueFactory<>("code"));
        datum.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.getColumns().clear();
        table.getColumns().add(col_user);
        table.getColumns().add(col_tr);
        table.getColumns().add(col_cat);
        table.getColumns().add(col_amount);
        table.getColumns().add(col_osoba);
        table.getColumns().add(col_zpusobNakl);
        table.getColumns().add(datum);
        try {
             w = FXCollections.observableArrayList(dcf.waste(usernameText_s.getText()));
            table.setItems(w);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        table.setOnMouseClicked(e -> {
            for(WasteDisposal t : table.getSelectionModel().getSelectedItems()) {
                selected = t;
                index = w.indexOf(t);
            }
        });

    }

    @FXML
    public void delOnAction(ActionEvent ev) {
        if (selected != null) {
            try {
                dcf.DeleteWasteDisposal(selected.getVhid());
                table.getItems().remove(index);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }



}
