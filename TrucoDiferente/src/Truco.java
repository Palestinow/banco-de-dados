import java.util.Scanner;

public class Truco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Jogador 1: ");
        String nome1 = scanner.nextLine();

        System.out.print("Nome do Jogador 2: ");
        String nome2 = scanner.nextLine();

        Partida partida = new Partida(nome1, nome2);
        partida.iniciar();

        scanner.close();
    }
}