import java.util.Scanner;

public class Partida {
    private Jogador jogador1;
    private Jogador jogador2;
    private Baralho baralho;
    private Scanner scanner;

    public Partida(String nome1, String nome2) {
        jogador1 = new Jogador(nome1);
        jogador2 = new Jogador(nome2);
        baralho = new Baralho();
        scanner = new Scanner(System.in);
        baralho.embaralhar();
    }

    public void iniciar() {
        for (int i = 0; i < 3; i++) {
            jogador1.receberCarta(baralho.distribuirCarta());
            jogador2.receberCarta(baralho.distribuirCarta());
        }

        jogador1.mostrarMao();
        jogador2.mostrarMao();

        jogarRodada();
    }

    private void jogarRodada() {
        Jogador jogadorAtual = jogador1;
        while (jogador1.pontuacoes() < 2 && jogador2.pontuacoes() < 2) {
            System.out.println("\n" + jogadorAtual.getNome() + ", escolha uma carta para jogar:");
            jogadorAtual.mostrarMao();
            System.out.print("Digite o número da posição (1-" + jogadorAtual.getTamanhoMao() + "): ");

            int escolha = scanner.nextInt() - 1;
            Carta jogada = jogadorAtual.jogarCarta(escolha);

            if (jogada != null) {
                System.out.println(jogadorAtual.getNome() + " jogou " + jogada);
                jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
            }

            if (jogador1.pontuacoes() >= 2 || jogador2.pontuacoes() >= 2) {
                break;
            }
        }

        System.out.println("\nFim da partida!");
    }
}