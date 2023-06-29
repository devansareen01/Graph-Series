class Solution {
    public boolean isBipartite(int[][] graph) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(!vis[i]){
                if(!dfs(i, set1, set2, -1, graph, vis)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int s, HashSet<Integer> set1, HashSet<Integer> set2, int par, int[][] graph, boolean vis[]){
        if(set1.contains(par)) set2.add(s);
        else set1.add(s);
        vis[s] = true;
        for(int v : graph[s]){
            if(set1.contains(s)){
                if(set1.contains(v)) return false;
                else if(!vis[v] && !dfs(v, set1, set2, s, graph, vis)) return false;
            } else {
                if(set2.contains(v)) return false;
                else if(!vis[v] && !dfs(v, set1, set2, s, graph, vis)) return false;
            }
        }
        return true;
    }
}
