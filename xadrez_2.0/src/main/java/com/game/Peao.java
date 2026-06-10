package com.game;

public class Peao extends Peca {
    private boolean primeiroMovimento = true;

    public Peao(int linha, int coluna, boolean branca) {
        super(linha, coluna, branca);
    }

@Override
public boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {
    int direcao = branca ? -1 : 1; 

    // 1. Andar para frente
    if (novaColuna == coluna && novaLinha == linha + direcao) {
        return !tabuleiro.temPeca(novaLinha, novaColuna);
    }

    // 2. Capturar na diagonal
    if (Math.abs(novaColuna - coluna) == 1 && novaLinha == linha + direcao) {
        Peca alvo = tabuleiro.getPeca(novaLinha, novaColuna);
        return alvo != null && alvo.isBranca() != this.isBranca();
    }
    return false;
}

    public boolean caminhoLivre(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {
        int direcao = branca ? -1 : 1;
        if (Math.abs(novaLinha - linha) == 2) {
            if (tabuleiro.getPeca(linha + direcao, coluna) != null) return false;
        }
        return true;
    }

    @Override
    public void mover(int novaLinha, int novaColuna) {
        super.mover(novaLinha, novaColuna);
        primeiroMovimento = false;
    }
}