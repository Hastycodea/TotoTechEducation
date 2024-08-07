package org.example.tototecheducation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.security.auth.Subject;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupController {

    @FXML
    private TextField firstNameTextField, lastNameTextField, userNameTextField;

    @FXML
    private Label alert;

    @FXML
    private PasswordField passwordField;

    public void signUpOnAction(ActionEvent actionEvent) throws SQLException {
        if (firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty()) {
            alert.setText("Please fill all the fields");
        } else {
            validateSignUp();
        }
    }

    private void validateSignUp() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        String sql = "insert into UserAccounts(first_name, last_name, username, password) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, firstNameTextField.getText());
        preparedStatement.setString(2, lastNameTextField.getText());
        preparedStatement.setString(3, userNameTextField.getText());
        preparedStatement.setString(4, passwordField.getText());

        int result = preparedStatement.executeUpdate();
        if (result == 1) {
            alert.setText("successfully registered! you can now sign in");
        }
    }

    public void login (ActionEvent actionEvent) throws SQLException, IOException {
        SubjectController subjectController = new SubjectController();
        subjectController.logOutClicked(actionEvent);
    }

    public void signInOnAction(ActionEvent actionEvent) throws SQLException, IOException {
        login(actionEvent);
    }
}
