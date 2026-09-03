class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] > 0) break;
            int l = i + 1, r = len - 1;
            while(l < r){
                int target = -(nums[l] + nums[r]);
                if(target < nums[i]) r--;
                else if(target > nums[i]) l++;
                else {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l - 1]) l++;
                }
            }
        }
        return res;
    }
}
