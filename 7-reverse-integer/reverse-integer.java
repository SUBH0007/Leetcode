class Solution {
    public int reverse(int x) {
         int num = Math.abs(x), reversed = 0;
        while (num != 0) {
            int remainder = num % 10;
            if (reversed > (Integer.MAX_VALUE - remainder) / 10) return 0;
            reversed = reversed * 10 + remainder;
            num = num / 10;
        }
        return (x < 0) ? (-reversed) : reversed;
    }
}