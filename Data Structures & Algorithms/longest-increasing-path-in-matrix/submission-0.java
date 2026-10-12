class Solution {
    private int f(int [][]mat, int i, int j, int [][]dp){

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        if(i < mat.length - 1 && mat[i + 1][j] > mat[i][j])
            ans = Math.max(ans, 1 + f(mat, i + 1, j, dp));
        if(i > 0 && mat[i - 1][j] > mat[i][j])
            ans = Math.max(ans, 1 + f(mat, i - 1, j, dp));
        if(j < mat[0].length - 1 && mat[i][j + 1] > mat[i][j])
            ans = Math.max(ans, 1 + f(mat, i, j + 1, dp));
        if(j > 0 && mat[i][j - 1] > mat[i][j])
            ans = Math.max(ans, 1 + f(mat, i, j - 1, dp));

        return dp[i][j] = ans;
    }
    public int longestIncreasingPath(int[][] mat) {
        if(mat.length == 0) return 0;

        int ans = 0, n = mat.length, m = mat[0].length;
        int [][]dp = new int[n + 1][m + 1];
        for(int []row : dp) Arrays.fill(row, -1);

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                ans = Math.max(ans, 1 + f(mat, i, j, dp));
            }
        }
        return ans;
    }
}
