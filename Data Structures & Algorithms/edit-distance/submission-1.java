class Solution {
    public static final int MAXI = (int) 1e9;
    public int minDistance(String s, String t) {
        int n = s.length(), m = t.length();
        int []prev = new int[m + 1];
        for(int i = 0; i < m; i++) prev[i] = m - i;

        for(int i = n - 1; i >= 0; i--){
            int []cur = new int[m + 1];
            for(int k = 0; k < m; k++) cur[k] = m - k;
            cur[m] = n - i;
            for(int j = m - 1; j >= 0; j--){
                cur[j] = MAXI;
                cur[j] = Math.min(cur[j], 1 + prev[j]);
                cur[j] = Math.min(cur[j], 1 + cur[j + 1]);
                if(s.charAt(i) == t.charAt(j)) cur[j] = Math.min(cur[j], prev[j + 1]);
                else cur[j] = Math.min(cur[j], 1 + prev[j + 1]);
            }
            prev = cur;
        }
        return prev[0];
    }
}
