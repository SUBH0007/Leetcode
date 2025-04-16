class Solution {
    public long countGood(int[] nums, int k) {
          Map<Integer, Integer> mp = new HashMap<>();
        int l = 0, pairs = 0, len = nums.length;
        long res = 0;

        for (int r = 0; r < len; r++) {
            int count = mp.getOrDefault(nums[r], 0);
            pairs += count;
            mp.put(nums[r], count + 1);

            if (pairs >= k) {
                res += len - r;

                while (l < r && pairs >= k) {
                    int leftCount = mp.get(nums[l]);
                    pairs -= leftCount - 1;
                    if (leftCount == 1) 
                     mp.remove(nums[l++]);
                     else 
                     mp.put(nums[l++], leftCount - 1);
                    if (pairs >= k) res += len - r;
                }
            }
        }

        return res;
    }
}