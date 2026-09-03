class Solution {
    public int trap(int[] height) {
        int l = 0, lMax = height[0];
        int r = height.length - 1, rMax = height[height.length - 1];
        int res = 0;
        while(l < r){
            if(lMax <= rMax){
                res += lMax - height[l];
                l++;
                lMax = Math.max(height[l], lMax);
            } else {
                res += rMax - height[r];
                r--;
                rMax = Math.max(height[r], rMax);
            }
        }
        return res;
    }
}
