import java.util.*;

public class Jogador {
    private String nome;
    private List<Carta> mao;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
    }

    public void receberCarta(Carta carta) {
        mao.add(carta);
    }

    public void mostrarMao() {
        System.out.println(nome + " tem as cartas: " + mao);
    }
}