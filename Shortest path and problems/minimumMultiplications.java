    int node;
    int steps;
    
    Pair(int node  , int steps){
        this.node = node;
        this.steps = steps;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        
        int dist[] = new int[100000];
        Arrays.fill( dist , (int)1e9);
        dist[start] = 0;
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair( start  , 0));
        
        int mod = 100000;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int node = p.node;
            int steps = p.steps;
            
            for(int it : arr){
                int adjNode = ( node * it ) % mod;
                
                if(steps +1 < dist[adjNode]){
                    dist[adjNode] = steps +1;
                    if(adjNode == end) return steps + 1;
                    q.add(new Pair(adjNode , steps+1));
                } 
            }
            
        }
        return -1;
    }
}
