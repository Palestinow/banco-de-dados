import java.util.*;

public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private Baralho baralho;
    private Scanner scanner;

    public Jogo(String nome1, String nome2) {
        jogador1 = new Jogador(nome1);
        jogador2 = new Jogador(nome2);
        baralho = new Baralho();
        scanner = new Scanner(System.in);
        baralho.embaralhar();
    }

    public void iniciar() {
        while (jogador1.getPontos() < 12 && jogador2.getPontos() < 12) {
            novaRodada();
        }
        mostrarResultado();
    }

    private void novaRodada() {
        System.out.println("\nNova rodada iniciada!");
        baralho = new Baralho();
        baralho.embaralhar();

        jogador1.limparMao();
        jogador2.limparMao();
        distribuirCartas();
        mostrarPontuacoes();
        jogarRodada();
    }

    private void distribuirCartas() {
        for (int i = 0; i < 3; i++) {
            jogador1.receberCarta(baralho.distribuirCarta());
            jogador2.receberCarta(baralho.distribuirCarta());
        }
    }

    private void mostrarPontuacoes() {
        System.out.println("\nPontuacao Atual:");
        System.out.println(jogador1.getNome() + ": " + jogador1.getPontos() + " pontos");
        System.out.println(jogador2.getNome() + ": " + jogador2.getPontos() + " pontos");
    }

    private void jogarRodada() {
        for (int i = 0; i < 3; i++) {
            System.out.println("\nRodada " + (i + 1));

            Carta carta1 = escolherCarta(jogador1);
            Carta carta2 = escolherCarta(jogador2);

            calcularVencedorRodada(carta1, carta2);

            if (jogador1.getPontos() >= 12 || jogador2.getPontos() >= 12) {
                return;
            }
        }
    }

    private Carta escolherCarta(Jogador jogador) {
        while (true) {
            System.out.println(jogador.getNome() + ", escolha uma carta para jogar (1, 2 ou 3):");

            List<Carta> mao = jogador.getMao();
            for (int i = 0; i < mao.size(); i++) {
                System.out.println((i + 1) + " - " + mao.get(i));
            }

            int escolha = scanner.nextInt() - 1;

            Carta cartaEscolhida = jogador.jogarCarta(escolha);
            if (cartaEscolhida != null) {
                return cartaEscolhida;
            }
        }
    }

    private void calcularVencedorRodada(Carta carta1, Carta carta2) {
        if (carta1.getValor() > carta2.getValor()) {
            System.out.println(jogador1.getNome() + " venceu a rodada com " + carta1);
            jogador1.adicionarPontos(1);
        } else if (carta1.getValor() < carta2.getValor()) {
            System.out.println(jogador2.getNome() + " venceu a rodada com " + carta2);
            jogador2.adicionarPontos(1);
        } else {
            System.out.println("Empate na rodada! Nenhum jogador recebe pontos.");
        }
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