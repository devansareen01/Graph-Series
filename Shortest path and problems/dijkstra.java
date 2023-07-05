
class pair{
    int dist; 
    int node;
    
        pair(int node , int dist){
            this.dist = dist;
            this.node  = node;
        }
}
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
      TreeSet<pair> set = new TreeSet<>((a, b) -> {
            if (a.dist != b.dist) {
                return a.dist - b.dist; // Sort by dist in ascending order
            } else {
                return a.node - b.node; // Sort by node in ascending order
            }
        });
        
        int dist[] = new int[V];
        
        Arrays.fill(dist , (int)1e9);
        
        dist[S] = 0;
        
        set.add(new pair (S , 0));
        
        while(!set.isEmpty()){
            
            pair p = set.pollFirst();
                int node = p.node;
                int dis = p.dist;
                
            
                
                for(int i =0; i<adj.get(node).size(); i++){
                    
                    int adjNode = adj.get(node).get(i).get(0);
                    int edgeWeight =  adj.get(node).get(i).get(1);
                    
                    if(dist[node] + edgeWeight <  dist[adjNode] ){
                        
                        dist[adjNode] = dist[node] + edgeWeight;
                        
                        set.add(new pair(adjNode , dist[adjNode]));
                       
                    }
                }
            }
            
        
        
        for(int i =0; i<dist.length;i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }
}
