class Pair{
    int node;
    int distance;

    Pair(int node , int distance){
        this.node = node;
        this.distance = distance;
    }
    
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i =0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }
        for(int it[] : times){
            adj.get(it[0]).add( new Pair (it[1] , it[2]));
        }
        int dist[] = new int[n+1];
       
        Arrays.fill( dist , (int)1e9);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x ,y) -> x.distance -y.distance);

        pq.add(new Pair( k , 0));

        while(!pq.isEmpty()){
            Pair p = pq.remove();

            int node = p.node;
            int distance = p.distance;

            for( Pair it : adj.get(node)){
                int adjNode = it.node;
                int edW = it.distance;
                
                if(distance + edW < dist[adjNode]){
                    // System.out.println(distance + edW +" "+ dist[adjNode] );
                    dist[adjNode] = distance + edW;
                    pq.add(new Pair( adjNode , dist[adjNode]));
                }
             
            }
        }
        
        for(int i =1; i<n+1; i++){
            if(dist[i] == (int)1e9) return -1;
        }
        Arrays.sort(dist);
        
        return dist[n-1];
    }
}
