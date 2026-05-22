# ♟️ Jogo de Xadrez - Java Swing (MVC)

Desafio de programação voltado ao desenvolvimento de um jogo de xadrez completo utilizando a linguagem **Java**, interface gráfica com **Java Swing** e seguindo rigorosamente o padrão de arquitetura **MVC (Model-View-Controller)**. O projeto compõe uma nota avaliativa de 3,0 pontos com defesas programadas para a segunda semana de junho.

---

## 📌 Sobre o Projeto

Este projeto consiste em um simulador de xadrez funcional onde a separação clara de responsabilidades através do padrão MVC é o foco principal, garantindo um código altamente organizado, escalável e dividido estritamente em pacotes.

---

## 🚀 Funcionalidades e Requisitos

### 1. Regras Clássicas e Mecânicas Avançadas
* Representação completa do tabuleiro 8x8 com as peças padrão.
* Lógica de movimentação básica e impedimento de jogadas inválidas.
* **Movimentos e Mecânicas Especiais:** Roque, Xeque, Xeque-mate, *en passant* e promoção de peões.

### 2. Modos de Jogo e Recursos Avançados
* **Seleção de Jogo por Tempo:** Suporte aos modos clássicos do xadrez: *bullet*, *blitz*, rápida e clássica.
* **Jogo Remoto:** Partidas online via comunicação por sockets.
* **Jogo Local contra BOT:** Inteligência Artificial que utiliza o algoritmo Minimax com otimização Alfa-Beta (Alpha-Beta Pruning).

### 3. Persistência de Dados e Sistema de Ranking
* **Controle de Turnos:** Alternância rigorosa entre o jogador branco e o jogador preto.
* **Auto-salvamento:** O estado do jogo é salvo automaticamente após a realização de cada movimento.
* **Persistência Geral:** Métodos estruturados para salvar e carregar o estado do jogo através de arquivos serializados (ex: `game.ser`).
* **Sistema de Ranking:** Placar persistente e simples para armazenar e gerenciar o nome dos jogadores e o número de vitórias acumuladas.

---

## 🏗️ Arquitetura do Sistema (MVC)

O código-fonte foi rigorosamente organizado e segmentado em pacotes específicos para garantir a separação de responsabilidades:

* **Model (Modelo):** Gerencia os dados do tabuleiro, regras de movimentação das peças, turnos e persistência em arquivo. Obrigatoriamente faz uso de herança e de, pelo menos, uma interface definida pelo usuário.
* **View (Interface Gráfica):** Desenvolvida em Java Swing, exibe o tabuleiro em uma grade de botões 8x8, renderiza as peças utilizando símbolos Unicode (ex: ♔, ♞) ou ícones , destaca visualmente a casa selecionada e exibe mensagens dinâmicas de erro ou fim de turno.
* **Controller (Controlador):** Intermedeia a comunicação, captura e gerencia os cliques do usuário na View, processa a lógica de movimentação no Model e atualiza a interface gráfica em tempo real após cada jogada válida.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 8 ou superior
* **Interface Gráfica:** Java Swing 
* **Persistência:** Serialização de objetos em arquivos
* **Rede:** Sockets

---

## 💻 Como Compilar e Executar

### Pré-requisitos
Certifique-se de ter o **JDK 8** (ou superior) devidamente instalado e configurado em suas variáveis de ambiente.

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
   
