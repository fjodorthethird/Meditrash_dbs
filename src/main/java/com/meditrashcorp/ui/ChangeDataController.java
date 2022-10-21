package com.meditrashcorp.ui;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeDataController implements Initializable {

    @FXML
    public TextField text;
    public static TextField text_s;
    @FXML
    private PasswordField psswd;
    public static PasswordField psswd_s;
    @FXML
    public Button ok;
    public static Button ok_s;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ok_s = ok;
        psswd_s = psswd;
        text_s = text;
    }
}
