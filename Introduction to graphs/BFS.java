
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> bfs = new ArrayList<>();
        
        boolean visited[] = new boolean[V];
        
        q.add(0);
        visited[0] = true;
    
        
        while(!q.isEmpty()){
          int node = q.poll();
          
          bfs.add(node);
          
          for(int it : adj.get(node)){
              if(!visited[it]){
                  visited[it] = true;
                  q.add(it);
              }
              
          }  
            
        }
        return bfs;
    }
}
