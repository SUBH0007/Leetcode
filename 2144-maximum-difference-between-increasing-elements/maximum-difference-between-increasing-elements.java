class Solution {
    public int maximumDifference(int[] nums) {
        int maxdiff=-1;
        for(int i=0;i<nums.length-1;i++){
           for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    maxdiff=Math.max(maxdiff,nums[j]-nums[i]);
                }
           }
        }
        return maxdiff;
    }
}