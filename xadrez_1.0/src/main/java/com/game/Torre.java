package com.game;

public class Torre extends Peca {

    // Construtor da torre
    public Torre(int linha, int coluna, boolean branca) {
        super(linha, coluna, branca);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {

        // A torre move apenas na horizontal ou vertical
        return linha == novaLinha || coluna == novaColuna;
    }
}
