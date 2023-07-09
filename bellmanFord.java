
// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        
        int dis[] = new int[V];
        Arrays.fill(dis , (int)1e8);
        dis[S]  = 0;
        for(int i =0; i<V-1 ; i++){
            
            for(ArrayList<Integer> it : edges){
                int u = it.get(0);
                int v  = it.get(1);
                int w = it.get(2);
                
                if( dis[u] != (int)1e8 && dis[u] + w < dis[v]){
                    dis[v] = dis[u] + w;
                }
            }
        }
        // last iteration for negative cycle check
        
        for(ArrayList<Integer> it : edges){
            int u = it.get(0);
            int v  = it.get(1);
            int w = it.get(2);
                
                if( dis[u] != (int)1e8 && dis[u] + w < dis[v]){
                    return new int[]{-1};
                }
        }
    
      return dis;  
    }
}
