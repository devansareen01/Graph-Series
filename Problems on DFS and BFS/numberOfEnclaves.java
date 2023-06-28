class Solution {
    
      void dfs(int row , int col, boolean vis[][] , int grid[][] ,int n ,int m){
        vis[row][col] = true;

        int delrow[] = {-1 ,0 ,+1 ,0};
        int delcol[] = {0 , +1, 0 ,-1};

        for(int i =0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol <m && !vis[nrow][ncol] 
            && grid[nrow][ncol] == 1){
                dfs(nrow , ncol , vis , grid , n ,m);
            }
        }
    }
    int numberOfEnclaves(int[][] grid) {

        
        int enclaves =0;
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];

        //1st boundary
        for(int i =0; i<m; i++){

            if(!vis[0][i] && grid[0][i]==1){
                dfs(0 , i, vis , grid ,n ,m );
            }
        }  
        //2nd boundary
        for(int i =0; i<n; i++){

            if(!vis[i][0] && grid[i][0]==1){
                dfs(i , 0, vis , grid ,n ,m );
            }
        }  
        //3rd bounday
        for(int i =0; i<m; i++){

            if(!vis[n-1][i] && grid[n-1][i]==1){
                dfs(n-1 , i, vis , grid ,n ,m );
            }
        }  
            //4th boundary 
        for(int i =0; i<n; i++){

            if(!vis[i][m-1] && grid[i][m-1]==1){
                dfs(i , m-1, vis , grid ,n ,m );
            }
        }   
        
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    enclaves++;
                }
            }
        }
        return enclaves;
    }
}
