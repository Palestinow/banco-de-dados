import java.util.*; // Importa todas as classes do pacote java.util

// Classe que representa o jogo de Truco
public class Jogo {
    // Atributos que representam os dois jogadores
    private Jogador jogador1;
    private Jogador jogador2;
    // Atributo que representa o baralho do jogo
    private Baralho baralho;
    // Carta que será a "vira" (carta que define a manilha)
    private Carta vira;
    // Scanner para capturar entradas do usuário
    private Scanner scanner;
    // Valor da mão atual (quantos pontos ela vale)
    private int valorMao;
    // Ordem das cartas do jogo, usada para determinar a manilha
    private String[] ordemCartas = {"4", "5", "6", "7", "Q", "J", "K", "A", "2", "3"};

    // Construtor da classe Jogo. Recebe os nomes dos jogadores e inicializa os atributos
    public Jogo(String nome1, String nome2) {
        jogador1 = new Jogador(nome1);
        jogador2 = new Jogador(nome2);
        baralho = new Baralho();
        scanner = new Scanner(System.in);
        baralho.embaralhar();
        this.valorMao = 1;
    }

    /**
    * .---------------------------------.
    * |      _    ___     ____    ___   |
    * |     | |  / _ \   / ___|  / _ \  |
    * |  _  | | | | | | | |  _  | | | | |
    * | | |_| | | |_| | | |_| | | |_| | |
    * |  \___/   \___/   \____|  \___/  |
    * '---------------------------------'
    */

    // Método que inicializa o jogo
    public void iniciar() {
        // Continua jogando enquanto nenhum jogador atingir 12 pontos
        while (jogador1.getPontos() < 12 && jogador2.getPontos() < 12) {
            novaRodada();
        }
        mostrarResultado();
    }

    private void distribuirCartas() {
        for (int i = 0; i < 3; i++) {
            jogador1.receberCarta(baralho.distribuirCarta());
            jogador2.receberCarta(baralho.distribuirCarta());
        }
    }

    // Método que exibe as cartas disponíveis na mão do jogador
    private void mostrarCartasJogador(Jogador jogador) {
        System.out.println("\n" + jogador.getNome() + ", suas cartas:");
        List<Carta> mao = jogador.getMao(); // Obtém a mão do jogador
        // Itera sobre as cartas da mão e exibe cada uma com seu índice
        for (int i = 0; i < mao.size(); i++) {
            System.out.println((i + 1) + " - " + mao.get(i)); // Mostra o índice
        }
    }

    // Método que inicia uma nova rodada
    private void novaRodada() {
        System.out.println("\nNova rodada iniciada!");
        baralho = new Baralho(); // Cria um novo baralho
        baralho.embaralhar(); // Embaralha o baralho

        vira = baralho.distribuirCarta(); // Define a carta "vira"
        String manilha = determinarManilha(); // Determina a manilha com base na carta "vira"

        System.out.println("Vira: " + vira);
        System.out.println("Manilha: " + manilha);

        ajustarValoresCartas(manilha); // Ajusta os valores das cartas de acordo com a manilha

        jogador1.limparMao();
        jogador2.limparMao();
        distribuirCartas();
        mostrarPontuacoes();
        jogarRodada();
    }

    // Método que permite ao jogador escolher uma carta para jogar
    private Carta escolherCarta(Jogador jogador) {
        while (true) { // Loop para garantir que o jogador escolha uma carta válida
            System.out.println(jogador.getNome() + ", escolha uma carta para jogar (1, 2 ou 3):");

            // Lê a escolha do jogador (subtraindo 1 para ajustar ao índice da lista)
            int escolha = scanner.nextInt() - 1;

            // Tenta jogar a carta escolhida
            Carta cartaEscolhida = jogador.jogarCarta(escolha);
            if (cartaEscolhida != null) { // Se a carta for válida, retorna a carta escolhida
                return cartaEscolhida;
            }
            // Caso a escolha seja inválida, exibe uma mensagem e repete o loop
            System.out.println("Escolha invalida! Tente novamente.");
        }
    }

