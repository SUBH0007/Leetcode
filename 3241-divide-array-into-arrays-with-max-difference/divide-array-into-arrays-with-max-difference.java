class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList <int []> li=new ArrayList<>();
        int i=0;
        int j=0;
        ArrayList <Integer> l=new ArrayList<>();
        int [] res;
        while(i<nums.length/3)
          {  
            while(l.size()<3)
             {   l.add(nums[j]);
                j++;
             }
            if(!l.isEmpty() && (l.get(2)-l.get(0)<=k))
            {   res=new int[3];
                for(int m=0;m<3;m++)
                {
                    res[m]=l.get(m);
                }
                li.add(res);
                l.clear();
                
            }   
            else
             {   return new int[0][0];
             }
            i++;
             }
    
        int[][] d=new int[li.size()][3];
        for(int idx=0;idx<li.size();idx++)
        {
            d[idx]=li.get(idx);
        }
        return d;

    }
}