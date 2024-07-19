package org.example.tototecheducation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage window) throws IOException {
        BorderPane elements = new BorderPane();

        VBox vbox = new VBox();
        Text text = new Text("What is the day of the week? ");
        text.setFont(new Font(20));

        Text answer1 = new Text("A. Sunday \n");
        answer1.setFont(new Font( 20));

        Text answer2 = new Text("A. Sunday \n");
        answer2.setFont(new Font(20));

        Text answer3 = new Text("A. Sunday \n");
        answer3.setFont(new Font( 20));

        Text answer4 = new Text("A. Sunday \n");
        answer4.setFont(new Font(20));

        vbox.getChildren().addAll(answer1, answer2, answer3, answer4);

        StackPane stackPane = new StackPane();
//        stackPane.setPadding(new Insets(10, 10, 10, 10));
        stackPane.getChildren().addAll(text, answer1, answer2, answer3, answer4);
        elements.setCenter(stackPane);

        HBox hbox = new HBox();
        Button button1 = new Button("Previous");
        Button button2 = new Button("Home");
        Button button3 = new Button("Next");
        hbox.getChildren().addAll(button1, button2, button3);
        hbox.setSpacing(30);
        hbox.setPadding(new Insets(10, 10, 10, 40));

        elements.setBottom(hbox);


        Scene view = new Scene(elements, 480, 480);
        window.setScene(view);
        window.setTitle("Toto Tech Education");
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}