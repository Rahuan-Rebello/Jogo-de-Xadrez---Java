package com.game;

import java.io.InputStream;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class PrimaryController {
    @FXML private GridPane gradeTabuleiro;
    @FXML private Label statusLabel;

    private Tabuleiro tabuleiro = new Tabuleiro();
    private Peca pecaSelecionada = null;
    private int origemLinha, origemColuna;
    private boolean turnoBranco = true;

    @FXML
    public void initialize() {
        tabuleiro.inicializarPecas();
        desenharTabuleiro();
    }

    private ImageView carregarImagem(String nome) {
        InputStream stream = getClass().getResourceAsStream("/images/" + nome + ".png");
        if (stream == null) return new ImageView();
        ImageView view = new ImageView(new Image(stream));
        view.setFitWidth(40);
        view.setFitHeight(40);
        view.setMouseTransparent(true); // Permite o clique passar pela peça
        return view;
    }

    private void desenharTabuleiro() {
    gradeTabuleiro.getChildren().clear(); 

    for (int linha = 0; linha < 8; linha++) {
    for (int coluna = 0; coluna < 8; coluna++) {
        StackPane casa = new StackPane();
        
        // Define cor
        boolean eBranca = (linha + coluna) % 2 == 0;
        casa.setStyle(eBranca ? "-fx-background-color: #f3f3f3;" : "-fx-background-color: #70380a;");
        casa.setPrefSize(60, 60);
        
        // Evento de clique
        int l = linha; int c = coluna;
        casa.setOnMouseClicked(e -> lidarComClique(l, c));
        
        // AQUI ESTÁ A CORREÇÃO: Pega a peça APENAS UMA VEZ
        Peca p = tabuleiro.getPeca(linha, coluna);
        if (p != null) {

            if (p != null) {
    String nome = p.getClass().getSimpleName().toLowerCase() + "_" + (p.isBranca() ? "branco" : "preto");
    System.out.println("Procurando imagem: " + nome + ".png");
    
    // Adiciona uma verificação para saber se a imagem existe
    java.io.InputStream stream = getClass().getResourceAsStream("/images/" + nome + ".png");
    if (stream == null) {
        System.err.println("ERRO: Imagem não encontrada para: " + nome);
    } else {
        casa.getChildren().add(carregarImagem(nome));
    }
}

            String nome = p.getClass().getSimpleName().toLowerCase() + "_" + (p.isBranca() ? "branco" : "preto");
            casa.getChildren().add(carregarImagem(nome));
        }
        
        gradeTabuleiro.add(casa, coluna, linha);
    }
}
}

    private void lidarComClique(int linha, int coluna) {
    if (pecaSelecionada == null) {
        // Fase de Seleção: o jogador clica na peça que quer mover
        Peca clicada = tabuleiro.getPeca(linha, coluna);
        if (clicada != null && clicada.isBranca() == turnoBranco) {
            pecaSelecionada = clicada;
            origemLinha = linha;
            origemColuna = coluna;
        }
    } else {
        // Fase de Movimentação: o jogador clica no destino
        // Agora chamamos o movimentoValido com 3 argumentos para todas as peças
        if (pecaSelecionada.movimentoValido(linha, coluna, tabuleiro)) {
            tabuleiro.moverPeca(origemLinha, origemColuna, linha, coluna);
            turnoBranco = !turnoBranco;
        }
        
        // Limpa a seleção após tentar mover (com sucesso ou não)
        pecaSelecionada = null;
        desenharTabuleiro();
    }
}
}