    // Método que realiza uma rodada do jogo
    private void jogarRodada() {
        int vitoriasJogador1 = 0;
        int vitoriasJogador2 = 0;
        valorMao = 1;
        boolean trucoDisponivel = true; // Indica se o truco pode ser chamado

        // Cada rodada tem até 3 turnos
        for (int i = 0; i < 3; i++) {
            System.out.println("\nRodada " + (i + 1) + " - Valendo " + valorMao + " ponto(s)");

            mostrarCartasJogador(jogador1);

            if (trucoDisponivel) {
                verificarTruco(jogador1, jogador2); // Verifica se o jogador 1 quer chamar truco
                if (valorMao == 0) return; // Se o oponente correr, encerra a rodada
            }

            Carta carta1 = escolherCarta(jogador1);

            mostrarCartasJogador(jogador2);

            if (trucoDisponivel) {
                verificarTruco(jogador2, jogador1); // Verifica se o jogador 2 quer chamar truco
                if (valorMao == 0) return; // Se o oponente correr, encerra a rodada
            }

            Carta carta2 = escolherCarta(jogador2);

            if (valorMao > 1) {
                trucoDisponivel = false; // Após o truco, não pode chamar novamente
            }

            int resultadoRodada = calcularVencedorRodada(carta1, carta2);

            // Atualiza os contadores de vitórias
            if (resultadoRodada == 1) {
                vitoriasJogador1++;
                System.out.println(jogador1.getNome() + " venceu a rodada!");
            } else if (resultadoRodada == 2) {
                vitoriasJogador2++;
                System.out.println(jogador2.getNome() + " venceu a rodada!");
            } else {
                vitoriasJogador1++;
                vitoriasJogador2++;
                System.out.println("Empate na rodada!");
            }

            // Verifica se algum jogador venceu a mão
            if (vitoriasJogador1 == 2) {
                System.out.println(jogador1.getNome() + " ganhou a mao!");
                jogador1.adicionarPontos(valorMao);
                return;
            }
            if (vitoriasJogador2 == 2) {
                System.out.println(jogador2.getNome() + " ganhou a mao!");
                jogador2.adicionarPontos(valorMao);
                return;
            }
        }

        // Caso nenhum jogador vença 2 turnos, verifica o vencedor geral da mão
        if (vitoriasJogador1 > vitoriasJogador2) {
            jogador1.adicionarPontos(valorMao);
            System.out.println(jogador1.getNome() + " ganhou a mao!");
        } else if (vitoriasJogador2 > vitoriasJogador1) {
            jogador2.adicionarPontos(valorMao);
            System.out.println(jogador2.getNome() + " ganhou a mao!");
        } else {
            System.out.println("A mao terminou empatada!");
        }
    }

    private int calcularVencedorRodada(Carta carta1, Carta carta2) {
        if (carta1.getValor() > carta2.getValor()) {
            System.out.println(jogador1.getNome() + " venceu a rodada com " + carta1);
            return 1;
        } else if (carta1.getValor() < carta2.getValor()) {
            System.out.println(jogador2.getNome() + " venceu a rodada com " + carta2);
            return 2;
        } else {
            System.out.println("Empate na rodada! Nenhum jogador recebe pontos.");
            return 0;
        }
    }

    /**
    * .------------------------------------------------------------.
    * |  __  __      _      _   _   ___   _       _   _      _     |
    * | |  \/  |    / \    | \ | | |_ _| | |     | | | |    / \    |
    * | | |\/| |   / _ \   |  \| |  | |  | |     | |_| |   / _ \   |
    * | | |  | |  / ___ \  | |\  |  | |  | |___  |  _  |  / ___ \  |
    * | |_|  |_| /_/   \_\ |_| \_| |___| |_____| |_| |_| /_/   \_\ |
    * '------------------------------------------------------------'
    */

