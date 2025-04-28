class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int start = 0;
        long total = 0, count = 0;

        for (int end = 0; end < n; end++) {
            total += nums[end];

            while (total * (end - start + 1) >= k) {
                total -= nums[start];
                start++;
            }

            count += end - start + 1;
        }

        return count;
    }
}