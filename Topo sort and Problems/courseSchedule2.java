class Solution {

    public boolean dfs(int node , boolean vis[] , Stack<Integer> st ,ArrayList<ArrayList<Integer>> adj ,boolean pathVis[]){
        vis[node] = true;
        pathVis[node] = true;
        for(int it: adj.get(node)){
            if(!vis[it]){
                if(dfs(it , vis , st ,adj,pathVis)){
                    return true;
                }
            }else if(pathVis[it]){
                return true;
            }
        }
        pathVis[node] = false;
        st.push(node);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj  = new ArrayList<>();
          int v = prerequisites.length;

        for(int i =0; i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < v ; i++){
            adj.get( prerequisites[i][1]).add( prerequisites[i][0]);
       }

       Stack<Integer> st = new Stack<Integer>();
        
        boolean vis[] = new boolean[numCourses];
        boolean pathVis[] = new boolean[numCourses];
       for(int i =0 ; i<numCourses ; i++){
           if(!vis[i]){
               if(dfs(i , vis, st , adj , pathVis)){
                   return new int[0];
               }
           }
       }


       int res [] = new int[st.size()];
        int i =0;
        while(!st.isEmpty()){
            res[i] = st.pop();
            i++;
        }
        return res;

    }
}
