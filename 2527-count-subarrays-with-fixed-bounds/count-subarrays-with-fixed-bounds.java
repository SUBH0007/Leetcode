class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
         long res = 0L;
        int lastMinPos = -1, lastMaxPos = -1, lastInvalid = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (v < minK | v > maxK) {
                lastInvalid = i;
            }
            if (v == minK) lastMinPos = i;
            if (v == maxK) lastMaxPos = i;
            int bound = lastMinPos < lastMaxPos ? lastMinPos : lastMaxPos;
            if (bound > lastInvalid) res += bound - lastInvalid;
        }
        return res;
    }
}