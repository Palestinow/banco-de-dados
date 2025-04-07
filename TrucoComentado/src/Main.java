// Importa a classe Scanner do pacote java.util para ler entradas do usuário
import java.util.Scanner;

// Classe principal do programa
public class Main {
    // Método principal que inicia a execução do programa
    public static void main(String[] args) {
        // Cria um objeto Scanner para capturar a entrada do usuário
        // O bloco try-with-resources garante que o scanner será fechado automaticamente após o uso
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicita o nome do Jogador 1 e armaze na variável nome1
            System.out.print("Nome do Jogador 1: ");
            String nome1 = scanner.nextLine(); // Lê a entrada do usuário para o nome do Jogador 1

            // Solicita o nome do Jogador 2 e armaze na variável nome2
            System.out.print("Nome do Jogador 2: ");
            String nome2 = scanner.nextLine(); // Lê a entrada do usuário para o nome do Jogador 2

            // Cria uma instância da classe Jogo, passando os nomes dos jogadores como parâmetros
            Jogo jogo = new Jogo(nome1, nome2);
            // Inicia o jogo chamando o método iniciar da classe Jogo
            jogo.iniciar();
        }
    }
}