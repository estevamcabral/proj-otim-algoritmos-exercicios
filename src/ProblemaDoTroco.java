import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ProblemaDoTroco {
    
    public static List<Integer> problemaDoTrocoGuloso(List<Integer> moedasDisponiveis, int valorDesejado) {
        moedasDisponiveis.sort((a, b) -> b - a); 

        List<Integer> moedasUsadas = new ArrayList<>();
        int valorTotal = 0;
        for (int i =0; i<moedasDisponiveis.size(); i++){
            Integer moeda = moedasDisponiveis.get(i);
            while (valorTotal + moeda <= valorDesejado) {
                valorTotal += moeda;
                moedasUsadas.add(moeda);
            }    
        }            

        return moedasUsadas;
    }

    public static void main(String[] args) {
        List<Integer> moedasDisponiveis = Arrays.asList(100, 25, 10, 5, 1);
        System.out.println(problemaDoTrocoGuloso(moedasDisponiveis, 150));;
    }
}

