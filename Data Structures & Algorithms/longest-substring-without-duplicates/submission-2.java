class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while(i < j && map.get(s.charAt(j)) > 1){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
