class Pair{
    int row;
    int col;
    int time;
    Pair(int row , int col ,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution
{
    
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        Queue < Pair > q = new LinkedList <>();
        
        int vis[][] = new int[n][m];
        
        int cntfresh = 0;
        
        for( int i =0; i<n; i++){
            for( int j =0; j < m; j++){
                    if( grid[i][j] == 2){
                        // pushing all the intital rootten oranges
                        q.add( new Pair (i , j , 0));
                           // mark as visited
                        vis[i][j] = 2;
                    }else{
                        vis[i][j] = 0;
                    }
                 if(grid[i][j] == 1) cntfresh++;
            }
        }
        int drow[] ={-1 , 0 , 1 , 0}; 
        int dcol[] ={0 , 1, 0 ,-1};
        int tm = 0;
        int count = 0;
        while( !q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            tm = Math.max(tm , t);
            q.remove();
            
            for(int i = 0 ; i<4 ;i++){
                int nrow =  r + drow[i];
                int ncol = c + dcol[i];
            
            
            if(nrow >=0 &&  nrow <n && ncol >=0 && ncol<m && vis[nrow][ncol] == 0
             && grid[nrow][ncol] ==1){
                 q.add( new Pair( nrow ,ncol , t+1));
                 
                 vis[nrow][ncol] = 2;
                 count++;
             }
            
            }
            
        }
        if(count != cntfresh) return -1;
        return tm;
    }
}
