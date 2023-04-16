class Solution {
    
    private void dfs (int node , ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> ls , boolean vis[]){
        vis[node] = true;
        ls.add(node);
        
        for(int it : adj.get(node)){
            if(!vis[it]){
                vis[it] = true;
                dfs(it , adj , ls , vis);
            }
        }
    }
    
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean vis[] = new boolean[V];
       vis[0] = true;
       ArrayList<Integer> dfs = new ArrayList<>();
       dfs(0 ,adj , dfs ,vis);
       return dfs;
    }
}
// Time = o(N)+2(E)//total edges
//Spcae  = O(3n)~O(N)
