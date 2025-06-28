class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
         int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr,(a,b) -> b[0]-a[0]);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(arr[i][1]);
        }

        Collections.sort(list);
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = nums[list.get(i)];
        }

        return result;
    }
}