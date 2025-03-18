class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=0;
        int[] ans=new int[2];
      int n = nums.length;
        for (i = 0; i < n-1 ; i++)
        {
            for (j = i + 1; j < n; j++) 
            {
                if (nums[i] + nums[j] == target) 
                {
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
