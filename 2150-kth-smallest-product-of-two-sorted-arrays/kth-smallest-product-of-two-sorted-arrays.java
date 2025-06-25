class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L;
        long right = 10000000000L;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLE(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private long countLE(int[] nums1, int[] nums2, long x) {
        long count = 0;
        for (int a : nums1) {
            if (a == 0) {
                if (x >= 0) count += nums2.length;
            } else if (a > 0) {
                // Positive a: find largest j where a * nums2[j] <= x
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * nums2[m] <= x) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                count += l;
            } else {
                // Negative a: find smallest j where a * nums2[j] <= x
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * nums2[m] <= x) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                count += nums2.length - l;
            }
        }
        return count;
    }
}