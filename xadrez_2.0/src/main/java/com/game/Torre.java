package com.game;

public class Torre extends Peca {

    // Construtor da torre
    public Torre(int linha, int coluna, boolean branca) {
        super(linha, coluna, branca);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna, Tabuleiro tabuleiro) {
        // 1. Validação Geométrica: Torre só move em linha reta (mesma linha ou mesma coluna)
        if (novaLinha != linha && novaColuna != coluna) {
            return false; 
        }

        // 2. Validação de Captura: Impede capturar aliado
        Peca destino = tabuleiro.getPeca(novaLinha, novaColuna);
        if (destino != null && destino.isBranca() == this.isBranca()) {
            return false;
        }

        // 3. Validação de Caminho: Torre não pula peças (precisamos verificar o trajeto)
        int linhaPasso = Integer.signum(novaLinha - linha); // +1, -1 ou 0
        int colunaPasso = Integer.signum(novaColuna - coluna); // +1, -1 ou 0
    
        int lAtual = linha + linhaPasso;
        int cAtual = coluna + colunaPasso;
    
        while (lAtual != novaLinha || cAtual != novaColuna) {
            if (tabuleiro.getPeca(lAtual, cAtual) != null) {
                return false; // Tem uma peça bloqueando o caminho
            }
            lAtual += linhaPasso;
            cAtual += colunaPasso;
        }

        return true;
    }
}