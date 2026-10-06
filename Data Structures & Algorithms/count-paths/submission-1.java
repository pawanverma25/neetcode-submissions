class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        for(int i = 0; i < m; i++){
            int[] cur = new int[n];
            for(int j = 0; j < n; j++){
                if(i + j == 0) cur[j] = 1;
                else {
                    cur[j] += i > 0 ? prev[j] : 0;
                    cur[j] += j > 0 ? cur[j - 1] : 0;
                }
            }
            prev = cur;
        }
        return prev[n - 1];
    }
}
