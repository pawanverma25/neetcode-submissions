class Solution {
    private int f(String s, int i, int j, int [][]dp){
        if(i < 0 || j >= s.length() || s.charAt(i) != s.charAt(j)) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = 1 + f(s, i - 1, j + 1, dp);
    }
    public int countSubstrings(String s) {
        int [][]dp = new int[s.length() + 1][s.length() + 1];
        for(int []row : dp) Arrays.fill(row, -1);
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            ans += f(s, i, i, dp) + f(s, i, i + 1, dp);
        }
        return ans;
    }
}
