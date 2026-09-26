class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0, prev2 = 0;
        for(int i = cost.length - 1; i >= 0; i--){
            int temp = cost[i] + Math.min(prev, prev2);
            prev2 = prev;
            prev = temp;
        }
        return Math.min(prev, prev2);
    }
}
