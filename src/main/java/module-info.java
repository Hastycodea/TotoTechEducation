module org.example.tototecheducation {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tototecheducation to javafx.fxml;
    exports org.example.tototecheducation;
}