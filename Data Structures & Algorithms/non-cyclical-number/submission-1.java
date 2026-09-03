class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = sumOfSquares(n);
        while(slow != fast){
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        return fast == 1;
    }

    private int sumOfSquares(int n){
        int sum = 0;
        while(n > 0){
            sum += (n%10) * (n%10);
            n /= 10;
        }
        return sum;
    }
}
