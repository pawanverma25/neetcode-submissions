class Solution {
    public int numDecodings(String s) {
        int prev = 1, prevprev = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            int ans = prev;
            if(s.charAt(i) == '0') {
                prevprev = prev;
                prev = 0;
                continue;
            }
            if(i < s.length() - 1){
                int cur = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                if(cur <= 26) ans += prevprev;
            }
            prevprev = prev;
            prev = ans;
        }
        return prev;
    }
}
