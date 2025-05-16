import java.util.ArrayList;

public class ProblemaDaRainha {
    private static VerificarPosicionamentoRainha verificarPosicionamentoRainha = new VerificarPosicionamentoRainha();
    private static ArrayList<Integer[][]> solucoes = new ArrayList<>();

    public static void problemaDaRainhaRecursivo(int linhaAtual, int n, Integer[][] tabuleiro) {
        if (linhaAtual == n) {
            Integer[][] copiaTabuleiro = new Integer[n][n];
            for (int i = 0; i < n; i++) {
                System.arraycopy(tabuleiro[i], 0, copiaTabuleiro[i], 0, n);
            }
            solucoes.add(copiaTabuleiro);
            return;
        }
    
        for (int i = 0; i < n; i++) {
            if (verificarPosicionamentoRainha.podeColocar(linhaAtual, i, tabuleiro, n)) {
                tabuleiro[linhaAtual][i] = 1;
                problemaDaRainhaRecursivo(linhaAtual + 1, n, tabuleiro);
                tabuleiro[linhaAtual][i] = 0;
            }
        }
    }

    public static void problemaDaRainha(Integer n) {
        Integer[][] tabuleiro = new Integer[n][n];
        for (Integer i = 0; i < n; i++) {
            for (Integer j = 0; j < n; j++) {
                tabuleiro[i][j]=0;
            }
        }
        problemaDaRainhaRecursivo(0, n, tabuleiro);
        for (Integer[][] solucao : solucoes) {
            for (Integer i = 0; i < n; i++) {
                for (Integer j = 0; j < n; j++) {
                    System.out.print(solucao[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        int n=7;
        problemaDaRainha(n);
    }
}
