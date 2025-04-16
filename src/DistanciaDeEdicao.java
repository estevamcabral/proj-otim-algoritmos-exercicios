public class DistanciaDeEdicao {
    private static int iteracoes = 0;
    private static int operacoes = 0;

    public static int substituir(String str1, String str2, int i, int j) {
        iteracoes++;
        operacoes++;
        return distanciaDeEdicao(str1, str2, i - 1, j - 1) + 1;
    }

    public static int insercao(String str1, String str2, int i, int j) {
        iteracoes++;
        operacoes++;
        return distanciaDeEdicao(str1, str2, i, j - 1) + 1;
    }

    public static int delecao(String str1, String str2, int i, int j) {
        iteracoes++;
        operacoes++;
        return distanciaDeEdicao(str1, str2, i - 1, j) + 1;
    }

    public static int distanciaDeEdicao(String str1, String str2, int i, int j) {
        iteracoes++;
        operacoes++; 

        if (i < 0 && j < 0) {
            operacoes++; 
            return 0;
        }

        operacoes++; 
        if (i < 0) {
            operacoes++; 
            return j + 1;
        }

        operacoes++; 
        if (j < 0) {
            operacoes++; 
            return i + 1;
        }

        operacoes++; 
        if (str1.charAt(i) == str2.charAt(j)) {
            operacoes++; 
            return distanciaDeEdicao(str1, str2, i - 1, j - 1);
        }

        int sub = substituir(str1, str2, i, j);
        int ins = insercao(str1, str2, i, j);
        int del = delecao(str1, str2, i, j);

        operacoes += 2; 

        return Math.min(Math.min(sub, ins), del);
    }

    public static void main(String[] args) {
        String str1 = "Casablanca";
        String str2 = "Portentoso";

        iteracoes = 0;
        operacoes = 0;

        long inicio = System.currentTimeMillis();
        int resultado = distanciaDeEdicao(str1, str2, str1.length() - 1, str2.length() - 1);
        long fim = System.currentTimeMillis();

        System.out.println("Distância de edição: " + resultado);
        System.out.println("Número de iterações: " + iteracoes);
        System.out.println("Número de operações: " + operacoes);
        System.out.println("Tempo de execução: " + (fim - inicio) + " ms");
    }
}
