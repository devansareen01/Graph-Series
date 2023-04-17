class Solution {
    private static void dfs(int node, 
       ArrayList<ArrayList<Integer>> adjLs , 
       boolean vis[]) {
        vis[node] = true; 
        for(Integer it: adjLs.get(node)) {
            if(!vis[it] ) {
                dfs(it, adjLs, vis); 
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjls = new ArrayList<>();
        
        for(int i = 0;i<V;i++) {
            adjls.add(new ArrayList<Integer>()); 
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjls.get(i).add(j);
                    adjls.get(j).add(i);
                }
            }
        }

        boolean vis[] = new boolean[V];
        int count = 0;
        for (int i = 0; i <V; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, adjls, vis);
            }

        }
        return count;
    }
};
// tc = O(V)_
//sc  = O(V)
