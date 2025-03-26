public class Partida {
    private Jogador jogador1;
    private Jogador jogador2;
    private Baralho baralho;

    public Partida(String nome1, String nome2) {
        jogador1 = new Jogador(nome1);
        jogador2 = new Jogador(nome2);
        baralho = new Baralho();
        baralho.embaralhar();
    }

    public void iniciar() {
        for (int i = 0; i < 3; i++) {
            jogador1.receberCarta(baralho.distribuirCarta());
            jogador2.receberCarta(baralho.distribuirCarta());
        }

        jogador1.mostrarMao();
        jogador2.mostrarMao();
    }
}