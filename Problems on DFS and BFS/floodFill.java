class Solution
{
    public void dfs(int [][]image ,int ans[][], int row , int col , int newColor , int ini){
        int n  = image.length;
        int m = image[0].length;
        ans[row][col] = newColor;
        
       
        
        if(row > 0 && image[row-1][col]==ini && ans[row-1][col] !=newColor  ) dfs(image ,ans, row-1 , col ,newColor , ini);
        if(col > 0 && image[row][col-1]==ini  && ans[row][col-1] !=newColor) dfs(image ,ans, row , col-1 ,newColor , ini);
        if(row < n-1 && image[row+1][col]==ini  && ans[row +1][col] !=newColor) dfs(image ,ans, row+1 , col ,newColor , ini);
        if(col < m-1 && image[row][col+1]==ini  && ans[row][col+1] !=newColor) dfs(image , ans, row , col+1 ,newColor , ini);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int ans[][] = image;
        
        
        int ini = image[sr][sc];// intial color
        
        dfs(image , ans , sr ,sc ,newColor , ini);
        return ans;
    }
}
