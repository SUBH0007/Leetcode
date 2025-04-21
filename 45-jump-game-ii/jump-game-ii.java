class Solution {
    public int jump(int[] nums) {
         int lastIndex = 0;
        int jumps = 0;
        int maxReach = 0;
        if(nums.length==1){
            return 0;
        }
        for(int i = 0 ; i < nums.length ; i++){
            maxReach = Math.max(maxReach, i + nums[i]);
            if(i == lastIndex){
                jumps++;
                if(maxReach == i){
                    return -1;
                }
                lastIndex=maxReach;
                if(maxReach >= nums.length-1){
                    break;
                }
            }
        }
        return jumps;
    }
}