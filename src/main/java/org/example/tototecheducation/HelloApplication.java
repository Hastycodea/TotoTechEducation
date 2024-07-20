package org.example.tototecheducation;

//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class HelloApplication extends Application {
//    @Override
//    public void start(Stage window) throws IOException {
//        BorderPane elements = new BorderPane();
//
//        Text text = new Text("What is the day of the week? ");
//        text.setFont(new Font(20));
//
//        Text answer1 = new Text("A. Sunday \n");
//        answer1.setFont(new Font( 20));
//
//        Text answer2 = new Text("A. Sunday \n");
//        answer2.setFont(new Font(20));
//
//        Text answer3 = new Text("A. Sunday \n");
//        answer3.setFont(new Font( 20));
//
//        Text answer4 = new Text("A. Sunday \n");
//        answer4.setFont(new Font(20));
//
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(0, 10, 0, 10));
//        grid.setHgap(10);
//        grid.setVgap(0);
//        grid.add(text, 7, 0);
//        grid.add(answer1, 7, 1);
//        grid.add(answer2, 7, 2);
//        grid.add(answer3, 7, 3);
//        grid.add(answer4, 7, 4);
//
//
//        StackPane pane = new StackPane();
//        pane.getChildren().add(grid);
//
//        elements.setCenter(pane);
//
//        Label title = new Label("Question 1");
//        elements.setTop(title);
//
//        HBox hbox = new HBox();
//        Button button1 = new Button("Previous");
//        Button button2 = new Button("Home");
//        Button button3 = new Button("Next");
//        hbox.getChildren().addAll(button1, button2, button3);
//        hbox.setSpacing(30);
//        hbox.setPadding(new Insets(10, 10, 10, 40));
//
//        elements.setBottom(hbox);
//
//
//        Scene view = new Scene(elements, 480, 480);
//        window.setScene(view);
//        window.setTitle("Toto Tech Education");
//        window.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the root BorderPane
        BorderPane root = new BorderPane();
        root.setPrefSize(640, 480);


        // Center: Question and four choices aligned vertically
        VBox centerContent = new VBox(10); // 10px spacing between elements
        centerContent.setAlignment(Pos.CENTER); // Center vertically

        // No.of question
        Label questionNumber = new Label("Question 1");
        questionNumber.setStyle("-fx-font-weight: bold");
        questionNumber.setAlignment(Pos.CENTER);

        Label question = new Label("What is your favorite color?");
        question.setAlignment(Pos.CENTER_LEFT);

        ToggleGroup group = new ToggleGroup();
        RadioButton choice1 = new RadioButton("Red");
        choice1.setToggleGroup(group);
        RadioButton choice2 = new RadioButton("Blue");
        choice2.setToggleGroup(group);
        RadioButton choice3 = new RadioButton("Green");
        choice3.setToggleGroup(group);
        RadioButton choice4 = new RadioButton("Yellow");
        choice4.setToggleGroup(group);

        VBox choices = new VBox(5); // 5px spacing between choices
        choices.setAlignment(Pos.CENTER);
        choices.getChildren().addAll(choice1, choice2, choice3, choice4);



        centerContent.getChildren().addAll(questionNumber ,question, choices);
        root.setCenter(centerContent);

        BorderPane border2 = new BorderPane();
        VBox elements = new VBox(10);
        Label text = new Label("Hello World");
        elements.getChildren().addAll(text);
        border2.setCenter(elements);
        Scene scene2 = new Scene(border2, 640, 480);
        Scene scene = new Scene(root);

        // Bottom: Three buttons aligned at the center bottom
        HBox bottomButtons = new HBox(10); // 10px spacing between buttons
        Button previousButton = new Button("Previous");
        Button homeButton = new Button("Home");
        Button nextButton = new Button("Next");

        bottomButtons.getChildren().addAll(previousButton, homeButton, nextButton);
        bottomButtons.setAlignment(Pos.CENTER);
        root.setBottom(bottomButtons);


        homeButton.setOnAction(event -> primaryStage.setScene(scene2));
        nextButton.setOnAction(event -> primaryStage.setScene(scene));

        // Create the Scene and set it in the Stage
        primaryStage.setTitle("TotoTechEducation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
