class Pair{
    int i ;
    int j;
    int step;

    Pair(int i , int j , int step){
        this.i = i;
        this.j = j;
        this.step = step;
    }
}
class Solution {


    public int[][] updateMatrix(int[][] mat) {
        
            int n = mat.length;
            int m = mat[0].length;
            
            boolean vis[][] = new boolean[n][m];

            int ans[][] = new int[n][m];

            Queue<Pair> q = new LinkedList<>();

            for(int i =0; i<n ;i++){

                for(int j =0; j<m; j++){
                    
                    if(mat[i][j] == 0){ 
                        q.add(new Pair (i , j , 0));
                        vis[i][j] = true;
                    }
                }
            }


            while(!q.isEmpty()){
                System.out.println(q.peek().i+" "+q.peek().j+" "+q.peek().step);
                int i = q.peek().i;
                int j = q.peek().j;
                int step = q.peek().step;

                 ans[i][j] = step;

                q.remove();
               
                int delrow[] ={-1 , 0 , +1 , 0};
                int delcol[] = {0 ,+1 , 0 ,-1};


                for(int k =0; k<4; k++){
                    int nrow = i+ delrow[k];
                    int ncol = j+ delcol[k];
                    if(checkIsValid (nrow , ncol, n , m , vis)){
                        q.add(new Pair(nrow , ncol , step+1));
                        vis[nrow][ncol] = true;
                    }
                }
            }
        return ans;
    }

    public boolean checkIsValid(int i , int j , int n , int m , boolean vis[][]){
        return (i >=0 && i < n && j>=0 && j < m && !vis[i][j]);
    }
}