    // Método que determina a manilha com base na carta "vira"
    private String determinarManilha() {
        // Encontra a próxima carta na ordem para definir a manilha
        for (int i = 0; i < ordemCartas.length; i++) {
            if (vira.getNome().equals(ordemCartas[i])) {
                return ordemCartas[(i + 1) % ordemCartas.length];
            }
        }
        return null; // Retorna null se não encontrar (não deve acontecer)
    }

    // Método que ajusta os valores das cartas que são manilhas
    private void ajustarValoresCartas(String manilha) {
        // Mapeia os valores das manilhas por naipe
        Map<String, Integer> valoresManilha = new HashMap<>();
        valoresManilha.put("Paus", 14);
        valoresManilha.put("Copas", 13);
        valoresManilha.put("Espadas", 12);
        valoresManilha.put("Ouros", 11);

        // Percorre todas as cartas do baralho
        for (Carta carta : baralho.getCartas()) {
            // Se a carta for uma a manilha, ajusta seu valor
            if (carta.isManilha(manilha)) {
                carta.setValor(valoresManilha.get(carta.getNaipe()));
            }
        }
    }

    /**
    * .-----------------------------------------.
    * |  _____   ____    _   _    ____    ___   |
    * | |_   _| |  _ \  | | | |  / ___|  / _ \  |
    * |   | |   | |_) | | | | | | |     | | | | |
    * |   | |   |  _ <  | |_| | | |___  | |_| | |
    * |   |_|   |_| \_\  \___/   \____|  \___/  |
    * '-----------------------------------------'
    */

    // Método que verifica se o jogador deseja chamar truco e lida com a resposta do oponente
    private void verificarTruco(Jogador jogador, Jogador oponente) {
        // Verifica se o valor da mão já atingiu o máximo de 12 pontos
        if (valorMao == 12) {
            System.out.println("\nA aposta ja esta no valor maximo de 12 pontos. Nao e possivel aumentar mais.");
            return;
        }

        // Pergunta ao jogador se ele deseja aumentar a aposta
        System.out.println("\n" + jogador.getNome() + ", deseja aumentar a aposta? (S/N)");
        String resposta = scanner.next().toUpperCase(); // Lê a resposta do jogador e converte para maiúsculas

        if (resposta.equals("S")) { // Se o jogador quiser aumentar a aposta
            int[] valoresPossiveis = {3, 6, 9, 12};
            int valorProximo = 0;

            // Determina o próximo valor de aposta maior que o atual
            for (int valor : valoresPossiveis) {
                if (valor > valorMao) {
                    valorProximo = valor;
                    break;
                }
            }

            // Se não houver valor maior, exibe mensagem e retorna
            if (valorProximo == 0) {
                System.out.println("A aposta ja esta no valor maximo de 12 pontos.");
                return;
            }

            // Atualiza o valor da mão e pergunta ao oponente se ele aceita
            valorMao = valorProximo;
            System.out.println("\n" + jogador.getNome() + " aumentou a aposta para " + valorMao + " pontos.");
            System.out.println(oponente.getNome() + ", qual sua resposta?");
            System.out.println("1 - Aceitar");
            System.out.println("2 - Correr");
            System.out.println("3 - Aumentar aposta");

            mostrarCartasJogador(oponente);
            int escolha = scanner.nextInt(); // Lê a escolha do oponente

            // Lida com a escolha do oponente
            switch (escolha) {
                case 1:
                    System.out.println(oponente.getNome() + " aceitou!");
                    break;
                case 2:
                    System.out.println(oponente.getNome() + " correu!");
                    int pontosRecebidos = calcularPontosAoCorrer(valorMao);
                    jogador.adicionarPontos(pontosRecebidos); // Adiciona os pontos ao jogador que chamou truco
                    System.out.println(jogador.getNome() + " ganhou " + pontosRecebidos + " ponto(s)!");
                    valorMao = 0; // Reseta o valor da mão
                    break;
                case 3:
                    aumentarAposta(valorMao, oponente, jogador); // O oponente aumenta a aposta
                    break;
            }
        }
    }

