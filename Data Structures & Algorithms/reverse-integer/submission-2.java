class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        long rev = 0;
        x = Math.abs(x);
        while(x > 0){
            rev = rev * 10 + x%10;
            x /= 10;
            if(rev > Integer.MAX_VALUE) return 0;
        }
        return sign * (int)rev;
    }
}
