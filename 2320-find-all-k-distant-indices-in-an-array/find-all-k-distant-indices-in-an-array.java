class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if( j - i > k) i++;
            if(nums[j] == key){
                while(i < nums.length && i <= j + k)
                    ans.add(i++);
            }
        }

        return ans;
    }
}