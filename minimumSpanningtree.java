class Pair{
    int node;
    int weight;
    
    Pair(int node ,  int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	   ArrayList<ArrayList< Pair>> adj  = new ArrayList<>();
	   
	   for(int i =0; i<V; i++){
	       adj.add(new ArrayList<>());
	   }
	   for(int it[] : edges){
	       adj.get(it[0]).add(new Pair (it[1] , it[2]));
	        adj.get(it[1]).add(new Pair (it[0] , it[2]));
	   }
	   
	   PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
	   boolean vis[] = new boolean[V];
	    
	   pq.add(new Pair (0 ,0));
	    int sum =0;
	    
	    while(!pq.isEmpty()){  
	           Pair p = pq.remove();
	           int node = p.node;
	           int edW = p.weight;
	           
	           if(vis[node])
	                continue;
	           vis[node] = true;
	           sum +=edW;
	           for(Pair it : adj.get(node)){
	               if(!vis[it.node])
	                    pq.add(new Pair(it.node , it.weight));
	           }
	           
	   }
	    return sum;
	}
}
