package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot {

    public void realizarJogada(Tabuleiro tabuleiro) {
        List<Movimento> movimentosPossiveis = new ArrayList<>();

        // 1. Mapear todos os movimentos possíveis para peças pretas
        for (int l = 0; l < 8; l++) {
            for (int c = 0; c < 8; c++) {
                Peca p = tabuleiro.getPeca(l, c);
                if (p != null && !p.isBranca()) {
                    for (int nl = 0; nl < 8; nl++) {
                        for (int nc = 0; nc < 8; nc++) {
                            if (p.movimentoValido(nl, nc, tabuleiro)) {
                                movimentosPossiveis.add(new Movimento(l, c, nl, nc));
                            }
                        }
                    }
                }
            }
        }

        if (movimentosPossiveis.isEmpty()) return;

        // 2. Avaliar cada movimento para encontrar o "melhor"
        Movimento melhorMovimento = null;
        int melhorPontuacao = -9999;

        for (Movimento m : movimentosPossiveis) {
            int pontuacaoAtual = avaliarMovimento(m, tabuleiro);
            
            // Adiciona um fator aleatório para o Bot não ser totalmente previsível
            pontuacaoAtual += new Random().nextInt(10);

            if (pontuacaoAtual > melhorPontuacao) {
                melhorPontuacao = pontuacaoAtual;
                melhorMovimento = m;
            }
        }

        // 3. Executa o melhor movimento encontrado
        if (melhorMovimento != null) {
            tabuleiro.moverPeca(melhorMovimento.deLinha, melhorMovimento.deColuna, 
                                melhorMovimento.paraLinha, melhorMovimento.paraColuna);
        }
    }

    private int avaliarMovimento(Movimento m, Tabuleiro tabuleiro) {
        Peca destino = tabuleiro.getPeca(m.paraLinha, m.paraColuna);
        
        // Se capturar uma peça, o valor do movimento é o valor da peça capturada
        if (destino != null) {
            return obterValorPeca(destino);
        }
        
        // Se for um movimento simples, damos uma pontuação neutra
        return 0;
    }

    private int obterValorPeca(Peca p) {
        String nome = p.getClass().getSimpleName();
        return switch (nome) {
            case "Peao" -> 10;
            case "Cavalo", "Bispo" -> 30;
            case "Torre" -> 50;
            case "Rainha" -> 90;
            case "Rei" -> 900;
            default -> 0;
        };
    }

    private static class Movimento {
        int deLinha, deColuna, paraLinha, paraColuna;
        Movimento(int dl, int dc, int pl, int pc) {
            this.deLinha = dl; this.deColuna = dc; this.paraLinha = pl; this.paraColuna = pc;
        }
    }
}