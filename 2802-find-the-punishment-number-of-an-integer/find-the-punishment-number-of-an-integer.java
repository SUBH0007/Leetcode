class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (canPartition(String.valueOf(square), 0, i)) {
                sum += square;
            }
        }
        return sum;
    }

    private boolean canPartition(String s, int index, int target) {
        if (index == s.length()) {
            return target == 0;
        }

        for (int j = index + 1; j <= s.length(); j++) {
            int num = Integer.parseInt(s.substring(index, j));
            if (num > target) continue;
            if (canPartition(s, j, target - num)) return true;
        }

        return false;
    }
}