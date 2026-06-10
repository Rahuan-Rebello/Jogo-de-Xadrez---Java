package com.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControladorTabuleiro {

    @FXML private GridPane gradeTabuleiro;
    
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Peca pecaSelecionada = null;
    private int origemLinha, origemColuna;
    private boolean turnoBranco = true;
    
    private boolean modoContraBot; 
    private Bot bot = new Bot();
    private boolean botEstaPensando = false; 

    @FXML
    public void initialize() {
        this.modoContraBot = App.modoContraBot; 
        
        if (App.deveCarregar) {
            carregarPartida();
            App.deveCarregar = false; 
        } else {
            tabuleiro.inicializarPecas();
        }
        desenharTabuleiro();
    }

    private void lidarComClique(int linha, int coluna) {
        if (botEstaPensando) return;

        if (pecaSelecionada == null) {
            Peca clicada = tabuleiro.getPeca(linha, coluna);
            if (clicada != null && clicada.isBranca() == turnoBranco) {
                pecaSelecionada = clicada;
                origemLinha = linha;
                origemColuna = coluna;
            }
        } else {
            if (pecaSelecionada.movimentoValido(linha, coluna, tabuleiro)) {
                tabuleiro.moverPeca(origemLinha, origemColuna, linha, coluna);
                turnoBranco = !turnoBranco;
                salvarPartida();
                desenharTabuleiro();
                verificarFimDeJogo();

                if (modoContraBot && !turnoBranco) {
                    executarJogadaBot();
                }
            }
            pecaSelecionada = null;
            desenharTabuleiro();
        }
    }

    public void executarJogadaBot() {
        botEstaPensando = true; 
        PauseTransition pausa = new PauseTransition(Duration.seconds(0.8));
        pausa.setOnFinished(e -> {
            bot.realizarJogada(tabuleiro);
            turnoBranco = true; 
            salvarPartida();
            desenharTabuleiro();
            verificarFimDeJogo();
            botEstaPensando = false;
        });
        pausa.play();
    }

    public void verificarFimDeJogo() {
        if (!tabuleiro.contemRei(true)) {
            App.mostrarVencedor("Preto", (Stage) gradeTabuleiro.getScene().getWindow());
        } else if (!tabuleiro.contemRei(false)) {
            App.mostrarVencedor("Branco", (Stage) gradeTabuleiro.getScene().getWindow());
        }
    }

    public void salvarPartida() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("partida.txt"))) {
            for (int l = 0; l < 8; l++) {
                for (int c = 0; c < 8; c++) {
                    Peca p = tabuleiro.getPeca(l, c);
                    if (p != null) {
                        writer.println(l + "," + c + "," + p.getClass().getSimpleName() + "," + p.isBranca());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarPartida() {
        try (BufferedReader reader = new BufferedReader(new FileReader("partida.txt"))) {
            tabuleiro.limpar();
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                int l = Integer.parseInt(dados[0]);
                int c = Integer.parseInt(dados[1]);
                String tipo = dados[2];
                boolean branca = Boolean.parseBoolean(dados[3]);
                Peca p = criarPeca(tipo, l, c, branca);
                if (p != null) tabuleiro.colocarPeca(p, l, c);
            }
        } catch (Exception e) {
            tabuleiro.inicializarPecas();
        }
    }

    private Peca criarPeca(String tipo, int l, int c, boolean branca) {
    switch (tipo) {
        case "Peao":
            return new Peao(l, c, branca);

        case "Torre":
            return new Torre(l, c, branca);

        case "Cavalo":
            return new Cavalo(l, c, branca);

        case "Bispo":
            return new Bispo(l, c, branca);

        case "Rainha":
            return new Rainha(l, c, branca);

        case "Rei":
            return new Rei(l, c, branca);

        default:
            return null;
    }
}

    private void desenharTabuleiro() {
        gradeTabuleiro.getChildren().clear(); 
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                StackPane casa = new StackPane();
                boolean eBranca = (linha + coluna) % 2 == 0;
                casa.setStyle(eBranca ? "-fx-background-color: #f3f3f3;" : "-fx-background-color: #70380a;");
                casa.setPrefSize(60, 60);
                int l = linha; int c = coluna;
                casa.setOnMouseClicked(e -> lidarComClique(l, c));
                Peca p = tabuleiro.getPeca(linha, coluna);
                if (p != null) {
                    String nome = p.getClass().getSimpleName().toLowerCase() + "_" + (p.isBranca() ? "branco" : "preto");
                    casa.getChildren().add(carregarImagem(nome));
                }
                gradeTabuleiro.add(casa, coluna, linha);
            }
        }
    }

    private ImageView carregarImagem(String nome) {
        java.io.InputStream stream = getClass().getResourceAsStream("/images/" + nome + ".png");
        if (stream == null) return new ImageView();
        ImageView view = new ImageView(new Image(stream));
        view.setFitWidth(40);
        view.setFitHeight(40);
        view.setMouseTransparent(true);
        return view;
    }
}