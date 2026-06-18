package com.game;

public class Cavalo extends Peca {

  
    public Cavalo(int linha, int coluna, boolean branca) {
        super(linha, coluna, branca);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {
        int dLinha = Math.abs(novaLinha - linha);
        int dColuna = Math.abs(novaColuna - coluna);

     
        boolean ehMovimentoL = (dLinha == 2 && dColuna == 1) || (dLinha == 1 && dColuna == 2);
        if (!ehMovimentoL) return false;

        return !destinoEhAliado(novaLinha, novaColuna, tabuleiro);
    }
}
