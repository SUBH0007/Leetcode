class Solution {
    public void rotate(int[] nums, int k) {
       int n=nums.length;
       k = k % n;
       int[] newar=new int[n];
       int j=0;
       for(int i=n-k;i<n;i++)
       {
        newar[j]=nums[i];
        j++;
       }
       for(int i=0;i<n-k;i++)
       {
        newar[j]=nums[i];
        j++;
       }
       for (int i = 0; i < n; i++) {
            nums[i] = newar[i];
        }
    }
}