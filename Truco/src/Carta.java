public class Carta {
    private String naipe;
    private String nome;
    private int valor;

    public Carta(String nome, int valor, String naipe) {
        this.nome = nome;
        this.valor = valor;
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return nome + " de " + naipe;
    }
}