package org.example.tototecheducation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupController {

    @FXML
    private TextField firstNameTextField, lastNameTextField, userNameTextField;

    @FXML
    private Label alert;

    @FXML
    private PasswordField passwordTextField, confirmPasswordTextField;

    public void signUpOnAction(ActionEvent actionEvent) throws SQLException {
        validateSignUp(actionEvent);
    }

    private void validateSignUp(ActionEvent event) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        String sql = "insert into UserAccounts(first_name, last_name, username, password) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, firstNameTextField.getText());
        preparedStatement.setString(2, lastNameTextField.getText());
        preparedStatement.setString(3, userNameTextField.getText());

        if (passwordTextField.getText().equals(confirmPasswordTextField.getText())) {
            preparedStatement.setString(4, passwordTextField.getText());
        } else {
            alert.setText("Passwords do not match");
        }
        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            alert.setText("successfully registered! you can sign in");
            login(event);
        }
    }

    public void login (ActionEvent actionEvent) throws SQLException {
        LoginController loginController = new LoginController();
        loginController.loginButtonOnAction(actionEvent);
    }
}
