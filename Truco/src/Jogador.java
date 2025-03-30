import java.util.*;

public class Jogador {
    private String nome;
    private List<Carta> mao;
    private int pontos;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public List<Carta> getMao() {
        return mao;
    }

    public void receberCarta(Carta carta) {
        mao.add(carta);
    }

    public void limparMao() {
        mao.clear();
    }

    public void mostrarMao() {
        System.out.println(nome + " tem as cartas: " + mao);
    }

    public Carta jogarCarta(int indice) {
        if (indice >= 0 && indice < mao.size()) {
            return mao.remove(indice);
        }
        System.out.println("Escolha invalida! Tente novamente.");
        return null;
    }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }

    public int getPontos() {
        return pontos;
    }
}