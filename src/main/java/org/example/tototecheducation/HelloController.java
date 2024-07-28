package org.example.tototecheducation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class HelloController {
    @FXML
    private Label question;

    @FXML
    private RadioButton choice1, choice2, choice3, choice4;

    private int counter = 1;

    @FXML
    public void initialize() {
        loadQuestions();
    }

    private void loadQuestions() {
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
    }

    @FXML
    protected void prevClicked() {
        if (counter > 1) {
            counter--;
        } else {
            counter = 10; // loop back to the last question if at the first
        }
        loadQuestions();
    }

    @FXML
    protected void nextClicked() {
        if (counter <= 10) {
            counter++;
        } else {
            counter = 1; // loop back to the first question if at the last
        }
        loadQuestions();
    }

    @FXML
    protected void homeClicked() {
        counter = 1;
        loadQuestions();
    }
}


