class Solution {
    public double myPow(double x, long n) {
        if(n == 1) return x;
        if(n == 0) return 1.0;

        if(n < 0) return myPow(1.0/x, Math.abs(n));

        if(n%2 == 1) return x * myPow(x, n - 1);
        return myPow(x*x, n/2);
    }

}
