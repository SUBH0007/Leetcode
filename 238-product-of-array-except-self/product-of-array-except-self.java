class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int n = nums.length;
        // int pre[] = new int[n];
        // pre[0] = 1;
        // int s = 1;
        // for(int i = 1; i < n; i++) {
        //     pre[i] = pre[i - 1] * nums[i - 1];
        // }
        // for(int i = n - 1; i >= 0; i--) {
        //     pre[i] *= s;
        //     s*=nums[i];
        // }
        // return pre;
         int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}