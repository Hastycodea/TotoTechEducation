package org.example.tototecheducation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SubjectController {
    public void mathClicked(ActionEvent actionEvent) throws IOException {
        try{
            Stage thisStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(loader.load());

            // get the controller of HelloController
            HelloController controller = loader.getController();
            // resetting fields
            controller.resetFields();

            thisStage.setTitle("TotoTech Education");
            thisStage.setScene(scene);
//            thisStage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            thisStage.show();



        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void engClicked(ActionEvent actionEvent) {
        try{
            Stage thisStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(loader.load());

            // get the controller of HelloController
            HelloController controller = loader.getController();
            // resetting fields
            controller.resetFields();

            thisStage.setTitle("TotoTech Education");
            thisStage.setScene(scene);
//            thisStage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            thisStage.show();



        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void kisClicked(ActionEvent actionEvent) {
        try{
            Stage thisStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(loader.load());

            // get the controller of HelloController
            HelloController controller = loader.getController();
            // resetting fields
            controller.resetFields();

            thisStage.setTitle("TotoTech Education");
            thisStage.setScene(scene);
//            thisStage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            thisStage.show();



        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notesClicked(ActionEvent actionEvent) {
        try{
            Stage thisStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("notes.fxml"));
            Scene scene = new Scene(loader.load());

            thisStage.setTitle("TotoTech Education");
            thisStage.setScene(scene);
//            thisStage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            thisStage.show();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logOutClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
//        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();

    }
}
