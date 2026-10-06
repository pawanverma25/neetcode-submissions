class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int []prev = new int[m + 1];
        for(int i = 1; i <= n; i++){
            int []cur = new int[m + 1];
            for(int j = 1; j <= m; j++){
                cur[j] = Math.max(prev[j], cur[j - 1]);
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    cur[j] = Math.max(cur[j], 1 + prev[j - 1]);
            }
            prev = cur;
        }
        return prev[m];
    }
}
