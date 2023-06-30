class Solution
{   
    public boolean dfs(int color[] , ArrayList<ArrayList<Integer>>adj, int node , int currCol){
        color[node] = currCol;
        
        for(int it : adj.get(node)){
            if(color[it] == -1){
                
                if(dfs(color , adj , it ,1-currCol) == false)   return false;
                
                
            }else if(color[it] == currCol){
                return false;
            }
        }
        return true;
    }
    
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V];
        
        Arrays.fill(color , -1);
        
        for(int i =0; i<V; i++){
            if(color[i] == -1){
                if(!dfs( color , adj ,i, 0)){
                     return false;
                }
            }
        }
        return true;
    }
}
