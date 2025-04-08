class Solution {
    public int minimumOperations(int[] nums) {
         int n = nums.length;
        int left = 0;
        int count = 0;
        while(!areDistinct(nums,left,n)) {
            count++;
            if(left+3 < n) left += 3;
            else if(left+2 < n) left += 2;
            else left++;
        }
        return count;
    }
    private boolean areDistinct(int[] arr, int s, int e) {
        Set<Integer> set = new HashSet<>();
        for (int i = s; i < e; i++) {
            if (set.contains(arr[i])) return false;
            set.add(arr[i]);
        }
        return true;
    }
}