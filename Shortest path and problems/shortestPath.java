class Pair{
   int cell[];
   int dis;

   Pair(int dis , int cell[]){
       this.dis = dis;
       this.cell = cell;
   } 
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       
        int n = grid.length;
        int m = grid[0].length;
        if(n==1 && grid[0][0]== 0) return 1;

         if(grid[0][0] == 1 || grid[n-1][n-1]==1 )  return -1;
        int dist[][] = new int[n][m];

        for(int it[] :dist){
            Arrays.fill(it ,(int)1e9);
        }

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(1 ,new int[]{0 , 0} ));
        dist[0][0] = 1;

        while(!q.isEmpty()){
            Pair p = q.remove();
            int dis = p.dis;
            int row = p.cell[0];
            int col = p.cell[1];

            int delrow[] = {-1 , -1 ,0 , 1, 1, 1, 0, -1};
            int delcol[] = {0 , 1 ,1 ,1, 0,-1 , -1,-1};

            for(int i =0; i<8; i++){
                int nrow = row + delrow[i];
                int ncol  = col + delcol[i];

                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] ==0 ){
                    if(dis + 1 < dist[nrow][ncol] ){
                        dist[nrow][ncol] = dis + 1;
                        if(nrow == n-1  && ncol == n-1){
                            return dist[nrow][ncol];
                        }
                        q.add(new Pair(dis +1 , new int[]{nrow ,ncol}));
                    }
                }
            }
        }
        return -1;
    }
}