    // Método que aumenta a aposta e lida com a resposta do oponente
    private void aumentarAposta(int valorAtual, Jogador quemAumentou, Jogador oponente) {
        int[] valoresPossiveis = {3, 6, 9, 12}; // Valores possíveis para a aposta

        int valorProximo = 0;
        // Determina o próximo valor de aposta maior que o atual
        for (int valor : valoresPossiveis) {
            if (valor > valorAtual) {
                valorProximo = valor;
                break;
            }
        }

        // Se não houver valor maior, define o valor máximo e retorna
        if (valorProximo == 0) {
            System.out.println("Valor maximo atingido!");
            valorMao = 12;
            return;
        }

        // Atualiza o valor da mão e pergunta ao oponente se ele aceita
        System.out.println("\n" + quemAumentou.getNome() + " aumentou para " + valorProximo + "!");
        System.out.println(oponente.getNome() + ", qual sua resposta?");
        System.out.println("1 - Aceitar");
        System.out.println("2 - Correr");
        System.out.println("3 - Aumentar aposta");

        mostrarCartasJogador(oponente);
        int escolha = scanner.nextInt(); // Lê a escolha do oponente

        // Lida com a escolha do oponente
        switch (escolha) {
            case 1:
                System.out.println(oponente.getNome() + " aceitou!");
                valorMao = valorProximo;
                break;
            case 2:
                System.out.println(oponente.getNome() + " correu!");
                int pontosGanhos = calcularPontosAoCorrer(valorProximo);
                quemAumentou.adicionarPontos(pontosGanhos); // Adiciona os pontos ao jogador que aumentou a aposta
                System.out.println(quemAumentou.getNome() + " ganhou " + pontosGanhos + " ponto(s)!");
                valorMao = 0; // Reseta o valor da mão
                break;
            case 3:
                aumentarAposta(valorProximo, oponente, quemAumentou); // O oponente aumenta a aposta novamente
                break;
        }
    }

    // Método que calcula os pontos ganhos quando um jogador corre
    private int calcularPontosAoCorrer(int valorAposta) {
        // Retorna os pontos correspondentes ao valor da aposta
        switch (valorAposta) {
            case 3:  return 1;
            case 6:  return 3;
            case 9:  return 6;
            case 12: return 9;
            default: return 0;
        }
    }

    /**
    * .---------------------------------------.
    * |  ____    ____    ___   _   _   _____  |
    * | |  _ \  |  _ \  |_ _| | \ | | |_   _| |
    * | | |_) | | |_) |  | |  |  \| |   | |   |
    * | |  __/  |  _ <   | |  | |\  |   | |   |
    * | |_|     |_| \_\ |___| |_| \_|   |_|   |
    * '---------------------------------------'
    */

    private void mostrarPontuacoes() {
        System.out.println("\nPontuacao Atual:");
        System.out.println(jogador1.getNome() + ": " + jogador1.getPontos() + " pontos");
        System.out.println(jogador2.getNome() + ": " + jogador2.getPontos() + " pontos");
    }

    private void mostrarResultado() {
        System.out.println("\nPontuacao Final:");
        System.out.println(jogador1.getNome() + " - " + jogador1.getPontos() + " pontos");
        System.out.println(jogador2.getNome() + " - " + jogador2.getPontos() + " pontos");

        if (jogador1.getPontos() > jogador2.getPontos()) {
            System.out.println(jogador1.getNome() + " venceu a partida!");
        } else if (jogador1.getPontos() < jogador2.getPontos()) {
            System.out.println(jogador2.getNome() + " venceu a partida!");
        } else {
            System.out.println("A partida terminou empatada!");
        }
    }
}