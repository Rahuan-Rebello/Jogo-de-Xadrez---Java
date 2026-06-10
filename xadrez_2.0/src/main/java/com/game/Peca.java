package com.game;

public abstract class Peca {
    protected int linha, coluna;
    protected boolean branca;

    public Peca(int l, int c, boolean b) { this.linha = l; this.coluna = c; this.branca = b; }

    // Método abstrato único (definido apenas uma vez)
    public abstract boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro);

    public void mover(int nl, int nc) { this.linha = nl; this.coluna = nc; }
    
    public boolean isBranca() { return branca; }

    public boolean eInimigo(Peca outraPeca) {
        return outraPeca != null && outraPeca.isBranca() != this.isBranca();
    }

    public boolean destinoEhAliado(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {
        Peca pecaNoDestino = tabuleiro.getPeca(novaLinha, novaColuna);
        return pecaNoDestino != null && pecaNoDestino.isBranca() == this.isBranca();
    }
}