/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int occupiedRooms = 0, maxRooms = 0, len = intervals.size();
        int[] starts = new int[len];
        int[] ends = new int[len];
        for(int i = 0; i < len; i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0, j = 0;
        while(i < len || j < len){
            if(j == len || (i < len && starts[i] < ends[j])) {
                occupiedRooms++;
                i++;
            } else {
                occupiedRooms--;
                j++;
            }
            maxRooms = Math.max(maxRooms, occupiedRooms);
        }
        return maxRooms;
    }
}
