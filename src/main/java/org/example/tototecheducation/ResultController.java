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

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            // get the controller of HelloController
            HelloController controller = fxmlLoader.getController();
            // reset the controller to its initial state
            controller.resetFields();

            thisstage.setTitle("TotoTechEducation");
            thisstage.setScene(scene);
//            stage.initStyle(StageStyle.TRANSPARENT);
//            scene.setFill(Color.TRANSPARENT);
            thisstage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
