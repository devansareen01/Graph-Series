import java.util.*;

class DisjointSet {

    int rank[];
    int size[];
    int parent[];

    public DisjointSet(int n) {
        rank = new int[n + 1];
        // rank array intially every node have rank 0
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

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);

        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        ds.unionBySize(3, 7);
        if (ds.findUltimateParent(7) == ds.findUltimateParent(5)) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }
        
    }
}
