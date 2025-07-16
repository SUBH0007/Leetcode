import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        // The deque stores indices of elements in the current window.
        // The elements corresponding to these indices are in decreasing order.
        Deque<Integer> windowIndices = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove indices from the front that are out of the current window.
            if (!windowIndices.isEmpty() && windowIndices.peekFirst() == i - k) {
                windowIndices.pollFirst();
            }

            // 2. Remove indices from the back that correspond to elements smaller than the current element.
            // This maintains the decreasing order property.
            while (!windowIndices.isEmpty() && nums[windowIndices.peekLast()] < nums[i]) {
                windowIndices.pollLast();
            }

            // 3. Add the current index to the back of the deque.
            windowIndices.offerLast(i);

            // 4. Once the window is full (i.e., we've processed at least k elements),
            // the index at the front of the deque corresponds to the maximum element in the window.
            if (i >= k - 1) {
                result[resultIndex++] = nums[windowIndices.peekFirst()];
            }
        }

        return result;
    }
}