module org.example.tototecheducation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.tototecheducation to javafx.fxml;
    exports org.example.tototecheducation;
}