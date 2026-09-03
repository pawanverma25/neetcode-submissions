class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1, res = 0;
        while(l < r){
            res = Math.max(res, (r - l) * Math.min(heights[l], heights[r]));
            if(heights[l] < heights[r]) l++;
            else r--;
        }
        return res;
    }
}
