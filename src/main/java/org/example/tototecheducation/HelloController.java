package org.example.tototecheducation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class HelloController {
    @FXML
    private Label question, remarks;

    @FXML
    private RadioButton choice1, choice2, choice3, choice4;

    private int counter = 1;

    @FXML
    private ToggleGroup toggleGroup;

    private final Map<Integer, RadioButton> selectedRadioButtons = new HashMap<>();

    private final String[] correctAnswers = {"Jupiter","Au","Harper Lee","Jaipur", "Diamond","Leonardo da Vinci","Miso paste","8", "Blue Whale","Yen" };

    static int marks = 0;

    private boolean[] isCorrect = new boolean[correctAnswers.length];

    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        choice1.setToggleGroup(toggleGroup);
        choice2.setToggleGroup(toggleGroup);
        choice3.setToggleGroup(toggleGroup);
        choice4.setToggleGroup(toggleGroup);

        loadQuestions();

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
           if (newValue != null) {
               RadioButton selected = (RadioButton) newValue;
               selectedRadioButtons.putIfAbsent(counter, selected);
           }
        });
    }

    private void loadQuestions() {
        toggleGroup.selectToggle(null);
        remarks.setText("Question: " + counter);
        switch (counter) {
            case 1:
                question.setText("1. What is the largest planet in our solar system?");
                choice1.setText("Earth");
                choice2.setText("Jupiter");
                choice3.setText("Mars");
                choice4.setText("Venus");
                break;
            case 2:
                question.setText("2. What is the chemical symbol for gold?");
                choice1.setText("Au");
                choice2.setText("Ag");
                choice3.setText("Pb");
                choice4.setText("Fe");
                break;
            case 3:
                question.setText("3. Who wrote 'To Kill a Mockingbird'?");
                choice1.setText("Harper Lee");
                choice2.setText("J.K. Rowling");
                choice3.setText("Ernest Hemingway");
                choice4.setText("Mark Twain");
                break;
            case 4:
                question.setText("4. What is the capital city of Rajasthan?");
                choice1.setText("Jaipur");
                choice2.setText("Jodhpur");
                choice3.setText("Udaipur");
                choice4.setText("Kota");
                break;
            case 5:
                question.setText("5. What is the hardest natural substance on Earth?");
                choice1.setText("Gold");
                choice2.setText("Iron");
                choice3.setText("Diamond");
                choice4.setText("Silver");
                break;
            case 6:
                question.setText("6. Who painted the Mona Lisa?");
                choice1.setText("Vincent van Gogh");
                choice2.setText("Claude Monet");
                choice3.setText("Leonardo da Vinci");
                choice4.setText("Pablo Picasso");
                break;
            case 7:
                question.setText("7. What is the main ingredient in traditional Japanese miso soup?");
                choice1.setText("Tofu");
                choice2.setText("Miso paste");
                choice3.setText("Soy sauce");
                choice4.setText("Seaweed");
                break;
            case 8:
                question.setText("8. What is the square root of 64?");
                choice1.setText("6");
                choice2.setText("7");
                choice3.setText("8");
                choice4.setText("9");
                break;
            case 9:
                question.setText("9. What is the largest mammal in the world?");
                choice1.setText("Elephant");
                choice2.setText("Whale Shark");
                choice3.setText("Blue Whale");
                choice4.setText("Giraffe");
                break;
            case 10:
                question.setText("10. What is the currency of Japan?");
                choice1.setText("Yen");
                choice2.setText("Won");
                choice3.setText("Dollar");
                choice4.setText("Pound");
                break;
            default:
                counter = 1;
                loadQuestions();
                break;
        }
        if (selectedRadioButtons.containsKey(counter)) {
            toggleGroup.selectToggle(selectedRadioButtons.get(counter));
        }
    }

    @FXML
    protected void prevClicked() {
        checkAnswer();
        if (counter > 1) {
            counter--;
        } else {
            counter = 10; // loop back to the last question if at the first
        }
        loadQuestions();
    }

    @FXML
    protected void nextClicked() {
        checkAnswer();
        if (counter <= 10) {
            counter++;
        } else {
            counter = 1; // loop back to the first question if at the last
        }
        loadQuestions();
    }

    @FXML
    protected void homeClicked() {
        checkAnswer();
        counter = 1;
        loadQuestions();

    }
    private void checkAnswer() {
        RadioButton selected = (RadioButton) toggleGroup.getSelectedToggle();
        if (selected != null) {
            if (selected.getText().equals(correctAnswers[counter - 1]) && !isCorrect[counter -1]) {
                marks++;
                isCorrect[counter - 1] = true;
            }
        }
    }


    public void resultsClicked(ActionEvent event) {
        checkAnswer();
        try{
            Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            thisstage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("results.fxml"));
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

    public void subjectClicked(ActionEvent event) {
        try{
            Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            thisstage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("subject.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("TotoTechEducation");
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetFields() {
        marks = 0;
        selectedRadioButtons.clear();
    }
}


