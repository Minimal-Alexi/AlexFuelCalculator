module org.metropolia.alexfuelcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.metropolia.alexfuelcalculator to javafx.fxml;
    exports org.metropolia.alexfuelcalculator;
}