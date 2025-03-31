class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1 || k == n) return 0;

        List<Integer> pairs = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            pairs.add(weights[i] + weights[i + 1]);
        }

        Collections.sort(pairs);
        
        long minSum = 0, maxSum = 0;
        for (int i = 0; i < k - 1; i++) {
            minSum += pairs.get(i);
            maxSum += pairs.get(n - 2 - i);
        }

        return maxSum - minSum;
    }
}