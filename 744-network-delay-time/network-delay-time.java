import java.util.*;

class Pair {
    int node;
    int distance;
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {

    private void solve(List<List<Pair>> graph, int n, int k, int dist[]) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        pq.add(new Pair(k, 0));
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentNode = current.node;
            int currentDistance = current.distance;

            if (currentDistance > dist[currentNode]) continue;

            for (Pair neighbor : graph.get(currentNode)) {
                int newNode = neighbor.node;
                int edgeWeight = neighbor.distance;

                if (currentDistance + edgeWeight < dist[newNode]) {
                    dist[newNode] = currentDistance + edgeWeight;
                    pq.add(new Pair(newNode, dist[newNode]));
                }
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new Pair(v, w));
        }

        int dist[] = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);
        
        solve(graph, n, k, dist);

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
