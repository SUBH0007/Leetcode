class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int item: nums) {
            if(!seen.add(item)) return true;
        }
        return false;
    }
}