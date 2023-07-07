class Pair{
    int node;
    int dis;
    Pair(int node , int dis){
        this.node = node;
        this.dis = dis;
    }
}
class Tuple{
    int node;
    int stop;
    int dist;

    Tuple(int stop , int node , int dist){
        this.stop = stop;
        this.node = node;
        this.dist = dist;
    }
}
class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList< ArrayList < Pair > > adj  = new ArrayList<>();
        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int it[] : flights){
            adj.get(it[0]).add(new Pair (it[1] , it[2]));
        }
        int dis[] = new int[n];
        Arrays.fill(dis , (int)1e9);
        dis[src] =0;

        Queue<Tuple> q = new LinkedList<>();

        q.add(  new Tuple (0 , src ,0));

        while(!q.isEmpty()){
            Tuple t = q.remove();
            int node = t.node;
            int stop = t.stop;
            int dist = t.dist;

            if(stop > k) continue;

            for(Pair it : adj.get(node)){
                if(dist + it.dis < dis[it.node] && stop <= k){
                    dis[it.node] = dist + it.dis;
                    q.add(new Tuple( stop +1 , it.node , dis [it.node] ));
                }
            }
        }
        if(dis[dst] == (int)1e9) return -1;
        
        return dis[dst];

    }
}
