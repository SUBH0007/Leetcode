class Solution {
    public long numberOfPowerfulInt(long lowerBound, long upperBound, int digitLimit, String suffixStr) {
        long suffixVal = 0L;
        for (char ch : suffixStr.toCharArray())
            suffixVal = suffixVal * 10 + ch - '0';

        if (suffixVal > upperBound)
            return 0;

        long divisor = (long) Math.pow(10, suffixStr.length());
        long rangeStart = lowerBound / divisor;
        long rangeEnd = upperBound / divisor;

        if (upperBound % divisor >= suffixVal)
            rangeEnd++;
        if (lowerBound % divisor > suffixVal)
            rangeStart++;

        return getAvailNum(rangeEnd, digitLimit) - getAvailNum(rangeStart, digitLimit);
    }

    private long getAvailNum(long currentNum, long maxDigit) {
        if (currentNum == 0)
            return 0;
        if (maxDigit == 9)
            return currentNum;

        int numDigits = (int) Math.log10(currentNum);
        long factor = (long) Math.pow(10, numDigits);
        long result = 0L;

        for (int i = numDigits; i >= 0; i--) {
            int leadingDigit = (int) (currentNum / factor);
            if (leadingDigit > maxDigit)
                return result + (long) Math.pow(maxDigit + 1, i + 1);
            else
                result += leadingDigit * (long) Math.pow(maxDigit + 1, i);

            currentNum %= factor;
            factor /= 10;
        }

        return result;
    }
}