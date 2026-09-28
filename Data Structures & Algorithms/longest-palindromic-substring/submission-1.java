class Solution {
    private String expandPalindrome(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        String res = s.substring(0,1);
        for(int i = 1; i < s.length(); i++){
            String cur = expandPalindrome(s, i, i);
            if(cur.length() > res.length()) res = cur;
            cur = expandPalindrome(s, i - 1, i);
            if(cur.length() > res.length()) res = cur;
        }
        return res;
    }
}
