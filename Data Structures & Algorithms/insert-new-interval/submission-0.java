class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        boolean added = false;
        for(int []cur : intervals){
            if(added || cur[1] < newInterval[0]) res.add(cur);
            else if (cur[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(cur);
                added = true;
            } else {
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            }
        }
        if(!added) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
