class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length, r = len - 1, carry = 1;
        while(r >= 0 && carry > 0){
            int sum = digits[r] + carry;
            digits[r] = sum%10;
            carry = sum/10;
            r--;
        }
        if(carry == 0) return digits;
        int []res = new int[len + 1];
        res[0] = carry;
        for(int i = 0; i < len; i++){
            res[i + 1] = digits[i];
        }
        return res;
    }
}
