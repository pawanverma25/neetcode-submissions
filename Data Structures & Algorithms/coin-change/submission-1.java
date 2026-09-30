class Solution {    
    private final int MAXI = (int) 1e9;
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int j = 1; j <= amount; j++) {
            dp[coins.length][j] = MAXI;
        }

        for(int i = coins.length - 1; i >= 0; i--){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = dp[i + 1][j];
                if(j >= coins[i]) dp[i][j] = Math.min(1 + dp[i][j - coins[i]], dp[i+1][j]);
            }
        }
        

        int ans = dp[0][amount];
        return ans >= MAXI ? -1 : ans;
    }
}
