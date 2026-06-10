package com.game;

public class Tabuleiro {
    private Peca[][] casas = new Peca[8][8];

    public void inicializarPecas() {
    
        for (int i = 0; i < 8; i++) {
            casas[6][i] = new Peao(6, i, true);  // Peões brancos
            casas[1][i] = new Peao(1, i, false); // Peões pretos
        }

   
        colocarLinhaPrincipal(7, true);
        colocarLinhaPrincipal(0, false);
    }

    private void colocarLinhaPrincipal(int linha, boolean branca) {
       
        casas[linha][0] = new Torre(linha, 0, branca);
        casas[linha][1] = new Cavalo(linha, 1, branca);
        casas[linha][2] = new Bispo(linha, 2, branca);
        casas[linha][3] = new Rainha(linha, 3, branca);
        casas[linha][4] = new Rei(linha, 4, branca);
        casas[linha][5] = new Bispo(linha, 5, branca);
        casas[linha][6] = new Cavalo(linha, 6, branca);
        casas[linha][7] = new Torre(linha, 7, branca);
    }

        public Peca getPeca(int l, int c) { return casas[l][c]; }

        public void moverPeca(int lo, int co, int ld, int cd) {
            Peca p = casas[lo][co];
            casas[ld][cd] = p;
            casas[lo][co] = null;
            if (p != null) p.mover(ld, cd);
        }

        public boolean temPeca(int linha, int coluna) {
     
        return linha >= 0 && linha < 8 && coluna >= 0 && coluna < 8 && casas[linha][coluna] != null;
    }


    public boolean contemRei(boolean corBranca) {
    for (int l = 0; l < 8; l++) {
        for (int c = 0; c < 8; c++) {
            Peca p = getPeca(l, c);
            if (p instanceof Rei && p.isBranca() == corBranca) {
                return true;
            }
        }
    }
    return false;
}

public void limpar() {
    for (int l = 0; l < 8; l++) {
        for (int c = 0; c < 8; c++) {
            casas[l][c] = null;
        }
    }
}

public void colocarPeca(Peca p, int l, int c) {
    casas[l][c] = p;
    if (p != null) p.mover(l, c);
}

}
