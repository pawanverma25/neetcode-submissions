class Solution {
    private final int MAXI = (int) 1e9;
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount + 1];
        prev[0] = 1;

        for(int i = coins.length - 1; i >= 0; i--){
            int []cur = new int[amount + 1];
            for(int j = 0; j <= amount; j++){
                cur[j] = prev[j];
                if(j >= coins[i]) cur[j] += cur[j - coins[i]];
            }
            prev = cur;
        }
        

        return prev[amount];
    }
}
