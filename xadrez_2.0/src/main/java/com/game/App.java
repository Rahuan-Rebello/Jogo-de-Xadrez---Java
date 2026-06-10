package com.game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public static boolean modoContraBot = false;
    public static boolean deveCarregar = false; 

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Meu Jogo de Xadrez");
        primaryStage.setScene(criarMenu(primaryStage));
        primaryStage.show();
    }

    public static Scene criarMenu(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #333;");

        Button btnJogar = new Button("Jogar (PvP)");
        Button btnContraBot = new Button("Contra Bot");
        Button btnCarregar = new Button("Carregar Partida contra Bot");
        Button btnSair = new Button("Sair");

        String estiloBotao = "-fx-font-size: 18px; -fx-padding: 10 30; -fx-min-width: 200px;";
        btnJogar.setStyle(estiloBotao);
        btnContraBot.setStyle(estiloBotao);
        btnCarregar.setStyle(estiloBotao);
        btnSair.setStyle(estiloBotao);

        btnJogar.setOnAction(e -> {
            modoContraBot = false;
            deveCarregar = false;
            carregarJogo(stage);
        });

        btnContraBot.setOnAction(e -> {
            modoContraBot = true;
            deveCarregar = false;
            carregarJogo(stage);
        });

        btnCarregar.setOnAction(e -> {
            modoContraBot = true;
            deveCarregar = true; 
            carregarJogo(stage);
        });

        btnSair.setOnAction(e -> Platform.exit());

        root.getChildren().addAll(btnJogar, btnContraBot, btnCarregar, btnSair);
        return new Scene(root, 600, 600);
    }

    public static void carregarJogo(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("primary.fxml"));
            stage.setScene(new Scene(loader.load(), 600, 650));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarVencedor(String vencedor, Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #2c3e50;");

        Label labelVitoria = new Label(vencedor + " venceu a partida!");
        labelVitoria.setStyle("-fx-text-fill: white; -fx-font-size: 30px;");

        Button btnMenu = new Button("Voltar ao Menu");
        btnMenu.setStyle("-fx-font-size: 18px;");
        btnMenu.setOnAction(e -> stage.setScene(criarMenu(stage)));

        root.getChildren().addAll(labelVitoria, btnMenu);
        stage.setScene(new Scene(root, 600, 600));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
