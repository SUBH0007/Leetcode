class Solution {
    ArrayList<Integer>[] graph;
    int[] arr;
    int totXor=0;
    int time=0;
    int ans=Integer.MAX_VALUE;
    public int minimumScore(int[] nums, int[][] edges) {
        arr=nums;
        int n=edges.length+1;
        int visitTime[]=new int[n];
        boolean[] visited=new boolean[n];
        graph=new ArrayList[n];
        for(int i=0;i<n-1;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            if(graph[u]==null)
            graph[u]=new ArrayList<>();
            if(graph[v]==null)
            graph[v]=new ArrayList<>();
            graph[u].add(v);
            graph[v].add(u);
        }

        totXor= dfs(0,visited);
        // System.out.println(Arrays.toString(visitTime));
        // System.out.println(Arrays.toString(xor));

        for(int i=0;i<n-1;i++)
        {
            int[] edge=edges[i];
            int root1=edge[0];
            int root2=edge[1];
            
            Arrays.fill(visited,false);
            visited[root2]=true;
            int xor1=dfs(root1,visited);
            int xor2=totXor ^ xor1;

            Arrays.fill(visited,false);
            visited[root2]=true;
            dfs(root1,visited,xor2,xor1);

            Arrays.fill(visited,false);
            visited[root1]=true;
            dfs(root2,visited,xor1,xor2);

        }



        return ans;

    }

    int dfs(int node,boolean[] visited,int v1,int cur)
    {
        if(visited[node])
        return 0;
        visited[node]=true;
        int sxor=arr[node];
        for(int i=0;(graph[node]!=null && i<graph[node].size());i++)
        {
            if(visited[graph[node].get(i)])
            continue;
          int v3=dfs(graph[node].get(i),visited,v1,cur);
          sxor=sxor^v3;
          int v2=cur ^ v3;
          int diff=difference(v1,v2,v3);
          ans=Math.min(ans,diff);
        }
        return sxor;

    }

    int dfs(int node,boolean visited[])
    {
        if(visited[node])
        return 0;
        visited[node]=true;
        int xor=arr[node];
        for(int i=0;(graph[node]!=null && i<graph[node].size());i++)
           xor=xor ^ dfs(graph[node].get(i),visited);
        return xor;
    }

    int difference(int v1,int v2,int v3)
    {
        int max=Math.max(v1,Math.max(v2,v3));
        int min=Math.min(v1,Math.min(v2,v3));
        return max-min;
    }

}