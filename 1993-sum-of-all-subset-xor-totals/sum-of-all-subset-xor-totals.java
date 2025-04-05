class Solution {
    public int subsetXORSum(int[] nums) {
         int x = nums[0];
        
        if(nums.length < 2) return x;
        
        for(int i=1; i<nums.length; i++) {
            x |= nums[i];  // Bitwise OR operation
        }
        
        return x * (int)Math.pow(2, nums.length-1);
    }
}