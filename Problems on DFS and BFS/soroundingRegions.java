class Solution {

    public void dfs(char[][] board , boolean vis[][] ,int row , int col ,int n , int m  ){
        vis[row][col] = true;

        int delrow[] = {-1 ,0, +1 , 0};
        int delcol[] = {0, 1 , 0 ,-1};

        for(int k =0; k<4; k++){
            int i = row + delrow[k];
            int j = col + delcol[k];

            if( i>=0 && i<n && j>=0 && j<m && !vis[i][j] && board[i][j]=='O'){
                dfs(board , vis ,i , j ,n,m);
            }
        }

    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean vis[][] = new boolean[n][m];

        // 1st boundary
        for(int i =0; i<m; i++ ){
            if(board[0][i] == 'O'){
                if(!vis[0][i]){
                    
                    dfs( board , vis ,0 , i, n, m );
                }
            }
        }
        //2nd boundary
        for(int i =0; i<n; i++ ){
            if(board[i][0] == 'O'){
                if(!vis[i][0]){
                   
                    dfs( board , vis ,i , 0 , n ,m );
                }
            }
        }
        // 3rd boundary
        for(int i =0; i<m; i++ ){
            if(board[n-1][i] == 'O'){
               if(!vis[n-1][i]){
                    
                    dfs( board , vis, n-1,i,n ,m );
               }
            }
        }

        //4th boundary

        for(int i =0; i<n; i++ ){
            if(board[i][m-1] == 'O'){
                if(!vis[i][m-1]){
                    
                    dfs( board , vis,i , m-1 ,n,m);
                }
            }
        }
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(!vis[i][j] && board[i][j]== 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
