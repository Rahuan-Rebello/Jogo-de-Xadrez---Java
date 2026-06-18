package com.game;

public class Rei extends Peca {


    public Rei(int linha, int coluna, boolean branca) {
        super(linha, coluna, branca);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {
        int dLinha = Math.abs(novaLinha - linha);
        int dColuna = Math.abs(novaColuna - coluna);

        
        if (dLinha > 1 || dColuna > 1) return false;

        return !destinoEhAliado(novaLinha, novaColuna, tabuleiro);
    }
}
