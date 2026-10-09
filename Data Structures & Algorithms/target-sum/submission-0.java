class Solution {
    private int f(int []nums, int i, int k, int[][] dp, int totalSum, int targetSum){
        if(i == nums.length) return k == targetSum ? 1 : 0;
        if(dp[i][k + totalSum] != Integer.MIN_VALUE) return dp[i][k + totalSum];

        return dp[i][k + totalSum] = f(nums, i + 1, k + nums[i], dp, totalSum, targetSum) + f(nums, i + 1, k - nums[i], dp, totalSum, targetSum);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, totalSum = Arrays.stream(nums).sum();
        int [][]dp = new int[n][2 * totalSum + 1];
        for(int []row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        return f(nums, 0, 0, dp, totalSum, target);
    }
}
