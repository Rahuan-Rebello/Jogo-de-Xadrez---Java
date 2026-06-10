package com.game;

public abstract class Peca {
    protected int linha, coluna;
    protected boolean branca;
    public Peca(int l, int c, boolean b) { this.linha = l; this.coluna = c; this.branca = b; }
    public abstract boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro);
    public void mover(int nl, int nc) { this.linha = nl; this.coluna = nc; }
    public boolean isBranca() { return branca; }
}