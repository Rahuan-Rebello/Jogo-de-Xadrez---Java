module com.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base; // Às vezes é necessário

    opens com.game to javafx.fxml;
    exports com.game;
}