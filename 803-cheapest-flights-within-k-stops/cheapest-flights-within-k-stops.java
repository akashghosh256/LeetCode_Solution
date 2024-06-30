
class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

}
class Tuple{
    int first;
    int second;
    int third;

    public Tuple(int first, int second, int third){
                // stops - node - dist
        this.first = first;
        this.second = second;
        this.third = third;
    }

}
class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // create graph
        // see striver video very important

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for(int i =0; i<m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }


        Queue<Tuple> q = new LinkedList<>();
        // stops - node - dist
        q.add(new Tuple(0,src,0));


        int dist[] = new int[n];
        Arrays.fill(dist, (int)1e9);

        dist[src] =0;

        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int  cost = it.third; // distance

            if( stops > k) continue;

            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int edw = iter.second;

                if( cost + edw < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edw;
                    q.add(new Tuple(stops+1, adjNode, cost+edw));
                }



            }




        }

        if( dist[dst] == (int)1e9) return -1;

        return dist[dst];


    }
}