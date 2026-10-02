class Solution {
    private int f(int[] nums, int cur, int prev){
        if(cur == nums.length) return 0;
        
        int ans = f(nums, cur + 1, prev);
        if(prev == -1 || nums[cur] > nums[prev]) 
            ans = Math.max(ans, 1 + f(nums, cur + 1, cur));
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 0;
        int[][] dp = new int[n + 1][n + 1];
        
        for(int prev = n - 1; prev >= 0; prev--){
            for(int cur = n - 1; cur > prev; cur--){
                dp[cur][prev] = dp[cur + 1][prev];
                if(nums[cur] > nums[prev]){
                    dp[cur][prev] = Math.max(dp[cur][prev], 1 + dp[cur + 1][cur]);
                }
            }
            ans = Math.max(ans, 1 + dp[prev + 1][prev]);
        }

        return ans;
    }
}
