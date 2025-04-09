import java.util.*; // Importa todas as classes do pacote java.util

public class Baralho {
    // Lista que armazena todas as cartas do baralho
    private List<Carta> cartas;

    // Construtor que inicializa o baralho com 40 cartas
    public Baralho() {
        cartas = new ArrayList<>(); // Inicializa a lista de cartas
        // Define os naipes, nomes e valores das cartas
        String[] naipes = {"Paus", "Copas", "Espadas", "Ouros",};
        String[] nomes = {"4", "5", "6", "7", "Q", "J", "K", "A", "2", "3"};
        int[] valores = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Loop para criar todas as combinações de cartas (nome + naipe)
        for (int i = 0; i < nomes.length; i++) {
            // Itera sobre elementos de uma coleção ou array de forma simplificada (for-each loop)
            for (String naipe : naipes) {
                // Adiciona uma nova carta ao baralho com o nome, valor e naipe correspondente
                cartas.add(new Carta(nomes[i], valores[i], naipe));
            }
        }
    }

    // Método que retorna a lista de cartas do baralho
    public List<Carta> getCartas() {
        return cartas;
    }

    // Método que embaralha as cartas do baralho
    public void embaralhar() {
        // Utiliza o método shuffle da classe Collections para embaralhar a lista de cartas
        Collections.shuffle(cartas);
    }

    // Método que distribui uma carta do topo do baralho
    public Carta distribuirCarta() {
        // Remove e retorna a carta do topo do baralho (índice 0)
        return cartas.remove(0);
    }
}