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
    public boolean isValid(int n , int i , int j){
        return ( i >=0 && i < n && j >= 0 && j < n);
    }
    
    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        
        DisjointSet ds = new DisjointSet (n*n);
        
        //step 1 connecting components
        
        for(int i =0; i<n; i++){
            for( int j = 0; j < n; j++){
                if(grid[i][j] == 0 ) continue;
                int delRow[] = {-1 , 0, 1, 0};
                int delCol[] = {0 , -1, 0 , 1};
                
                for(int ind = 0 ; ind < 4 ; ind++){
                    int nRow = i + delRow[ind];
                    int nCol = j + delCol[ind];
                    int node = ( i * n) + j; // row * m + col
                    int adjNode = ( nRow * n) + nCol;
                    if(isValid( n , nRow , nCol) && grid[nRow][nCol] == 1){
                        ds.unionBySize( node , adjNode);
                    }
                }
            }
        }
        
        // step 2
            int max = 0;
        for(int i = 0; i < n; i++){
            for( int j = 0; j < n; j++){
                if( grid[i][j] == 1 ) continue;
                
                    HashSet<Integer> set = new HashSet<>();
                    
                     int delRow[] = {-1 , 0, 1, 0};
                     int delCol[] = {0 , -1, 0 , 1};
                
                for(int ind = 0 ; ind < 4 ; ind++){
                    int nRow = i + delRow[ind];
                    int nCol = j + delCol[ind];
                    int adjNode = ( nRow * n) + nCol;
                    
                    if(isValid (n , nRow , nCol) && grid[nRow][nCol] == 1){
                        set.add( ds.findUltimateParent(adjNode));
                    }
                }
                
                int size = 0;
                
                for(Integer par : set ){
                    size +=  ds.size[par];
                }
                max = Math.max( max , size + 1);
            }
        }
        
        
        for(int i = 0; i < n * n; i++){
            max  = Math.max( max , ds.size[ds.findUltimateParent(i)]);
        }
        
        return max;
        
    }
    
}
