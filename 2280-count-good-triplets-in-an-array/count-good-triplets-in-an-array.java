class Solution {
    long []segmentTree;
    private void updateSegmentTree(int segmentIndex, int start, int end, int queryIndex) {
        if(start > queryIndex || end < queryIndex) return; // No overlap
        if(start == end) { segmentTree[segmentIndex] += 1L; return; } // Full overlap

        // Partial overlap
        int mid = start + (end - start) / 2;
        updateSegmentTree(2 * segmentIndex + 1, start, mid, queryIndex);
        updateSegmentTree(2 * segmentIndex + 2, mid + 1, end, queryIndex);
        segmentTree[segmentIndex] = segmentTree[2 * segmentIndex + 1] + segmentTree[2 * segmentIndex + 2];
    }

    private long rangeCountQuery(int segmentIndex, int queryLeft, int queryRight, int start, int end) {
        // No overlap.
        if(queryRight < start || queryLeft > end) return 0; 

        // Full overlap
        if(queryLeft <= start && queryRight >= end) return segmentTree[segmentIndex];

        // Partial overlap
        int mid = start + (end - start)/2;
        long left = rangeCountQuery(2 * segmentIndex + 1, queryLeft, queryRight, start, mid);
        long right = rangeCountQuery(2 * segmentIndex + 2, queryLeft, queryRight, mid + 1, end);
        return left + right;
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int []nums2Index = new int[n];
        segmentTree = new long[5 * (n + 1) + 1];
        for(int i = 0; i < n; i++) { nums2Index[nums2[i]] = i; }
        updateSegmentTree(1, 0, n - 1, nums2Index[nums1[0]]);

        long countGoodTriplets = 0;

        for(int i = 1; i < n; i++) {
            int queryIndex = nums2Index[nums1[i]];
            long commonLeft = rangeCountQuery(1, 0, queryIndex, 0, n - 1);
            long uncommonLeft = (i - commonLeft) * 1L;
            long commonRight = (n - 1 - queryIndex) * 1L - uncommonLeft;
            countGoodTriplets += (commonLeft * commonRight);
            updateSegmentTree(1, 0, n - 1, queryIndex);
        }
        return countGoodTriplets;
    }
}