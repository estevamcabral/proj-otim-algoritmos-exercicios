import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Subconjuntos {

    public List<List<Integer>> calcSubConjunto(List<Integer> lista) {
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        List<List<Integer>> emptyList = new ArrayList<>();
        emptyList.add(new ArrayList<>());
        map.put(0, emptyList);

        for (Integer numero : lista) {
            Set<Integer> keys = new HashSet<>(map.keySet());

            for (Integer chave : keys) {
                int novaSoma = chave + numero;

                for (List<Integer> subconjuntoExistente : map.get(chave)) {
                    List<Integer> novoSubconjunto = new ArrayList<>(subconjuntoExistente);
                    novoSubconjunto.add(numero);

                    map.computeIfAbsent(novaSoma, k -> new ArrayList<>()).add(novoSubconjunto);
                }
            }
        }

        return map.getOrDefault(0, new ArrayList<>());
    }

    public static void main(String[] args) {
        Subconjuntos subconjuntos = new Subconjuntos();
        List<Integer> subconjunto = Arrays.asList(1, 2, -1, -2);

        List<List<Integer>> resultados = subconjuntos.calcSubConjunto(subconjunto);
        resultados.remove(0);

        for (List<Integer> resultado : resultados) {
            System.out.println(resultado);
        }
    }
}
