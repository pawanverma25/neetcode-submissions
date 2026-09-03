class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            int sum = 0, cur = n;
            while(cur > 0){
                sum += (cur%10) * (cur%10);
                cur /= 10;
            }
            if(set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
        return true;
    }
}
