class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0, maxf = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0; j < s.length(); j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(j)));

            while((j - i + 1) - maxf > k) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}