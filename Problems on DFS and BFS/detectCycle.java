class Pair{
    int parent;
    int child;
    
    Pair(int child , int parent ){
        this.parent = parent;
        this.child = child;
    }
}
class Solution {
    
    public boolean bfs( int i , ArrayList<ArrayList<Integer>> adj , boolean vis[]){
        
            Queue<Pair> q = new LinkedList<>();    
            
            q.add(new Pair (i , -1));
            vis[i] = true;
            
            while(!q.isEmpty()){
                int parent = q.peek().parent;
                int child = q.peek().child;
                q.remove();
                
                for(int it : adj.get(child)){
                    if(!vis[it]){
                        
                        q.add(new Pair (it , child));
                        vis[it] = true;
                        
                    }else if(parent != it){
                               return true;
                    }
                }
            }
            return false;
    }
    
    public boolean dfs(int i, int parent , ArrayList<ArrayList<Integer>> adj , boolean vis[]){
        vis[i] = true; 
        
        for(int it : adj.get(i)){
            if(!vis[it]){
                if(dfs(it , i , adj , vis ) ){
                    return true;
                }
            }else if( parent != it){
                    return true;
                }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        
        for(int i =0; i<V ; i++){
            if(!vis[i])
                if( dfs( i,-1 , adj , vis))
                    return true;
            
        }
        return false;
    }
}
