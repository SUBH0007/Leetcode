class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        final int N = edges1.length + 1;
        final int M = edges2.length + 1;

        if (k == 0) {
            int[] res = new int[N];
            Arrays.fill(res, 1);
            return res;
        }

        // Preallocate adjacency list
        List<Integer>[] tree1 = new ArrayList[N];
        List<Integer>[] tree2 = new ArrayList[M];
        for (int i = 0; i < N; i++) tree1[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) tree2[i] = new ArrayList<>();

        for (int[] e : edges1) {
            tree1[e[0]].add(e[1]);
            tree1[e[1]].add(e[0]);
        }
        for (int[] e : edges2) {
            tree2[e[0]].add(e[1]);
            tree2[e[1]].add(e[0]);
        }

        int[][] dp1 = new int[N][k + 1];
        int[][] dp2 = new int[M][k];
        int[] parent1 = new int[N];
        int[] parent2 = new int[M];
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        dfs(0, -1, tree1, parent1, dp1, q1, k);
        dfs(0, -1, tree2, parent2, dp2, q2, k - 1);

        int[][] backtrack1 = new int[N][k + 1];
        int[][] backtrack2 = new int[M][k];
        int[] count1 = new int[N];
        int[] count2 = new int[M];

        calcBacktrack(q1, parent1, dp1, backtrack1, count1, k);
        calcBacktrack(q2, parent2, dp2, backtrack2, count2, k - 1);

        int maxConnect = 1;
        for (int c : count2) {
            if (c > maxConnect) maxConnect = c;
        }

        for (int i = 0; i < N; i++) {
            count1[i] += maxConnect;
        }

        return count1;
    }

    private void dfs(int v, int p, List<Integer>[] adj, int[] parent, int[][] dp, Deque<Integer> q, int k) {
        dp[v][0] = 1;
        q.offer(v);
        parent[v] = p;

        for (int u : adj[v]) {
            if (u != p) {
                dfs(u, v, adj, parent, dp, q, k);
            }
        }

        if (p != -1) {
            for (int d = 1; d <= k; d++) {
                dp[p][d] += dp[v][d - 1];
            }
        }
    }

    private void calcBacktrack(Deque<Integer> q, int[] parent, int[][] dp, int[][] backtrack, int[] count, int k) {
        while (!q.isEmpty()) {
            int v = q.poll();
            int p = parent[v];
            count[v] = dp[v][0];

            if (k >= 1) {
                if (p != -1) backtrack[v][1] = 1;
                count[v] += dp[v][1] + backtrack[v][1];
            }

            for (int d = 2; d <= k; d++) {
                if (p != -1) {
                    backtrack[v][d] = dp[p][d - 1] - dp[v][d - 2] + backtrack[p][d - 1];
                }
                count[v] += dp[v][d] + backtrack[v][d];
            }
        }
    }
}