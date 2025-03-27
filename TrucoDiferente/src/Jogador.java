import java.util.*;

public class Jogador {
    private String nome;
    private List<Carta> mao;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getTamanhoMao() {
        return mao.size();
    }

    public void receberCarta(Carta carta) {
        mao.add(carta);
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

    public boolean temCartas() {
        return !mao.isEmpty();
    }

    public int pontuacoes() {
        int pontuacaoRodada = 0;
        return pontuacaoRodada;
    }
}