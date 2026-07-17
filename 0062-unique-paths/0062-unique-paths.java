class Solution {
    public int uniquePaths(int m, int n) {
        int totalMoves = m + n - 2;
        int k = Math.min(m - 1, n - 1);
        long res = 1;
        
        for (int i = 1; i <= k; i++) {
            res = res * (totalMoves - k + i) / i;
        }
        
        return (int) res;
    }
}
