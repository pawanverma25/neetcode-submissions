class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], pos = nums[0], neg = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0) {
                int temp = pos;
                pos = neg;
                neg = temp;
            }
            pos = Math.max(pos*nums[i], nums[i]);
            neg = Math.min(neg*nums[i], nums[i]);
            res = Math.max(res, pos);
        }
        return res;
    }
}
