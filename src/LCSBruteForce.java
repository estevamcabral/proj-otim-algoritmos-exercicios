public class LCSBruteForce {

    private String maior = "";
    private int iteracoes = 0;

    public String testandoSubsequencia(String combinacao, String subsequencia) {
        int i = 0;
        int j = 0;
        String maiorSubsequenciaExistente = "";

        while (i < combinacao.length() && j < subsequencia.length()) {
            if (combinacao.charAt(i) == subsequencia.charAt(j)) {
                maiorSubsequenciaExistente += combinacao.charAt(i);
                i++;
            }

            j++;
        }

        return maiorSubsequenciaExistente;
    }

    public void testandoTodasCombinacoes(int index, String palavra, String combinacao, String subsequencia) {
        iteracoes++;
        if (index == palavra.length()) {
           
            String match = testandoSubsequencia(combinacao, subsequencia);
            if (match.length() > this.maior.length()) {
                this.maior = match;
            }

            return;
        }
        
        testandoTodasCombinacoes(index + 1, palavra, combinacao, subsequencia);
        testandoTodasCombinacoes(index + 1, palavra, combinacao + palavra.charAt(index), subsequencia);
    }

    public void main(String[] args) {
        testandoTodasCombinacoes(0, "abcdsdvlkdnfebvloelssdvjkneiuwhpvdjnsdjbgh", "", "sadakjshjebfqoqwiubfv");
        System.out.println("Maior: " + this.maior);
        System.out.println("Iterações: " + this.iteracoes);
    }
}