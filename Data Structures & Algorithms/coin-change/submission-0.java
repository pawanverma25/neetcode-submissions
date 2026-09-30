class Solution {
    private final int MAXI = (int) 1e9;

    private int f(int []coins, int i, int amount, int[][] dp){
        if(amount == 0) return 0;
        if(i == coins.length || amount < 0) return MAXI;

        if(dp[i][amount] != -1) return dp[i][amount];

        return dp[i][amount] = Math.min(1 + f(coins, i, amount - coins[i], dp), f(coins, i + 1, amount, dp));
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int[] row : dp) Arrays.fill(row, -1);

        int ans = f(coins, 0, amount, dp);
        return ans >= MAXI ? -1 : ans;
    }
}
