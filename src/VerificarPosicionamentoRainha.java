public class VerificarPosicionamentoRainha {
    private boolean checkLinha(int x, Integer[][] tabuleiro, int n){
        for (int i = 0; i < n; i++) {
            if (tabuleiro[x][i]==1) return false;
        }
        return true;
    }

    private boolean checkColuna(int y, Integer[][] tabuleiro, int n){
        for (int i=0; i < n; i++){
            if (tabuleiro[i][y]==1) return false;
        }

        return true;
    }

    private boolean checkDiagonal(int linha, int coluna, Integer[][] tabuleiro, int n) {
        for (int i = linha, j = coluna; i >= 0 && j >= 0; i--, j--) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }
    
        for (int i = linha, j = coluna; i >= 0 && j < n; i--, j++) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }
    
        return true; 
    }

    public boolean podeColocar(int x, int y, Integer[][] tabuleiro, int n){
        return checkLinha(x, tabuleiro, n) && checkColuna(y, tabuleiro, n) && checkDiagonal(x, y, tabuleiro, n);
    }
}
