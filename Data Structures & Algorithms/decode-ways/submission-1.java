class Solution {
    public int f(String s, int i, int []dp){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];

        int ans = f(s, i + 1, dp);
        if(i < s.length() - 1){
            int cur = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if(cur <= 26) ans += f(s, i + 2, dp);
        }
        return dp[i] = ans;
    }
    
    public int numDecodings(String s) {
        int []dp = new int[s.length() + 1];
        dp[s.length()] = 1;

        for(int i = s.length() - 1; i >= 0; i--){
            int ans = dp[i + 1];
            if(s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if(i < s.length() - 1){
                int cur = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                if(cur <= 26) ans += dp[i + 2];
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}
