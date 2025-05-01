public class DistanciaDeEdicaoDinamico {

    public static int distanciaDeEdicaoDinamico(String a, String b) {
        int m = a.length();
        int n = b.length();

        int[][] matriz = new int[m + 1][n + 1];

        int iteracoes = 0;
        int operacoes = 0;
        for (int i = 0; i <= m; i++) {
            matriz[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            matriz[0][j] = j;
        }

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                iteracoes++;

                int custoExtra = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                operacoes++;

                int remocao = matriz[i - 1][j] + 1;
                int insercao = matriz[i][j - 1] + 1;
                int substituicao = matriz[i - 1][j - 1] + custoExtra;

                matriz[i][j] = Math.min(remocao, Math.min(insercao, substituicao));
                operacoes += 2;
            }
        }

        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;

        System.out.println("s:Iteraçõe " + iteracoes);
        System.out.println("Operações: " + operacoes);
        System.out.println("Tempo de execução: " + tempoExecucao + " ms");
                
        
        
        return matriz[m][n];
    }

    public static void main(String[] args) {
        // Caso pequeno
        String sPequeno1 = "Casablanca";
        String sPequeno2 = "Portentoso";
        System.out.println("===== CASO PEQUENO =====");
        int distanciaPequeno = distanciaDeEdicaoDinamico(sPequeno1, sPequeno2);
        System.out.println("Distância de edição: " + distanciaPequeno);

        // Caso grande
        System.out.println("\n===== CASO GRANDE =====");
        String s1 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
            "simplify the build processes in the Jakarta Turbine project. There were several" + 
            " projects, each with their own Ant build files, that were all slightly different." +
            "JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+ 
            "definition of what the project consisted of, an easy way to publish project information" +
            "and a way to share JARs across several projects. The result is a tool that can now be" +
            "used for building and managing any Java-based project. We hope that we have created " +
            "something that will make the day-to-day work of Java developers easier and generally help " +
            "with the comprehension of any Java-based project.";

        String s2 = "This post is not about deep learning. But it could be might as well. This is the power of " +
            "kernels. They are universally applicable in any machine learning algorithm. Why you might" +
            "ask? I am going to try to answer this question in this article." + 
            "Go to the profile of Marin Vlastelica Pogančić" + 
            "Marin Vlastelica Pogančić Jun";

        int distanciaGrande = distanciaDeEdicaoDinamico(s1, s2);
        System.out.println("Distância de edição: " + distanciaGrande);
    }
}
