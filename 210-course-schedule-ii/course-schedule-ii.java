class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         int n = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
      //  System.out.println(m);
        
       for(int i=0; i<m;i++){
        adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
       }

       int inDegree[] = new int[n];
       for(int i=0;i<n;i++){
        for(int it : adj.get(i)){
            inDegree[it]++;
        }
       }

       Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
         if(inDegree[i] == 0)
        q.add(i);
       }

       int topo[] = new int[n];
       int ind =0;
       while(!q.isEmpty()){
        int node = q.peek();
        q.remove();
        topo[ind++] = node;

        for(int it : adj.get(node)){
            inDegree[it]--;
            if(inDegree[it] == 0) q.add(it);
        }

       }
        if(ind == n) return topo;
       int ar[] ={};
       return ar;
    }
}