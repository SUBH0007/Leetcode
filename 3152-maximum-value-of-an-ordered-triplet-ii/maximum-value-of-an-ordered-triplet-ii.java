class Solution {
    public long maximumTripletValue(int[] nums) {
         int maximum = 0 ; 


long maxdiff = 0 ;
long ans = 0 ; 

long maxnums = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){



ans  = Math.max(ans,maxdiff*nums[i]);

maxdiff = Math.max(maxdiff,maxnums-nums[i]);

maxnums = Math.max(maxnums,nums[i]);
        }
        return ans;
    }
}