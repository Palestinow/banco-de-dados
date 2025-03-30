import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nome do Jogador 1: ");
            String nome1 = scanner.nextLine();

            System.out.print("Nome do Jogador 2: ");
            String nome2 = scanner.nextLine();

            Jogo jogo = new Jogo(nome1, nome2);
            jogo.iniciar();
        }
    }
}