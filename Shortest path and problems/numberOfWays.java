class Pair{
    int node;
    int distance;

    Pair(int node , int distance){
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    int mod = (int)Math.pow(10 , 9)+ 7;
    public int countPaths(int n, int[][] roads) {
        
        ArrayList< ArrayList< Pair>> adj = new ArrayList<>();

        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int it[] : roads){
            adj.get(it[0]).add( new Pair ( it[1] , it[2]));
            adj.get(it[1]).add( new Pair ( it[0] , it[2]));
        }

        long ways[] = new long[n];
        
        int dist[] = new int[n];
        Arrays.fill( dist , Integer.MAX_VALUE);
        ways[0] = 1;
        dist[0] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x , y) -> x.distance - y.distance);
        pq.add(new Pair( 0 , 0 ));

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            int distance = p.distance;

            
            for(Pair it : adj.get(node)){

                int adjNode = it.node;
                int edW = it.distance;

                    if(distance + edW < dist[adjNode]){
                        dist[adjNode] = distance + edW;
                        ways[adjNode] = ways[node];
                        pq.add( new Pair( adjNode , dist[adjNode]));
                        
                    } // if we come up with same distance at already visited node then there is another one more way
                    else if(distance + edW == dist[adjNode]){
                        ways[adjNode] = (ways[adjNode] + ways[node] ) % mod;
                    }
                }
            }
            
            return (int) ways[n-1] % mod;
        }
        
    }
