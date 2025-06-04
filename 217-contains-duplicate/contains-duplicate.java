class Solution {
    public boolean containsDuplicate(int[] nums) 
    {
       Arrays.sort(nums);
       for(int a=1;a<nums.length;a++)
       {
            
                if(nums[a]==nums[a-1])
                {
                    return true;
                }
            
       }
       return false;
    }
}