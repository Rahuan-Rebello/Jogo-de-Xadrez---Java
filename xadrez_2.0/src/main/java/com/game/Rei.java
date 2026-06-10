package com.game;

public class Rei extends Peca {

    // Construtor do rei
    public Rei(int linha, int coluna, boolean branca) {
        super(linha, coluna, branca);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {
        int dLinha = Math.abs(novaLinha - linha);
        int dColuna = Math.abs(novaColuna - coluna);

        // Geometria: no máximo 1 casa em qualquer direção
        if (dLinha > 1 || dColuna > 1) return false;

        return !destinoEhAliado(novaLinha, novaColuna, tabuleiro);
    }
}
