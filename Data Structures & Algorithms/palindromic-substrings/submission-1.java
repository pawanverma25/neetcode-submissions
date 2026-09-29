class Solution {
    private int f(String s, int i, int j, int [][]dp){
        if(i < 0 || j >= s.length() || s.charAt(i) != s.charAt(j)) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = 1 + f(s, i - 1, j + 1, dp);
    }
    public int countSubstrings(String s) {
        int [][]dp = new int[s.length() + 1][s.length() + 1];
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length() - 1; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1 + (i > 0 ? dp[i - 1][j + 1] : 0);
                } else {
                    dp[i][j] = 0;
                }
            }
            ans += dp[i][i] + dp[i][i + 1];
        }
        // for(int i = 0; i < s.length(); i++){
        //     ans += dp[i][i] + dp[i][i + 1];
        // }
        return ans;
    }
}
