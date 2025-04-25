class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long count=0;
        long equals=0;
        Map<Integer,Long>map=new HashMap<>();
        map.put(0,1L);
        for(int i : nums){
            if(i % modulo==k){
                equals++;
            }
            int rem = (int )(equals % modulo);
            int needed = (rem-k+modulo) % modulo;
            count+=map.getOrDefault(needed,0L);
            map.put(rem,map.getOrDefault(rem,0L)+1);
        }
        return count;
    }
}