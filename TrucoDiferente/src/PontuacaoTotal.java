public class PontuacaoTotal {
    private int pontosJogador1;
    private int pontosJogador2;
    private int multiplicador;

    public PontuacaoTotal() {
        this.pontosJogador1 = 0;
        this.pontosJogador2 = 0;
        this.multiplicador = 1;
    }

    public void trucar() {
        if (multiplicador == 1) multiplicador = 3;
        else if (multiplicador == 3) multiplicador = 6;
        else if (multiplicador == 6) multiplicador = 9;
        else if (multiplicador == 9) multiplicador = 12;
        System.out.println("Truco! Agora a rodada vale " + multiplicador + " pontos.");
    }

    public void adicionarPontos(boolean jogador1Venceu) {
        if (jogador1Venceu) {
            pontosJogador1 += multiplicador;
        } else {
            pontosJogador2 += multiplicador;
        }
        multiplicador = 1;
    }

    public void exibirPontuacao() {
        System.out.println("Pontuação Atual:");
        System.out.println("Jogador 1: " + pontosJogador1 + " pontos");
        System.out.println("Jogador 2: " + pontosJogador2 + " pontos");
    }
}