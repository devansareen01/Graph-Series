class Pair{
    int node;
    int dis;

    Pair(int node ,int dis){
        this.node = node;
        this.dis = dis;        
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<Pair>> adj  = new ArrayList<>();

        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1 - x2)+ Math.abs(y1-y2);

                adj.get(i).add( new Pair (j , dist));
                adj.get(j).add( new Pair (i , dist));
            }
        }

        boolean vis[] = new boolean[n];
       

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)-> x.dis - y.dis);

        pq.add( new Pair(0 ,0));

        int cost = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            int dist = p.dis;

            if(vis[node])
                continue;
            vis[node] = true;
            cost +=dist;

            for(Pair it: adj.get(node)){
                if(!vis[it.node])
                    pq.add(new Pair(it.node , it.dis));
            }
        }
        return cost;
    }
}
