import java.util.*; // Importa todas as classes do pacote java.util

public class Jogador {
    private String nome;
    private List<Carta> mao; // Lista que representa a mão do jogador (as cartas que ele possui)
    private int pontos;

    // Construtor da classe Jogador, recebe o nome do Jogador como parâmetro e inicializa a mão e os pontos
    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
        this.pontos = 0;
    }

    // Método que retorna o nome do jogador
    public String getNome() {
        return nome;
    }

    // Método que retorna a lista de cartas que o jogador possui (sua mão)
    public List<Carta> getMao() {
        return mao;
    }

    // Método que permite ao jogador receber uma carta. Adiciona a carta recebida à lista de cartas (mão) do jogador
    public void receberCarta(Carta carta) {
        mao.add(carta);
    }

    // Método que limpa a mão do jogador. Remove todas as cartas da lista de cartas (mão) do jogador
    public void limparMao() {
        mao.clear();
    }

    // Método que exibe as cartas na mão do jogador. Mostra o nome do jogador e as cartas que ele possui
    public void mostrarMao() {
        System.out.println(nome + " tem as cartas: " + mao);
    }

    // Método que permite ao jogador jogar uma carta. Recebe o índice da carta a ser jogada como parâmetro e remove essa carta da mão do jogador
    public Carta jogarCarta(int indice) {
        // Verifica se o índice é válido (dentro do tamanho da lista)
        if (indice >= 0 && indice < mao.size()) {
            return mao.remove(indice); // Remove e retorna a carta escolhida
        }
        // Caso o índice seja inválido, exibe uma mensagem de erro
        System.out.println("Escolha invalida! Tente novamente.");
        return null;
    }

    // Método que adiciona pontos ao jogador. Recebe a quantidade de pontos a serem adicionados como parâmetro e atualiza o total de pontos do jogador
    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }

    // Método que retorna a pontuação atual do jogador
    public int getPontos() {
        return pontos;
    }
}