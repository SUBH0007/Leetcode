class Solution {
     int n;
    HashMap<Integer,ArrayList<Integer>>map;
    int [][]colours;
    int[]indegree;

    public int largestPathValue(String colors, int[][] edges) {
        if(edges.length==0)return 1;
     map=new HashMap<>();
     int visited=0;
        for (int i = 0; i < edges.length; i++) {
            n=Math.max(n,Math.max(edges[i][0],edges[i][1]));
            if (map.containsKey(edges[i][0])){
                map.get(edges[i][0]).add(edges[i][1]);
            }else {
                ArrayList<Integer>list=new ArrayList<>();
                list.add(edges[i][1]);
                map.put(edges[i][0],list);
            }
        }
        n+=1;
        indegree=new int[n];
        colours=new int[n][26];
        int ans=0;
        for (int i = 0; i < edges.length ; i++) {
            indegree[edges[i][1]]+=1;
        }
        Deque<Integer>q=new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i]==0){
                int col=colors.charAt(i)-97;
                colours[i][col]=1;
                q.offer(i);
            }
        }
        while (!q.isEmpty()){
            int v=q.poll();
            visited++;
            ArrayList<Integer>l=map.get(v);
            int j=0;
            if (l!=null) {
                while (j<l.size()) {
                    int a = l.get(j);
                    int col = colors.charAt(a) - 97;
                    for (int i = 0; i < 26; i++) {
                        int prev = colours[v][i];
                        if (i == col) {
                            prev += 1;
                        }
                        ans = Math.max(ans, prev);
                        if (prev > colours[a][i]) {
                            colours[a][i] = prev;
                        }
                    }
                    indegree[a]-=1;
                    if (indegree[a]== 0) {
                        q.offer(a);
                    }
                    j++;
                }
            }
        }
        if (visited!=n){
            return -1;
        }
        return ans;
    }
}