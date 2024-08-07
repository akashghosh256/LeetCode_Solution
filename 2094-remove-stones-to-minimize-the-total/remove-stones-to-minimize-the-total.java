import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        int n = piles.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int total = 0;

        // Add all elements to the max-heap and calculate the total
        for(int i = 0; i < n; i++) {
            pq.add(piles[i]);
            total += piles[i];
        }

        // Perform k operations
        for(int i = 1; i <= k; i++) {
            int topElement = pq.poll();
            int removeStones = topElement / 2; 
            total -= removeStones;
            pq.add(topElement - removeStones);
        }

        return total;
    }
}
