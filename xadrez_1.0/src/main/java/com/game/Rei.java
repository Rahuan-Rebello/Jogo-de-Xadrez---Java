package com.game;

public class Rei extends Peca {

    // Construtor do rei
    public Rei(int linha, int coluna, boolean branca) {
        super(linha, coluna, branca);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {

        int deltaLinha = Math.abs(novaLinha - linha);
        int deltaColuna = Math.abs(novaColuna - coluna);

        // Uma casa por vez
        return deltaLinha <= 1 &&
               deltaColuna <= 1 &&
               (deltaLinha != 0 || deltaColuna != 0);
    }
}
