package org.example.tototecheducation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultController {

    @FXML
    private Label percentage;

    @FXML
    public void initialize() {
        int total = HelloController.marks * 10;
        percentage.setText(String.valueOf(total) + "%");
    }


    public void retakeClicked(ActionEvent event) throws IOException {
        try{
            Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            thisstage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("TotoTechEducation");
            stage.setScene(scene);
//            stage.initStyle(StageStyle.TRANSPARENT);
//            scene.setFill(Color.TRANSPARENT);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
