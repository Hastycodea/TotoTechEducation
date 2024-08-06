package org.example.tototecheducation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button cancelButton, loginButton;

    @FXML
    private Label loginMessage;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonOnAction(ActionEvent event) {
//        loginMessage.setText("You tried to login bitch!");

        if (usernameTextField.getText().equals("") || passwordPasswordField.getText().equals("")) {
            loginMessage.setText("Please enter your username and password!");
        } else {
            loginMessage.setText("Login successful!");
        }
    }

    public void cancelButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}
