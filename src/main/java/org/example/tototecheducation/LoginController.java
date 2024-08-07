package org.example.tototecheducation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    @FXML
    private Button cancelButton, loginButton;

    @FXML
    private Label loginMessage;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonOnAction(ActionEvent event) throws SQLException {
        if (usernameTextField.getText().equals("") || passwordPasswordField.getText().equals("")) {
            loginMessage.setText("Please enter your username and password!");
        }
        validateLogin(event);
    }

    public void cancelButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(ActionEvent event) throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "select count(1) from UserAccounts where username = '"+usernameTextField.getText()+"' and password = '"+passwordPasswordField.getText()+"'";
        Statement statement = connectDB.createStatement();

        ResultSet resultSet = statement.executeQuery(verifyLogin);

        while (resultSet.next()) {
            if (resultSet.getInt(1) == 1) {
//                loginMessage.setText("Login successful!");
                subject(event);
            } else {
                loginMessage.setText("Login failed!");
            }
        }
    }

    public void subject(ActionEvent event) throws SQLException {
        HelloController helloController = new HelloController();
        helloController.subjectClicked(event);
    }

    public void signIn(ActionEvent event) throws SQLException, IOException {
        Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        thisstage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void signUpOnAction(ActionEvent actionEvent) throws SQLException, IOException {
        signIn(actionEvent);
    }
}
