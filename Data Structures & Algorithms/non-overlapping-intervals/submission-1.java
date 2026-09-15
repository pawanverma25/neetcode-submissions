class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        
        int n = intervals.length, end = intervals[0][1], res = 0;
        for(int i = 1; i < n; i++){
            int[] cur = intervals[i];
            if(cur[0] < end){
                res++;
                end = Math.min(cur[1], end);
            }
            else {
                end = cur[1];
            }
        }
        return res;
    }
}
