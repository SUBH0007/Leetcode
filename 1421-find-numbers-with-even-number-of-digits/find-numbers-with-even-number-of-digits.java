class Solution {
   static int countDigits(int n){
        int cnt = 0;
        while(n>0){
            cnt++;
            n = n/10;
        }
        return cnt;
    }
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(var a : nums){
            if(countDigits(a)%2==0) ans++;
        }
        return ans;
    }
}