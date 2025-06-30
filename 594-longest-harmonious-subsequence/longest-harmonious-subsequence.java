class Solution {
    public int findLHS(int[] a) {
        HashMap<Integer,Integer> m = new HashMap<>();
        int n = a.length;
        for(int val : a)
            m.put(val,m.getOrDefault(val,0)+1);
        int ans = 0,t=0;
        for(int k : m.keySet()){
            t=0;
            if(m.containsKey(k-1)){
                t = Math.max(t,m.get(k-1));
                ans = Math.max(ans,t+m.get(k));
            }
            if(m.containsKey(k+1)){
                t = Math.max(t,m.get(k+1));
                ans = Math.max(ans,t+m.get(k));
            }
        }
        return ans;
    }
}