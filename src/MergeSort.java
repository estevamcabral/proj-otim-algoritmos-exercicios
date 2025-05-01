import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static List<Integer> merge(List<Integer> esquerda, List<Integer> direita) {
        int i = 0;
        int j = 0;
        List<Integer> novaLista = new ArrayList<>();

        while (i < esquerda.size() && j < direita.size()) {
            if (esquerda.get(i) < direita.get(j)) {
                novaLista.add(esquerda.get(i));
                i++;
            } else {
                novaLista.add(direita.get(j));
                j++;
            }
        }

        while (i < esquerda.size()) {
            novaLista.add(esquerda.get(i));
            i++;
        }
        
        while (j < direita.size()) {
            novaLista.add(direita.get(j));
            j++;
        }

        return novaLista;
    }


    public static List<Integer> mergeSort (List<Integer> lista){
        if (lista.size() <= 1) return lista;
        List<Integer> esquerda = mergeSort(lista.subList(0, lista.size()/2));
        List<Integer> direita = mergeSort(lista.subList(lista.size()/2, lista.size()));

        return merge(esquerda, direita);
    }

    public static void main(String[] args) {
        System.out.println("Array ordenado: " + mergeSort(Arrays.asList(5,23,7,1,3,8,5)));
    }
}
