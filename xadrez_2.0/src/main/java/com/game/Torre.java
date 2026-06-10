package com.game;

public class Torre extends Peca {

 
    public Torre(int linha, int coluna, boolean branca) {
        super(linha, coluna, branca);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {
      
        if (novaLinha != linha && novaColuna != coluna) {
            return false; 
        }

   
        Peca destino = tabuleiro.getPeca(novaLinha, novaColuna);
        if (destino != null && destino.isBranca() == this.isBranca()) {
            return false;
        }

    
        int linhaPasso = Integer.signum(novaLinha - linha); 
        int colunaPasso = Integer.signum(novaColuna - coluna); 
    
        int lAtual = linha + linhaPasso;
        int cAtual = coluna + colunaPasso;
    
        while (lAtual != novaLinha || cAtual != novaColuna) {
            if (tabuleiro.getPeca(lAtual, cAtual) != null) {
                return false; 
            }
            lAtual += linhaPasso;
            cAtual += colunaPasso;
        }

        return true;
    }
}
