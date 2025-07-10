class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int lastEnd = 0;
        int n = startTime.length;
        int maxLeft = 0;
        int res = 0;

        // Step 1: Calculate all free time gaps
        int[] gaps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            gaps[i] = startTime[i] - lastEnd;
            lastEnd = endTime[i];
        }
        gaps[n] = eventTime - lastEnd;

        // Step 2: Build suffix max array for right gaps
        int[] maxRight = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], gaps[i + 1]);
        }

        // Step 3: Evaluate each meeting's rescheduling potential
        for (int i = 1; i <= n; i++) {
            int meetingDur = endTime[i - 1] - startTime[i - 1];

            // Check if meeting can be rescheduled to merge with left or right gap
            if (maxLeft >= meetingDur || maxRight[i] >= meetingDur) {
                res = Math.max(res, gaps[i - 1] + meetingDur + gaps[i]);
            }

            // Also consider just merging adjacent gaps without rescheduling
            res = Math.max(res, gaps[i - 1] + gaps[i]);
            
            // Update maximum left gap encountered so far
            maxLeft = Math.max(maxLeft, gaps[i - 1]);
        }

        return res;
    }
}