class Solution {
    int solve(List<Integer>arr,int num,int x){
        int n=arr.size(),ans=0;
        for(int i=0;i<n;i++){
            int z=Math.abs(num-arr.get(i));
            if(z%x!=0){
                return 1000000000;
            }
            ans+=(z/x);

        }
        return ans;
    }
    public int minOperations(int[][] g, int x) {
        List<Integer>arr=new ArrayList<>();
        int n=g.length,m=g[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr.add(g[i][j]);
            }
        }
        arr.sort(null);
        n*=m;
        int ans=solve(arr,arr.get(n/2),x);
        if(n%2==0){
             ans=Math.min(solve(arr,arr.get(n/2-1),x),ans);
            
        }
        if(ans==1000000000)
        ans=-1;
        return ans;
    }
}