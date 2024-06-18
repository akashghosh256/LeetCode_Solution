class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // https://www.youtube.com/watch?v=WAOfKpxYHR8
        // https://www.youtube.com/watch?v=73sneFXuTEg



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
   // no of nodes 
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

       // it will only enter queue if there is no cycle , atleast one indegree[i] is 0
       while(!q.isEmpty()){
        System.out.println("Inside queue");
        int node = q.peek();
        q.remove();
        topo[ind++] = node;

        for(int it : adj.get(node)){
            inDegree[it]--;
            if(inDegree[it] == 0) q.add(it);
        }

       }
        if(ind == n) return true;
        return false;



        
    }
}