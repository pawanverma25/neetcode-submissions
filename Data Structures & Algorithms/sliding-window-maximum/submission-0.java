class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(!dq.isEmpty() && dq.peekFirst() == i - k) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i >= k - 1) res.add(nums[dq.peekFirst()]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
