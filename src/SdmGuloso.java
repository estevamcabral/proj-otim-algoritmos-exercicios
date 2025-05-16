import java.util.*;

class Intervalo {
    int inicio;
    int fim;

    Intervalo(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }
}

public class SdmGuloso {

    public static List<Intervalo> selecionarIntervalos(List<Intervalo> intervalos) {
        intervalos.sort(Comparator.comparingInt(i -> i.fim));

        List<Intervalo> resultado = new ArrayList<>();
        int ultimoFim = Integer.MIN_VALUE;

        for (Intervalo intervalo : intervalos) {
            if (intervalo.inicio >= ultimoFim) {
                resultado.add(intervalo);
                ultimoFim = intervalo.fim;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        List<Intervalo> entrada = Arrays.asList(
            new Intervalo(5, 7),
            new Intervalo(3, 9),
            new Intervalo(6, 10),
            new Intervalo(8, 11),
            new Intervalo(8, 12),
            new Intervalo(2, 14),
            new Intervalo(12, 16),
            new Intervalo(5, 9),
            new Intervalo(1, 4),
            new Intervalo(3, 5),
            new Intervalo(0, 6)
        );

        List<Intervalo> selecionados = selecionarIntervalos(entrada);

        System.out.println("Intervalos selecionados:");
        for (Intervalo i : selecionados) {
            System.out.println("[" + i.inicio + ", " + i.fim + "]");
        }
    }
}
