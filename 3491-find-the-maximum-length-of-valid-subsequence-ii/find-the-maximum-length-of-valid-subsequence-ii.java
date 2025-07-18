class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp= new int[k][k];
        int res=0;
        for(int num:nums){
            int a = num%k;
            for(int b=0;b<k;b++){
                dp[a][b]=dp[b][a]+1;
                res=Math.max(res,dp[a][b]);
            }
        }
        return res;
    }
}