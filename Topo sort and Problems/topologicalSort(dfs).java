class Solution
{
    public static void dfs(ArrayList<ArrayList<Integer>> adj , Stack<Integer> st , int node , boolean vis[]){
        vis[node] = true;
        
        for(int it :adj.get(node)){
            if(!vis[it]){
                dfs(adj , st, it , vis);
          
            }
        }
        st.push(node);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i =0; i<V; i++){
            if(!vis[i]){
                dfs(adj , st , i , vis);
            }
        }
        int ans[] = new int[st.size()];
        int i =0;
        while(!st.isEmpty()){
            ans[i] = st.pop();
            i++;
        }
        return ans;
    }
}
