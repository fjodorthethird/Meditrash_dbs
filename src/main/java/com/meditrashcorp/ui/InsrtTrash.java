package com.meditrashcorp.ui;


import com.mediTrash.app.Data.Trash;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class InsrtTrash implements Initializable{
    @FXML
    private TextField nameTrash;

    @FXML
    private TextField amountTrash;

    @FXML
    private TableColumn<String, String>  col_cat;
    @FXML
    private TableView<String> table;
    @FXML
    private Button ins;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_cat.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));
        table.getColumns().clear();
        table.getColumns().add(col_cat);
        ObservableList<String> w = FXCollections.observableArrayList("Opasny", "Neopasny");
        table.setItems(w);
    }

    public void ins(ActionEvent event) {
        try {
            int weight = Integer.parseInt(amountTF.getText());
            Trash t = new Trash(selectedTrashFromProfile.get(selected).nameOfTrash, MainApplication.dcf.getTrashID() + 1, type, weight);
            InsertTrash it = new InsertTrash();
            it.Insert(t);
        } catch (Exception e) {
            Alert err = new Alert(Alert.AlertType.ERROR, "");
            err.initModality(Modality.APPLICATION_MODAL);
            err.initOwner(((Node)(event.getSource())).getScene().getWindow());
            err.getDialogPane().setContentText("Prosim, zadejte spravne udaje");
            err.getDialogPane().setHeaderText("Spatna vaha!");
            err.showAndWait();
        }
    }

}
