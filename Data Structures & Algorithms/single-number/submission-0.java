class Solution {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).mapToObj(i -> Integer.valueOf(i)).reduce(0, (a, b) -> a^b);
    }
}
