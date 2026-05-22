# ♟️ Jogo de Xadrez - Java Swing (MVC)

[cite_start]Desafio de programação voltado ao desenvolvimento de um jogo de xadrez completo utilizando a linguagem **Java**, interface gráfica com **Java Swing** e seguindo rigorosamente o padrão de arquitetura **MVC (Model-View-Controller)**[cite: 1]. [cite_start]O projeto compõe uma nota avaliativa de 3,0 pontos com defesas programadas para a segunda semana de junho[cite: 1].

---

## 📌 Sobre o Projeto

[cite_start]Este projeto consiste em um simulador de xadrez funcional onde a separação clara de responsabilidades através do padrão MVC é o foco principal [cite: 1, 14][cite_start], garantindo um código altamente organizado, escalável e dividido estritamente em pacotes[cite: 11, 12].

---

## 🚀 Funcionalidades e Requisitos

### 1. Regras Clássicas e Mecânicas Avançadas
* [cite_start]Representação completa do tabuleiro 8x8 com as peças padrão[cite: 2].
* [cite_start]Lógica de movimentação básica e impedimento de jogadas inválidas[cite: 2, 10].
* [cite_start]**Movimentos e Mecânicas Especiais:** Roque, Xeque, Xeque-mate, *en passant* e promoção de peões[cite: 17].

### 2. Modos de Jogo e Recursos Avançados
* [cite_start]**Seleção de Jogo por Tempo:** Suporte aos modos clássicos do xadrez: *bullet*, *blitz*, rápida e clássica[cite: 17].
* [cite_start]**Jogo Remoto:** Partidas online via comunicação por sockets[cite: 17].
* [cite_start]**Jogo Local contra BOT:** Inteligência Artificial que utiliza o algoritmo Minimax com otimização Alfa-Beta (Alpha-Beta Pruning)[cite: 17].

### 3. Persistência de Dados e Sistema de Ranking
* [cite_start]**Controle de Turnos:** Alternância rigorosa entre o jogador branco e o jogador preto[cite: 3, 9].
* [cite_start]**Auto-salvamento:** O estado do jogo é salvo automaticamente após a realização de cada movimento[cite: 10].
* [cite_start]**Persistência Geral:** Métodos estruturados para salvar e carregar o estado do jogo através de arquivos serializados (ex: `game.ser`)[cite: 3, 12, 13].
* [cite_start]**Sistema de Ranking:** Placar persistente e simples para armazenar e gerenciar o nome dos jogadores e o número de vitórias acumuladas[cite: 4, 12, 15].

---

## 🏗️ Arquitetura do Sistema (MVC)

[cite_start]O código-fonte foi rigorosamente organizado e segmentado em pacotes específicos para garantir a separação de responsabilidades[cite: 11, 12]:

* [cite_start]**Model (Modelo):** Gerencia os dados do tabuleiro, regras de movimentação das peças, turnos e persistência em arquivo[cite: 2, 3]. [cite_start]Obrigatoriamente faz uso de herança e de, pelo menos, uma interface definida pelo usuário[cite: 16].
* [cite_start]**View (Interface Gráfica):** Desenvolvida em Java Swing [cite: 4][cite_start], exibe o tabuleiro em uma grade de botões 8x8 [cite: 5][cite_start], renderiza as peças utilizando símbolos Unicode (ex: ♔, ♞) ou ícones [cite: 5][cite_start], destaca visualmente a casa selecionada [cite: 6] [cite_start]e exibe mensagens dinâmicas de erro ou fim de turno[cite: 7].
* [cite_start]**Controller (Controlador):** Intermedeia a comunicação, captura e gerencia os cliques do usuário na View [cite: 6, 8][cite_start], processa a lógica de movimentação no Model [cite: 8] [cite_start]e atualiza a interface gráfica em tempo real após cada jogada válida[cite: 9, 10].

---

## 🛠️ Tecnologias Utilizadas

* [cite_start]**Linguagem:** Java 8 ou superior [cite: 11]
* [cite_start]**Interface Gráfica:** Java Swing [cite: 11]
* [cite_start]**Persistência:** Serialização de objetos em arquivos [cite: 12]
* [cite_start]**Rede:** Sockets [cite: 17]

---

## 💻 Como Compilar e Executar

### Pré-requisitos
[cite_start]Certifique-se de ter o **JDK 8** (ou superior) devidamente instalado e configurado em suas variáveis de ambiente[cite: 11].

### Instruções para Execução

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git](https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git)
   cd NOME_DO_REPOSITORIO

2. **Compile todos os arquivos fonte para o diretório de binários:**
   ```bash
   javac -d bin src/**/*.java

3. **Execute a aplicação a partir do pacote principal (exemplo com o Controller):**
   ```bash
   java -cp bin controller.Main

## 📄 Conteúdo dos Entregáveis

O repositório contém toda a estrutura exigida para o projeto:  
* Código-fonte completo, estruturado e comentado.
* Arquivos de persistência gerados de forma automática durante os testes (ex: game.ser).
* Documentação textual explicando os critérios de design adotados para a arquitetura MVC.  
   
