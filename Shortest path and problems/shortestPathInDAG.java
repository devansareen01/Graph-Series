class pair{
    int v;
    int w;
    
    pair(int v , int w){
        this.v = v;
        this.w = w;
    }
}
class Solution {
    
    private void topoSort(int node , ArrayList<ArrayList<pair>> adj , Stack<Integer> st , boolean vis[]){
        vis[node] = true;
        
        for(pair it : adj.get(node)){
                if(!vis[it.v]){
                    topoSort(it.v , adj , st , vis);
                }
        }
        st.push(node);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		
		ArrayList<ArrayList<pair>> adj = new ArrayList<>();
		
		for(int i =0; i<N; i++){
		    adj.add( new ArrayList<pair>());
		}
		
		for(int i =0; i<M; i++){
		    adj.get(edges[i][0]).add(new pair(edges[i][1] , edges[i][2]));
		}
		
		Stack<Integer> st = new Stack<>();
		boolean vis[] = new boolean[N];
		
		for(int i =0; i<N; i++){
		    if(!vis[i]){
		        topoSort( i , adj , st , vis);
		    }
		}
		
		int dis[] = new int[N];
		
		Arrays.fill(dis ,(int)1e9);
		dis[0] = 0;
		
		while(!st.isEmpty()){
		    int node = st.pop();
		    
		    for(pair it :  adj.get(node)){
		        if(dis[node] + it.w < dis[it.v]){
		            dis[it.v] = dis[node] + it.w;
		        }
		    }
		}
		
		for(int i =0; i< N; i++){
		    if(dis[i] == (int) 1e9){
		            dis[i] =-1 ;
		    }
		}
		return dis;
	}
}
