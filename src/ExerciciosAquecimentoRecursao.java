import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExerciciosAquecimentoRecursao {
    
        public static int multplicacaoDoisNumerosNaturaisSomasSucessivas(int n1, int n2) {
            if (n2 == 0) return 0;

            return n1 + multplicacaoDoisNumerosNaturaisSomasSucessivas(n1, n2-1);
        }
        
        public static int somaDeDoisNumerosNaturaisIncrementosSucessivos(int n1, int n2) {
            if (n1 > 0) {
                return 1 + somaDeDoisNumerosNaturaisIncrementosSucessivos(n1-1, n2);
            }
            else if (n2 > 0) {
                return 1 + somaDeDoisNumerosNaturaisIncrementosSucessivos(n1, n2-1);
            }
            
            return 0;
        }

        public static float divisaoSucessiva(int n) {
            if (n == 0) return 0;
        
            return 1.0f / n + divisaoSucessiva(n-1);
        }

        public static String inversaoString(String str) {
            if (str == "") return "";
            return inversaoString(str.substring(1)) + str.charAt(0);
        }

        public static int geradorDeSequencia(int n) {
            if (n==0) return 0;
            if (n==1) return 1;
            if (n==2) return 2;

            return (2 * geradorDeSequencia(n-1)) + (3 * geradorDeSequencia(n-2));
        }

        public static int sequenciaDeAckerman(int m, int n) {
            if (m == 0) return n + 1;
            if (n == 0) return sequenciaDeAckerman(m - 1, 1);
        
            return sequenciaDeAckerman(m - 1, sequenciaDeAckerman(m, n - 1));
        }

        public static int somarVetor (List<Integer> lista) {
            if (lista.size() == 0) return 0;
            if (lista.size() == 1) return lista.get(0);

            return lista.get(0) + somarVetor(lista.subList(1, lista.size()));
        }

        public static int multiplicarVetor(List<Integer> lista) {
            if (lista.size() == 0) return 0;
            if (lista.size() == 1) return lista.get(0);

            return lista.get(0) * multiplicarVetor(lista.subList(1, lista.size()));
        }

        public static boolean verificarPalindromo(String str) {
            if (str.length() <= 1) return true; 
            if (str.charAt(0) != str.charAt(str.length() - 1)) return false;
            return verificarPalindromo(str.substring(1, str.length()));
        }
        
        public static String aux(int inicio, int fim, int index, List<Character> alfabeto) {
            if (inicio == fim) return "";  
        
            String result = ""; 
        
            for (int i = inicio; i < fim; i++) {
                if (i != index) { 
                    result += alfabeto.get(i); 
                }
                result += aux(i + 1, fim, index, alfabeto);  
            }
        
            return result;
        }
        
        public static String todasCombinacoesAlfabeto(int n) {
            List<Character> alfabeto = new ArrayList<>();
            
            for (char c = 'A'; c < 'A' + n; c++) {  
                alfabeto.add(c);
            }
            
            return aux(0, n, n - 1, alfabeto);  
        }

        public static Integer acharMaiorValorDivisaoEConsquista(List<Integer> lista) {
            if (lista.size()<=1) {
                return lista.get(0);
            }

            int metade = lista.size()/2;
            List<Integer> esquerda = lista.subList(0, metade);
            List<Integer> direita = lista.subList(metade, lista.size());

            return Math.max(acharMaiorValorDivisaoEConsquista(esquerda), acharMaiorValorDivisaoEConsquista(direita));
        }

        //Realiza muitas operacoes repitidas
        public static int fibonacciRecursivo(int n){
            if (n==0) return 0;
            if (n==1 || n ==2) return 1;

            return fibonacciRecursivo(n-2) + fibonacciRecursivo(n-1);
        }

        //Usando programacao dinamica
        public static int fibonacciDinamico(int n){
            int[] resultados = new int[n+1];
            resultados[0] = 0;
            resultados[1] = 1;

            for (int i=2;i<=n;i++) {
                resultados[i] = resultados[i-2] + resultados[i-1];
            }

            return resultados[n];
        }

        public static int fibonacciMemoizadoAux(int n, int[] memo) {
            if(memo[n] >= 0){
                return memo[n];
            }
            if (n<=1) {
                memo[n] = n;
                return memo[n];
            } 
            
            memo[n] = fibonacciMemoizadoAux(n-2, memo) + fibonacciMemoizadoAux(n-1, memo);


            return memo[n];
        }
        //Usando memoizacao
        public static int fibonacciMemoizado(int n) {
            int[] memo = new int[n+1];

            for (int i = 0; i < memo.length; i++) {
                memo[i] = -1;
            }

            return fibonacciMemoizadoAux(n, memo);
        }

        public static boolean verificarMatchString (String str, String match) {
            if (match.length()>str.length()) return false;
            if (str.substring(0, match.length()).equals(match)) return true;
            
            return verificarMatchString(str.substring(1), match);
        }

        
        

        
    public static void main(String[] args) {
        System.out.println("Multiplicação dois numeros naturais sucessivamente: " + multplicacaoDoisNumerosNaturaisSomasSucessivas(3, 5));
        System.out.println("Soma de dois numeros naturais por incremento sucessivo: " + somaDeDoisNumerosNaturaisIncrementosSucessivos(3, 4));
        System.out.println("Divisao sucessiva: " + divisaoSucessiva(3));
        System.out.println("Inversao String: " + inversaoString("casa"));
        System.out.println("Gerador de sequencia: " + geradorDeSequencia(6));
        System.out.println("Sequencia de ackerman: " + sequenciaDeAckerman(2, 6));
        System.out.println("Somar vetor: " + somarVetor(Arrays.asList(3,5,7)));
        System.out.println("Multiplicar vetor: " + multiplicarVetor(Arrays.asList(2,2,2)));
        System.out.println("Verificar se eh palindromo: " + verificarPalindromo("xyzzyx"));
        System.out.println("Combinacoes alfabeto ate C: " + todasCombinacoesAlfabeto(3));
        System.out.println("Achar maior valor divisao e conquista: " + acharMaiorValorDivisaoEConsquista(Arrays.asList(1,20,10,3,4,5,6,7)));
        System.out.println("Fibonacci recursivo 7: " + fibonacciRecursivo(7));
        System.out.println("Fibonacci dinamico 7: " + fibonacciDinamico(7));
        System.out.println("Fibonacci memoizado 7: " + fibonacciMemoizado(7));
        System.out.println("Verificar match string: " + verificarMatchString("casa", "asa"));
    }
}
