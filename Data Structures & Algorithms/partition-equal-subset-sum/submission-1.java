class Solution {
    private boolean f(int[] nums, int i, int target){
        if(target == 0) return true;
        if(i == nums.length) return false;
        return f(nums, i + 1, target) || f(nums, i + 1, target - nums[i]);
    }
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if(total % 2 == 1) return false;

        boolean [][]dp = new boolean[nums.length + 1][total / 2 + 1];
        for(boolean[] row : dp) row[0] = true;

        for(int i = nums.length - 1; i >= 0; i--){
            for(int target = 1; target <= total/2; target++){
                dp[i][target] = dp[i + 1][target] || (target >= nums[i] ? dp[i + 1][target - nums[i]] : false);
            }
        }
        return dp[0][total/2];                
    }
}
