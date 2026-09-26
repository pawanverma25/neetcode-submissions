class Solution {
    public int climbStairs(int n) {
        int prev = 1, prevprev = -1;
        for(int i = 1; i <= n; i++){
            int cur = prev + (i > 1 ? prevprev : 0);
            prevprev = prev;
            prev = cur;
        }
        return prev;
    }
}
