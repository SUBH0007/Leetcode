class Solution {
    private int[] count = new int[37];
    private static final int[][] POWERS = {
            {0, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000},
            {0, 100, 200, 300, 400, 500, 600, 700, 800, 900},
            {0, 10, 20, 30, 40, 50, 60, 70, 80, 90},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
    };

    public int countLargestGroup(int n) {
        dfs(n, 0, 0, 0);
        return maxCount(count);
    }

    private void dfs(int n, int number, int i, int sum) {
        if (i == POWERS.length) {
            count[sum]++;
            return;
        }

        int[] powers = POWERS[i];
        for (int j = 0; j < powers.length; j++) {
            int newNumber = number + powers[j];
            if (newNumber <= n) {
                dfs(n, newNumber, i + 1, sum + j);
            }
        }
    }

    private static int maxCount(int[] count) {
        int result = 0;
        int max = 0;
        for (int i = 1; i < count.length; i++) {
            int c = count[i];
            if (c > max) {
                max = c;
                result = 1;
            } else if (c == max) {
                result++;
            }
        }
        return result;
    }
}