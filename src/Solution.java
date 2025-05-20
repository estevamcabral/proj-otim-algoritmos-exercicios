import java.util.HashMap;

class Solution {
    private int cont = 0;
    private HashMap<Integer, Integer> memo = new HashMap<>();

    private void generateSolutions(int i, int n) {
        if (memo.containsKey(i)) {
            cont+=memo.get(i);
            return;
        }
        if (i>n) {
            return;
        }
        if (i==n) {
            cont++;
            return;
        }
        generateSolutions(i+1, n);
        generateSolutions(i+2, n);
        memo.put(i, cont);
    }

    public int climbStairs(int n) {
        generateSolutions(0, n);
        return cont;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.climbStairs(5);
    }
}