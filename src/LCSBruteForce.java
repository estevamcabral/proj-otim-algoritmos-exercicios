public class LCSBruteForce {

    private String maior = "";
    private int iteracoes = 0;

    private String testandoSubsequencia(String combinacao, String subsequencia) {
        int i = 0;
        int j = 0;
        StringBuilder maiorSubsequenciaExistente = new StringBuilder();

        while (i < combinacao.length() && j < subsequencia.length()) {
            if (combinacao.charAt(i) == subsequencia.charAt(j)) {
                maiorSubsequenciaExistente.append(combinacao.charAt(i));
                i++;
            }
            j++;
        }

        return maiorSubsequenciaExistente.toString();
    }

    private void testandoTodasCombinacoes(int index, String palavra, String combinacao, String subsequencia) {
        iteracoes++;
        if (index == palavra.length()) {
            String match = testandoSubsequencia(combinacao, subsequencia);
            if (match.length() > maior.length()) {
                maior = match;
            }
            return;
        }

        testandoTodasCombinacoes(index + 1, palavra, combinacao, subsequencia);
        testandoTodasCombinacoes(index + 1, palavra, combinacao + palavra.charAt(index), subsequencia);
    }

    public String encontrarMaiorSubsequencia(String palavra, String subsequencia) {
        maior = "";
        iteracoes = 0;
        testandoTodasCombinacoes(0, palavra, "", subsequencia);
        System.out.println("Iterações: " + iteracoes);
        return maior;
    }

    public static void main(String[] args) {
        LCSBruteForce lcs = new LCSBruteForce();
        String resultado = lcs.encontrarMaiorSubsequencia("abcde", "bel");
        System.out.println("Maior subsequência: " + resultado);
    }
}
