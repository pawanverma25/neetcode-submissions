class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i : nums){
            if(!s.add(i)) return true;
        }
        return false;
    }
}