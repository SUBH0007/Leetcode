class Solution {
    private record Event(int start, int end, int value) {}
    
    public int maxValue(int[][] input, int k) {
        var events = new ArrayList<Event>();
        for (int[] e : input) {
            events.add(new Event(e[0], e[1], e[2]));
        }
        events.sort((a, b) -> Integer.compare(a.start, b.start));
        int n = events.size();
        int[][] dp = new int[k + 1][n];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, -1, events, k, dp);
    }
    
    private int dfs(int i, int count, int prev, List<Event> events, int k, int[][] dp) {
        if (i == events.size() || count == k) return 0;
        if (prev >= events.get(i).start) return dfs(i + 1, count, prev, events, k, dp);
        if (dp[count][i] != -1) return dp[count][i];
        int ans = Math.max(dfs(i + 1, count, prev, events, k, dp), 
                          events.get(i).value + dfs(i + 1, count + 1, events.get(i).end, events, k, dp));
        dp[count][i] = ans;
        return ans;
    }
}