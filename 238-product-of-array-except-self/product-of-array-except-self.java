class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        pre[0] = 1;
        int s = 1;
        
        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 1; i >= 0; i--) {
            pre[i] = pre[i] * s;
            s=s*nums[i];
        }
        
        // int ans[] = new int[n];
        // for(int i = 0; i < n; i++) {
        //     ans[i] = pre[i] * suff[i];
        // }
        return pre;
    }
}