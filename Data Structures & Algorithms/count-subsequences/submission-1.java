class Solution {
    private int f(String s, String t, int i, int j){
        if(i == s.length()) return j == t.length() ? 1 : 0;
        if(j == t.length()) return 1;

        int ans = f(s, t, i + 1, j);
        if(s.charAt(i) == t.charAt(j)) ans += f(s, t, i + 1, j + 1);

        return ans;
    }
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int []prev = new int[m + 1];
        prev[m] = 1;

        for(int i = n - 1; i >= 0; i--){
            int []cur = new int[m + 1];
            cur[m] = 1;
            for(int j = m - 1; j >= 0; j--){
                cur[j] = prev[j];
                if(s.charAt(i) == t.charAt(j)) cur[j] += prev[j + 1];
            }
            prev = cur;
        }

        return prev[0];
    }
}
