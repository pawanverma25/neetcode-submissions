class Solution {    
    private final int MAXI = (int) 1e9;
    public int coinChange(int[] coins, int amount) {
        int[] prev = new int[amount + 1];
        Arrays.fill(prev, MAXI);
        prev[0] = 0;

        for(int i = coins.length - 1; i >= 0; i--){
            int []cur = new int[amount + 1];
            for(int j = 0; j <= amount; j++){
                cur[j] = prev[j];
                if(j >= coins[i]) cur[j] = Math.min(1 + cur[j - coins[i]], cur[j]);
            }
            prev = cur;
        }
        

        int ans = prev[amount];
        return ans >= MAXI ? -1 : ans;
    }
}
