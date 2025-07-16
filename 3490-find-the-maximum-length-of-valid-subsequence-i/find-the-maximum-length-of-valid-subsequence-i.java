class Solution {
    public int maximumLength(int[] nums) {
       int evencount=0,oddcount=0,evenstart=0,oddstart=0,i;
       for(i=0;i<nums.length;i++)
       {
            if(nums[i]%2==0)
                evencount++;
            else
                oddcount++; 
       }
       int ev=1,od=0;
       for(i=0;i<nums.length;i++)
       {
            if(nums[i]%2==0&&ev==1)
            {
                evenstart++;
                od=1;
                ev=0;
            }
            if(nums[i]%2!=0&&od==1)
            {
                evenstart++;
                ev=1;
                od=0;
            }
       }
       ev=0;
       od=1;
       for(i=0;i<nums.length;i++)
       {
            if(nums[i]%2==0&&ev==1)
            {
                oddstart++;
                od=1;
                ev=0;
            }
            if(nums[i]%2!=0&&od==1)
            {
                oddstart++;
                ev=1;
                od=0;
            }
       }
       int m1=Math.max(evencount,oddcount);
       int m2=Math.max(oddstart,evenstart);
       return Math.max(m1,m2);
    }
}