class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if(total % 2 == 1) return false;

        boolean []prev = new boolean[total / 2 + 1];
        prev[0] = true;

        for(int i = nums.length - 1; i >= 0; i--){
            boolean []cur = new boolean[total / 2 + 1];
            for(int target = 1; target <= total/2; target++){
                cur[target] = prev[target] || (target >= nums[i] ? prev[target - nums[i]] : false);
            }
            prev = cur;
        }
        return prev[total/2];                
    }
}
