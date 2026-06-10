package com.game;

public class Cavalo extends Peca {

  
    public Cavalo(int linha, int coluna, boolean branca) {
        super(linha, coluna, branca);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {
        int dLinha = Math.abs(novaLinha - linha);
        int dColuna = Math.abs(novaColuna - coluna);

        // Geometria do L
        boolean ehMovimentoL = (dLinha == 2 && dColuna == 1) || (dLinha == 1 && dColuna == 2);
        if (!ehMovimentoL) return false;

        // Apenas verifica se o destino é um aliado
        return !destinoEhAliado(novaLinha, novaColuna, tabuleiro);
    }
}
