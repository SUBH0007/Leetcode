class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
         int n = nums.length;
        int[] diff = new int[n + 1]; // difference array for range updates

        // Apply each query as a range update
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff[l] += 1;
            if (r + 1 < n) {
                diff[r + 1] -= 1;
            }
        }

        // Compute prefix sum and validate each element
        int affect = 0;
        for (int i = 0; i < n; i++) {
            affect += diff[i]; // total times index i is affected
            if (nums[i] > affect) {
                return false; // nums[i] must be decremented exactly nums[i] times
            }
        }

        return true;
    }
}