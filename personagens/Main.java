public class Main {
    public static void main(String[] args) {
        Personagem arqueiro = new Arqueiro();
        arqueiro.lutar();

        Personagem guerreiro = new Guerreiro();
        guerreiro.lutar();

        arqueiro.setTipodeLuta(new LutaComEspada());
        arqueiro.lutar();
    }
}