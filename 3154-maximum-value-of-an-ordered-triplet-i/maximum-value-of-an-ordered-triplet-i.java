class Solution {
    public long maximumTripletValue(int[] nums) {
         int n = nums.length, max = nums[0], min = nums[0];
        long diff = max - min, product = diff;
        for (int i = 1; i < n - 1; i++ ) {
            if (nums[i] < min) {
                min = nums[i];
                diff = Math.max(diff, max - min);
            } else {
                if (nums[i] > max) { 
                    max = nums[i];
                    min = nums[i];
                }
            }
            
            product = Math.max(diff * nums[i + 1], product);
           
        }
        return product;
    }
}