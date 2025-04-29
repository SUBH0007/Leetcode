class Solution {
    public long countSubarrays(int[] nums, int k) {
         int n = nums.length;
        int freq = 0;
        int highest = 0;
        for (int val : nums) {
            highest = Math.max(highest, val);
        }
        long count  = 0;
        int j = 0;

        
        for (int i=0;i<n;i++){
            if (nums[i] == highest){
                freq += 1;
            }
            while (freq >= k){
                count += (long)n - i;
                if (nums[j] == highest){
                    freq -= 1;
                }
                j += 1;
            }
        }
        return count;
    }
}