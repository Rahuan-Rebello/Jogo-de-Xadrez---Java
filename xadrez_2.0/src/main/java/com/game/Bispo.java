package com.game;

public class Bispo extends Peca {

    // Construtor do bispo
    public Bispo(int linha, int coluna, boolean branca) {
        super(linha, coluna, branca);
    }

   @Override
    public boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {
        // Geometria: Diferença de linha deve ser igual à diferença de coluna
        int dLinha = Math.abs(novaLinha - linha);
        int dColuna = Math.abs(novaColuna - coluna);
        if (dLinha != dColuna) return false;

            // Chamada correta:
        if (destinoEhAliado(novaLinha, novaColuna, tabuleiro)) {
            return false;
        }
        // Colisão (caminho livre na diagonal)
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
