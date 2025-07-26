class Solution {


 public int maxSum(int[] nums) {  
    Set<Integer> set = new HashSet<>();
    int sum=0;
    int maxSum=Integer.MIN_VALUE;
    if(nums.length==1) return nums[0];
    Arrays.sort(nums);
    if(nums[nums.length-1]<=0) return nums[nums.length-1];
    for(int n:nums){
        if(set.contains(n)){
            continue;
        }else if(n>0){
            sum+=n;
            maxSum=Math.max(sum,maxSum);
            set.add(n);
        }
    }
    return maxSum;
 }   
}