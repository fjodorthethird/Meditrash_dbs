package com.meditrashcorp.ui;

import com.mediTrash.app.Tools.ExcelCreator.Data;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class ProfileController implements Initializable {
    @FXML
    private Label usernameL, pswdL, zarizeniL;
    public static Label usernameL_s, pswdL_s, zarizeniL_s;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameL_s = usernameL;
        pswdL_s = pswdL;
        zarizeniL_s = zarizeniL;
    }

    private void changeDataScene(Label whatToChange, String type) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("changeData.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 350, 200);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
            ChangeDataController.ok_s.setOnAction(event -> {
                ((Node)(event.getSource())).getScene().getWindow().hide();
                if (LoginController.pswdText_s.getText().equals(ChangeDataController.psswd_s.getText())) {
                    if (whatToChange.equals(pswdL_s)) {
                        pswdL_s.setText("*".repeat(ChangeDataController.text_s.getText().length()));
                    } else {
                        try {
                            //TODO pswd change
                            switch (type) {
                                case "zar" -> MainApplication.dcf.nameofMedicalChanger(usernameL_s.getText(), ChangeDataController.text_s.getText());
                                default -> {
                                }
                            }
                        }
                        catch (SQLException e) {
                                e.printStackTrace();
                            }
                        whatToChange.setText(ChangeDataController.text_s.getText());

                    }

                } else {
                    Alert err = new Alert(Alert.AlertType.ERROR, "");
                    err.initModality(Modality.APPLICATION_MODAL);
                    err.initOwner(((Node)(event.getSource())).getScene().getWindow());
                    err.getDialogPane().setContentText("Prosim, zadejte spravne udaje");
                    err.getDialogPane().setHeaderText("Spatne heslo!");
                    err.showAndWait();
                    changeDataScene(whatToChange, "");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changePswdBtnOnAction(javafx.event.ActionEvent event) {
        changeDataScene(pswdL_s, "pswd");
    }

    public void changeZarBtnOnAction(javafx.event.ActionEvent event) {
        changeDataScene(zarizeniL_s, "zar");
    }

    public void myTrashBtnOnAction(javafx.event.ActionEvent event) {
        try {
            Data d = new Data();
            d.Data();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    public static <T> ObservableList<T> distinct(ObservableList<T> list) {
//        Set<T> set = new LinkedHashSet<>(list);
//        list.clear();
//        list.addAll(set);
//        return list;
//    }
}
