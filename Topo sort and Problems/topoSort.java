class Solution

{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // creating indegree
        int indegree[] = new int [V];
        
        for(int  i =0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        int topoSort[] = new int[V];
        
        for(int i =0; i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        
        int i =0;
        while(!q.isEmpty()){
            int node = q.remove();
            
           topoSort[i++] = node;
           
           for(int it :adj.get(node)){
               indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
           }
           
           
           
        }
        return topoSort;
    }
}
