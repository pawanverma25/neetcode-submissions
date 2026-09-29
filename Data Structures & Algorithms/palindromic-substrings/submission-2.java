class Solution {
    public int countSubstrings(String s) {
        int []prev = new int[s.length() + 1];
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            int[] cur = new int[s.length() + 1];
            for(int j = s.length() - 1; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)) {
                    cur[j] = 1 + prev[j + 1];
                } else {
                    cur[j] = 0;
                }
            }
            ans += cur[i] + cur[i + 1];
            prev = cur;
        }
        return ans;
    }
}
