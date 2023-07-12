import java.util.* ;
import java.io.*; 
 class DisjointSet {

    
    int size[];
    int parent[];

    public DisjointSet(int n) {
      
        size = new int[n + 1];
        Arrays.fill(size, 1); // size array intitally every node have height with 1
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i; // initially every node is parent node of itself
    }

    public int findUltimateParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUltimateParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUltimateParent(u); // ultimate parent of u
        int ulp_v = findUltimateParent(v); // ultimate parent of v

        if (ulp_u == ulp_v)
            return;
        if (size[ulp_v] < size[ulp_u]) {
            parent[ulp_v] = parent[ulp_u];
            size[ulp_u] += size[ulp_v];
        } else {
            parent[ulp_u] = parent[ulp_v];
            size[ulp_v] += size[ulp_u];
        }
    }
}

 class Pair {
    int u;
    int v;
    int w;

    Pair(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
public class Solution {
    public static int kruskalMST(int V, int E, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Pair> adj = new ArrayList<>();
     

            for (ArrayList<Integer> it : graph) {
                adj.add(new Pair(it.get(0), it.get(1), it.get(2)));
            }
   
        DisjointSet ds = new DisjointSet(V);
        Collections.sort(adj, (x, y) -> x.w - y.w);
        int ans = 0;
        for (Pair it : adj) {
            int u = it.u;
            int v = it.v;
            int w = it.w;

            if (ds.findUltimateParent(u) != ds.findUltimateParent(v)) {
                ans += w;
                ds.unionBySize(u, v); 
            }
            
        }
        return ans;
    }
}
