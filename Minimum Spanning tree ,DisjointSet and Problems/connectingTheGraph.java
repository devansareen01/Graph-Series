

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

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;

        if (n - 1 > m) // we can make all the connections only if there is
            return -1; // vertex-1 edges
        int connectComp = 0;
        int extraEdges = 0;
        DisjointSet ds = new DisjointSet(n);
        for (int it[] : connections) {
            if (ds.findUltimateParent(it[0]) == ds.findUltimateParent(it[1]))
                extraEdges++;
            else
                ds.unionBySize(it[0], it[1]);
        }
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i) { // if any node it itself a ulitmate parent then there is a connected component
                connectComp++;
            }
        }
        if (extraEdges >= connectComp - 1) {
            return connectComp - 1;
        }

        return 1;
    }

}
