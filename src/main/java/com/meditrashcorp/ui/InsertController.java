package com.meditrashcorp.ui;

import com.mediTrash.app.AuthorisedPersonChange.Functions;
import com.mediTrash.app.Data.AuthorisedPerson;
import com.mediTrash.app.Data.Trash;
import com.mediTrash.app.Data.User;
import com.mediTrash.app.TrashSorting.TrashOutput;
import com.mediTrash.app.ZpusobNakladani.ZpusobNakladani;
import com.mediTrash.app.ZpusobNakladani.zpnklSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;

import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.meditrashcorp.ui.LoginController.*;
import static com.meditrashcorp.ui.MainApplication.dcf;


public class InsertController implements Initializable {

    @FXML
    private TextField odpadTF;

    @FXML
    private DatePicker datum;

    @FXML
    private TextField osobaTF;

    @FXML
    private TextField zpnklTF;

    private ObservableList<Trash> odpad;
    private ObservableList<AuthorisedPerson> osoba;
    private ObservableList<ZpusobNakladani> zpnkl;
    private Trash selectedOdpad;
    private AuthorisedPerson selectedOsoba;
    private ZpusobNakladani selectedZpnkl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        odpad = FXCollections.observableArrayList();
        osoba = FXCollections.observableArrayList();
        zpnkl = FXCollections.observableArrayList();

    }

    public void insertTrashBtnOnAction(ActionEvent event) {
        try {
            if (datum.getValue() == null || selectedOdpad == null || selectedOsoba == null || selectedZpnkl == null) {
                throw new IllegalArgumentException();
            }
            java.util.Date d =
                    java.util.Date.from(datum.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date date = new java.sql.Date(d.getTime());
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            System.out.println(timestamp);
            User u = dcf.getCurUser(usernameText_s.getText(), pswdText_s.getText());
            dcf.InsertVyhazovani(selectedOsoba.getId(), timestamp, dcf.getVHID() + 1, selectedZpnkl.getZpusob(),
                    u.getId(), selectedOdpad.getTrashId());
        } catch (Exception e) {
            e.printStackTrace();
            Alert err = new Alert(Alert.AlertType.ERROR, "");
            err.initModality(Modality.APPLICATION_MODAL);
            err.initOwner(((Node)(event.getSource())).getScene().getWindow());
            err.getDialogPane().setContentText("Prosim, vyberte vse polozky a zadejte datum");
            err.getDialogPane().setHeaderText("Spatne udaje!");
            err.showAndWait();
        }
    }

    // seznam odpadu class Trash
    @FXML
    public void odpadSZOnAction(ActionEvent event) {
        try {
            TableView<Trash> table = new TableView<>();
            TableColumn<Trash, String> cl1 = new TableColumn<>();
            cl1.setCellValueFactory(new PropertyValueFactory<>("nameOfTrash"));
            table.getColumns().clear();
            table.getColumns().add(cl1);
            TrashOutput to = new TrashOutput();
            ArrayList<Trash> tr = to.TrashOutputList();

            odpad.addAll(tr);
            table.setItems(odpad);

            VBox vbox = new VBox();
            vbox.getChildren().addAll(table);
            vbox.setSpacing(10);
            vbox.setAlignment(Pos.CENTER);
            Scene scene = new Scene(vbox);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();

            table.setOnMouseClicked(e -> {
                for (Trash t : table.getSelectionModel().getSelectedItems()) {
                    selectedOdpad = t;
                    odpadTF.setText(t.getNameOfTrash());
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // seznam Opravnenych osob AuthorisedPerson
    @FXML
    public void osobaSZOnAction(ActionEvent ev) {
        try {
            TableView<AuthorisedPerson> table = new TableView<>();
            TableColumn<AuthorisedPerson, String> cl1 = new TableColumn<>();
            cl1.setCellValueFactory(new PropertyValueFactory<>("nazev"));
            table.getColumns().clear();
            table.getColumns().add(cl1);
            Functions f = new Functions();
            ArrayList<AuthorisedPerson> tr = f.APOutputList();

            osoba.addAll(tr);
            table.setItems(osoba);

            VBox vbox = new VBox();
            vbox.getChildren().addAll(table);
            vbox.setSpacing(10);
            vbox.setAlignment(Pos.CENTER);
            Scene scene = new Scene(vbox);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();

            table.setOnMouseClicked(e -> {
                for (AuthorisedPerson t : table.getSelectionModel().getSelectedItems()) {
                    selectedOsoba = t;
                    osobaTF.setText(t.getNazev());
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // seznam zpusoba nakldani
    @FXML
    public void zpnklSZ(ActionEvent ev) {
        try {
            TableView<ZpusobNakladani> table = new TableView<>();
            TableColumn<ZpusobNakladani, String> cl1 = new TableColumn<>();
            cl1.setCellValueFactory(new PropertyValueFactory<>("nazev"));
            table.getColumns().clear();
            table.getColumns().add(cl1);
            zpnklSQL f = new zpnklSQL();
            ArrayList<ZpusobNakladani> tr = f.zpnklOutputList();

            zpnkl.addAll(tr);
            table.setItems(zpnkl);

            VBox vbox = new VBox();
            vbox.getChildren().addAll(table);
            vbox.setSpacing(10);
            vbox.setAlignment(Pos.CENTER);
            Scene scene = new Scene(vbox);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();

            table.setOnMouseClicked(e -> {
                for (ZpusobNakladani t : table.getSelectionModel().getSelectedItems()) {
                    selectedZpnkl = t;
                    zpnklTF.setText(t.getNazev());
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
