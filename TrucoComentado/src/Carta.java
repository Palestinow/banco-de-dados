public class Carta {
    private String naipe;
    private String nome;
    private int valor;

    // Construtor da classe Carta que inicializa os atributos nome, valor e naipe
    public Carta(String nome, int valor, String naipe) {
        this.nome = nome;
        this.valor = valor;
        this.naipe = naipe;
    }

    // Método que retorna o naipe da carta
    public String getNaipe() {
        return naipe;
    }

    // Método que retorna o nome da carta
    public String getNome() {
        return nome;
    }

    // Método que retorna o valor da carta
    public int getValor() {
        return valor;
    }

    // Método setter para o atributo valor, permite alterar o valor da carta
    public void setValor(int valor) {
        this.valor = valor;
    }

    // Método que verifica se a carta é uma manilha, recebe o nome da manilha como parâmetro e compara com o nome da carta
    public boolean isManilha(String manilha) {
        return this.nome.equals(manilha); // Retorna true se o nome da carta for igual ao nome da manilha
    }

    // Método sobrescrito da classe Object
    // Retorna uma representação em texto da carta (ex.: "4 de Paus")
    @Override
    public String toString() {
        return nome + " de " + naipe; // Concatena o nome e o naipe da carta
    }
}