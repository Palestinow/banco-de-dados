import java.util.*;

public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private Baralho baralho;
    private Carta vira;
    private Scanner scanner;
    private int valorMao;
    private String[] ordemCartas = {"4", "5", "6", "7", "Q", "J", "K", "A", "2", "3"};

    public Jogo(String nome1, String nome2) {
        jogador1 = new Jogador(nome1);
        jogador2 = new Jogador(nome2);
        baralho = new Baralho();
        scanner = new Scanner(System.in);
        baralho.embaralhar();
        this.valorMao = 1;
    }

    public void iniciar() {
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

    private void mostrarCartasJogador(Jogador jogador) {
        System.out.println("\n" + jogador.getNome() + ", suas cartas:");
        List<Carta> mao = jogador.getMao();
        for (int i = 0; i < mao.size(); i++) {
            System.out.println((i + 1) + " - " + mao.get(i));
        }
    }

    private void novaRodada() {
        System.out.println("\nNova rodada iniciada!");
        baralho = new Baralho();
        baralho.embaralhar();

        vira = baralho.distribuirCarta();
        String manilha = determinarManilha();

        System.out.println("Vira: " + vira);
        System.out.println("Manilha: " + manilha);

        ajustarValoresCartas(manilha);

        jogador1.limparMao();
        jogador2.limparMao();
        distribuirCartas();
        mostrarPontuacoes();
        jogarRodada();
    }

    private Carta escolherCarta(Jogador jogador) {
        while (true) {
            System.out.println(jogador.getNome() + ", escolha uma carta para jogar (1, 2 ou 3):");

            int escolha = scanner.nextInt() - 1;

            Carta cartaEscolhida = jogador.jogarCarta(escolha);
            if (cartaEscolhida != null) {
                return cartaEscolhida;
            }
            System.out.println("Escolha invalida! Tente novamente.");
        }
    }

    private void jogarRodada() {
        int vitoriasJogador1 = 0;
        int vitoriasJogador2 = 0;
        valorMao = 1;
        boolean trucoDisponivel = true;

        for (int i = 0; i < 3; i++) {
            System.out.println("\nRodada " + (i + 1) + " - Valendo " + valorMao + " ponto(s)");

            mostrarCartasJogador(jogador1);

            if (trucoDisponivel) {
                verificarTruco(jogador1, jogador2);
                if (valorMao == 0) return;
            }

            Carta carta1 = escolherCarta(jogador1);

            mostrarCartasJogador(jogador2);

            if (trucoDisponivel) {
                verificarTruco(jogador2, jogador1);
                if (valorMao == 0) return;
            }

            Carta carta2 = escolherCarta(jogador2);

            if (valorMao > 1) {
                trucoDisponivel = false;
            }

            int resultadoRodada = calcularVencedorRodada(carta1, carta2);

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

    private String determinarManilha() {
        for (int i = 0; i < ordemCartas.length; i++) {
            if (vira.getNome().equals(ordemCartas[i])) {
                return ordemCartas[(i + 1) % ordemCartas.length];
            }
        }
        return null;
    }

    private void ajustarValoresCartas(String manilha) {
        Map<String, Integer> valoresManilha = new HashMap<>();
        valoresManilha.put("Paus", 14);
        valoresManilha.put("Copas", 13);
        valoresManilha.put("Espadas", 12);
        valoresManilha.put("Ouros", 11);

        for (Carta carta : baralho.getCartas()) {
            if (carta.isManilha(manilha)) {
                carta.setValor(valoresManilha.get(carta.getNaipe()));
            }
        }
    }

    private void verificarTruco(Jogador jogador, Jogador oponente) {
        if (valorMao == 12) {
            System.out.println("\nA aposta ja esta no valor maximo de 12 pontos. Nao e possivel aumentar mais.");
            return;
        }

        System.out.println("\n" + jogador.getNome() + ", deseja aumentar a aposta? (S/N)");
        String resposta = scanner.next().toUpperCase();

        if (resposta.equals("S")) {
            int[] valoresPossiveis = {3, 6, 9, 12};
            int valorProximo = 0;

            for (int valor : valoresPossiveis) {
                if (valor > valorMao) {
                    valorProximo = valor;
                    break;
                }
            }

            if (valorProximo == 0) {
                System.out.println("A aposta ja esta no valor maximo de 12 pontos.");
                return;
            }

            valorMao = valorProximo;
            System.out.println("\n" + jogador.getNome() + " aumentou a aposta para " + valorMao + " pontos.");
            System.out.println(oponente.getNome() + ", qual sua resposta?");
            System.out.println("1 - Aceitar");
            System.out.println("2 - Correr");
            System.out.println("3 - Aumentar aposta");

            mostrarCartasJogador(oponente);
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println(oponente.getNome() + " aceitou!");
                    break;
                case 2:
                    System.out.println(oponente.getNome() + " correu!");
                    int pontosRecebidos = calcularPontosAoCorrer(valorMao);
                    jogador.adicionarPontos(pontosRecebidos);
                    System.out.println(jogador.getNome() + " ganhou " + pontosRecebidos + " ponto(s)!");
                    valorMao = 0;
                    break;
                case 3:
                    aumentarAposta(valorMao, oponente, jogador);
                    break;
            }
        }
    }

    private void aumentarAposta(int valorAtual, Jogador quemAumentou, Jogador oponente) {
        int[] valoresPossiveis = {3, 6, 9, 12};

        int valorProximo = 0;
        for (int valor : valoresPossiveis) {
            if (valor > valorAtual) {
                valorProximo = valor;
                break;
            }
        }

        if (valorProximo == 0) {
            System.out.println("Valor maximo atingido!");
            valorMao = 12;
            return;
        }

        System.out.println("\n" + quemAumentou.getNome() + " aumentou para " + valorProximo + "!");
        System.out.println(oponente.getNome() + ", qual sua resposta?");
        System.out.println("1 - Aceitar");
        System.out.println("2 - Correr");
        System.out.println("3 - Aumentar aposta");

        mostrarCartasJogador(oponente);
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println(oponente.getNome() + " aceitou!");
                valorMao = valorProximo;
                break;
            case 2:
                System.out.println(oponente.getNome() + " correu!");
                int pontosGanhos = calcularPontosAoCorrer(valorProximo);
                quemAumentou.adicionarPontos(pontosGanhos);
                System.out.println(quemAumentou.getNome() + " ganhou " + pontosGanhos + " ponto(s)!");
                valorMao = 0;
                break;
            case 3:
                aumentarAposta(valorProximo, oponente, quemAumentou);
                break;
        }
    }

    private int calcularPontosAoCorrer(int valorAposta) {
        switch (valorAposta) {
            case 3:  return 1;
            case 6:  return 3;
            case 9:  return 6;
            case 12: return 9;
            default: return 0;
        }
    }

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