class Solution {
    public int maxAdjacentDistance(int[] nums) {
      int n = nums.length;
        int maxAbsDifference = 0;
        //iterating over the nums.
        for(int i = 0; i < n; i++){
            //how can we make sure that the index circles back for last one.
            int absDifference = Math.abs(nums[i] - nums[(i + 1) % n]);
            //is the new difference greater than the old one.
            maxAbsDifference = Math.max(maxAbsDifference, absDifference);
        }
        return maxAbsDifference;
    }
}