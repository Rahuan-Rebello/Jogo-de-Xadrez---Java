package com.game;

public class Rainha extends Peca {

    // Construtor da rainha
    public Rainha(int linha, int coluna, boolean branca) {
        super(linha, coluna, branca);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {
        int dLinha = Math.abs(novaLinha - linha);
        int dColuna = Math.abs(novaColuna - coluna);

        // Geometria: linha reta OU diagonal
        boolean ehLinhaReta = (novaLinha == linha || novaColuna == coluna);
        boolean ehDiagonal = (dLinha == dColuna);

        if (!ehLinhaReta && !ehDiagonal) return false;

        if (destinoEhAliado(novaLinha, novaColuna, tabuleiro)) return false;

        // Colisão: o mesmo loop de caminho livre usado na Torre e Bispo
        int stepLinha = Integer.signum(novaLinha - linha);
        int stepColuna = Integer.signum(novaColuna - coluna);
        int l = linha + stepLinha;
        int c = coluna + stepColuna;
        while (l != novaLinha || c != novaColuna) {
            if (tabuleiro.getPeca(l, c) != null) return false;
            l += stepLinha;
            c += stepColuna;
        }
        return true;
    }
}
