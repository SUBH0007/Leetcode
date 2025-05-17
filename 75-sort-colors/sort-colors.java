class Solution {
    public void sortColors(int[] nums) {
         int[] counts = new int[3];
        for(int i=0;i<nums.length;i++){
            counts[nums[i]]++;
        }
        int color = 0;
        for(int i=0;i<nums.length;i++){
            while(counts[color] <= 0) color++;
            nums[i] = color;
            counts[color]--;
        }
    }
}