class Solution {
    public int countHillValley(int[] nums) {
        int hillAndValleys = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && nums[left] == nums[i]) {
                left--;
            }
            if (left < 0)
                continue;

            while (right < n && nums[right] == nums[i]) {
                right++;
            }
            if (right >= n)
                continue;

            if (n > 0 && nums[i] != nums[i - 1] && ((nums[left] < nums[i] && nums[right] < nums[i])
                    || (nums[left] > nums[i] && nums[right] > nums[i])))
                hillAndValleys++;
        }

        return hillAndValleys;

    }
}