module com.game {
    requires javafx.controls;
    requires javafx.fxml;
    
    // Adicione esta linha abaixo para corrigir o erro do App.java
    opens com.game to javafx.fxml;
    
    exports com.game;
}