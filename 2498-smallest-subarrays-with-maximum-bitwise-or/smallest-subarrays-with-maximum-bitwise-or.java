class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] next = new int[32];           // next index where bit b appears
        Arrays.fill(next, n);               // default: beyond end
        int suffixOR = 0;
        
        for (int i = n - 1; i >= 0; --i) {
            suffixOR |= nums[i];            // OR of nums[i..n-1]
            // update next positions for bits set in nums[i]
            for (int b = 0; b < 32; ++b) {
                if (((nums[i] >> b) & 1) == 1) {
                    next[b] = i;
                }
            }
            int minLen = 1;
            // for each bit set in suffixOR, include farthest occurrence
            for (int b = 0; b < 32; ++b) {
                if (((suffixOR >> b) & 1) == 1) {
                    minLen = Math.max(minLen, next[b] - i + 1);
                }
            }
            ans[i] = minLen;
        }
        
        return ans;
    }
}