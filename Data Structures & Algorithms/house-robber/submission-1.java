class Solution {
    public int rob(int[] nums) {
        int prev = 0, prevprev = 0;
        for(int i = nums.length -1; i >= 0; i--){
            int cur = Math.max(prev, nums[i] + prevprev);
            prevprev = prev;
            prev = cur;
        }
        return prev;
    }
}
