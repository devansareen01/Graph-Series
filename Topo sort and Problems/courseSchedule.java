class Solution {
    public boolean dfs(int node , int vis[] , int pathVis[] , ArrayList<ArrayList<Integer>> adj ){
        
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int it : adj.get(node)){
            if(vis[it] != 1 ){
                if(dfs(it , vis , pathVis , adj)){
                    return true;
                }
            }else if( pathVis[it] ==1){
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
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int m = prerequisites.length;

        for(int i =0; i<numCourses ; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        System.out.println(adj);
       if(isCyclic(numCourses,adj)){
           return false;
       }
        return true;
    }
}
