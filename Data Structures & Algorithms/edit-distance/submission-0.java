class Solution {
    public static final int MAXI = (int) 1e9;
    private int f(String s, String t, int i, int j){
        if(i == s.length() || j == t.length()) return Math.max(t.length() - j, s.length() - i);
        
        int ans = MAXI;
        ans = Math.min(ans, 1 + f(s, t, i + 1, j));
        ans = Math.min(ans, 1 + f(s, t, i, j + 1));
        if(s.charAt(i) == t.charAt(j)) ans = Math.min(ans, f(s, t, i + 1, j + 1));
        else ans = Math.min(ans, 1 + f(s, t, i + 1, j + 1));
        return ans;

    }
    public int minDistance(String s, String t) {
        int n = s.length(), m = t.length();
        int [][]dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) dp[i][m] = n - i;
        for(int i = 0; i < m; i++) dp[n][i] = m - i;

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                dp[i][j] = MAXI;
                dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 1][j]);
                dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j + 1]);
                if(s.charAt(i) == t.charAt(j)) dp[i][j] = Math.min(dp[i][j], dp[i + 1][j + 1]);
                else dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
