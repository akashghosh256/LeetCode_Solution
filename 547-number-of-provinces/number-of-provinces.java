class Solution {
    void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int i){

    vis[i] = true;
    for(Integer it : adj.get(i)){
        if(!vis[it]){
            dfs(adj,vis,it);
        }
    }        


    }

void bfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int i){

Queue<Integer> q = new ArrayDeque<>();

q.add(i);
vis[i] = true;

while(!q.isEmpty()){
int node = q.poll();

for(int it : adj.get(node)){
    if(!vis[it]){
        q.add(it);
        vis[it] = true;
    }
}



}


}




    public int findCircleNum(int[][] isConnected) {
    

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int n = isConnected.length;
    for(int i=0;i<n;i++)
    adj.add(new ArrayList<>());
    for(int i=0;i<n;i++){
        for(int j=0; j<n; j++){

            if( isConnected[i][j] == 1 && i!=j){
                adj.get(i).add(j);
                adj.get(j).add(i);
            }

        }
    }

    boolean vis[] = new boolean[n+1];
    //vis[0] = true;

    int count =0;
    // for(int i=0; i<n; i++){
    //     if(!vis[i]){
    //         dfs(adj,vis,i);
    //         count++;
    //     }
    // }

    for(int i=0; i<n; i++){
        if(!vis[i]){
            bfs(adj,vis,i);
            count++;
        }
    }

    return count;

        
    }
}