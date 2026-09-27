class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int prev = 0, prevprev = 0;
        for(int i = end; i >= start; i--){
            int cur = Math.max(prev, nums[i] + prevprev);
            prevprev = prev;
            prev = cur;
        }
        return prev;
    }
}
