public class Carta {
    private String naipe;
    private String nome;
    private int valor;

    public Carta(String nome, int valor, String naipe) {
        this.nome = nome;
        this.valor = valor;
        this.naipe = naipe;
    }

    public String getNaipe() {
        return naipe;
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isManilha(String manilha) {
        return this.nome.equals(manilha);
    }

    @Override
    public String toString() {
        return nome + " de " + naipe;
    }
}