class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int[] cur : intervals){
            if(res.isEmpty()) res.add(cur);

            int[] prev = res.get(res.size() - 1);
            if(cur[0] <= prev[1]) prev[1]  = Math.max(prev[1], cur[1]);
            else res.add(cur);
        }
        return res.toArray(new int[res.size()][]);
    }
}
