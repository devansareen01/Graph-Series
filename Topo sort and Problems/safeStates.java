class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0; i<v; i++){
            adj.add(new ArrayList<Integer>());
        }
        int indegree[] = new int[v];
        for(int i =0; i<v;i++){
            for(int j =0; j<graph[i].length; j++){
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }

        List<Integer> ans  = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i =0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.remove();
            ans.add(node);

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] ==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
