class Solution {
    private boolean f(String s, int i, Set<String> dict){
        if(i >= s.length()) return true;

        

        StringBuilder sb = new StringBuilder();
        for(int cur = i; cur < s.length(); cur++){
            sb.append(s.charAt(cur));
            if(dict.contains(sb.toString())){
                if(f(s, cur + 1, dict)) return true;
            }
        }

        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for(int i = s.length() - 1; i >= 0; i--){
            StringBuilder sb = new StringBuilder();
            for(int cur = i; cur < s.length(); cur++){
                sb.append(s.charAt(cur));
                if(dict.contains(sb.toString())){
                    if(dp[cur + 1]) {
                        dp[i] = true; 
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}
