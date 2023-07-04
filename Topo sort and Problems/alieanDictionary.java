class Solution
{
    public String findOrder(String [] dict, int N, int k)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i =0; i<k; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        
        
        for(int i =0; i<dict.length-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
           int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        
        
        // System.out.println(adj);
        int indegree[] = new int[k];
        int topo[] = new int[k];
        
        for(int i =0; i<k; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i =0; i<k; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }        
        
        int j =0;
        
        while(!q.isEmpty()){
            int node = q.remove();
            
            topo[j++] = node;
            
            for(int it :adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }
        String ans = "";
        
        for(int i =0; i<topo.length; i++){
         
            ans+= (char)(topo[i] + (int)'a');
        }
            
        return ans;
    }
}
