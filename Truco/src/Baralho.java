import java.util.*;

public class Baralho {
    private List<Carta> cartas;

    public Baralho() {
        cartas = new ArrayList<>();
        String[] naipes = {"Paus", "Copas", "Espadas", "Ouros",};
        String[] nomes = {"4", "5", "6", "7", "Q", "J", "K", "A", "2", "3"};
        int[] valores = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < nomes.length; i++) {
            for (String naipe : naipes) {
                cartas.add(new Carta(nomes[i], valores[i], naipe));
            }
        }
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta distribuirCarta() {
        return cartas.remove(0);
    }
}