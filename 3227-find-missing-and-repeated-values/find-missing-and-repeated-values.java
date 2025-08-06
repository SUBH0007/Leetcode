class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int rep = 0, miss = 0;

        // 1. Count frequency of all numbers in the grid
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                freq.put(grid[i][j], freq.getOrDefault(grid[i][j], 0) + 1);
            }
        }
        // 2. Find the repeated and missing numbers
        for (int i = 1; i <= n * n; ++i) {
            if (!freq.containsKey(i)) {
                miss = i; // missing value
            } else if (freq.get(i) == 2) {
                rep = i; // repeated value
            }
        }
        return new int[]{rep, miss};
    }
}
