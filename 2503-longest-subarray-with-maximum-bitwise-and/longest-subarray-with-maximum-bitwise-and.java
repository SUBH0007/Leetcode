class Solution {
    public int longestSubarray(int[] nums) {
        int maxEle = 0, maxLen = 0;
        int l = 0, r = 0;
        for (r = 0; r <= nums.length; r++) {
            if (r == nums.length || nums[r] != nums[l]) {
                if (maxEle <= nums[l]) {
                    if (maxEle == nums[l]) {
                        maxLen = Math.max(r - l, maxLen);
                    } else {
                        maxLen = r - l;
                    }
                    maxEle = nums[l];
                }
                l = r;
            }
        }

        return maxLen;
    }
}