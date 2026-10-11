class Solution {
    public int f(String s, String t, String r, int i, int j, int k, int [][][]dp) {
        if(k == r.length()) return i == s.length() && j == t.length() ? 1 : 0;

        if(dp[i][j][k] != -1) return dp[i][j][k];

        if(i < s.length() && s.charAt(i) == r.charAt(k)) {
            if(f(s, t, r, i + 1, j, k + 1, dp) == 1) return dp[i][j][k] = 1;
        }    

        if(j < t.length() && t.charAt(j) == r.charAt(k)) {
            if(f(s, t, r, i, j + 1, k + 1, dp) == 1) return dp[i][j][k] = 1;
        }  

        return dp[i][j][k] = 0;  

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int [][][]dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        for(int [][]row : dp) for(int []val : row) Arrays.fill(val, -1);
        return f(s1, s2, s3, 0, 0, 0, dp) == 1;
    }
}
