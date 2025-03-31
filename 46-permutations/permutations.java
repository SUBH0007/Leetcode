class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
     fun(nums,0,nums.length,ans);

     return ans;

        
    }

    public void fun(int[] arr, int i, int n,List<List<Integer>> ans)
    {
        List<Integer> ls = new ArrayList<>();
        if( i >= n )
        {
            for(int j:arr)ls.add(j);
            
            // System.out.println("" + ls);
            ans.add(ls);
            return;
        }

        for( int ii=i ; ii<n ; ii++ )
        {
            swap(ii,i,arr);
            fun(arr,i+1,n,ans);
            swap(ii,i,arr);
        }


    }

    public void swap(int a, int b, int[] arr)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}