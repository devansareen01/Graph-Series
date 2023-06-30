class Solution {
    
    public boolean dfs(int node , int vis[] , int pathVis[] , ArrayList<ArrayList<Integer>> adj ){
        
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int it : adj.get(node)){
            if(vis[node] != 1 ){
                if(dfs(node , vis , pathVis , adj)){
                    return true;
                }
            }else if( pathVis[node] ==1){
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
        
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int pathVis[] = new int[V];
        
        int vis[] = new int[V];
        
        for(int i =0; i<V; i++){
            if(vis[i] == 0){
                if(dfs( i , vis , pathVis , adj))
                    return true;
            }
        }
        return false;
    }
}
