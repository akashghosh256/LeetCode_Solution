import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        // Store the tasks with their start time, processing time, and original index
        int[][] sortedTasks = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0]; // start_time
            sortedTasks[i][1] = tasks[i][1]; // processing_time
            sortedTasks[i][2] = i;           // index
        }
        
        // Sort the tasks based on start time (and by index if start times are the same)
        Arrays.sort(sortedTasks, (a, b) -> {
            if (a[0] == b[0]) {
                return a[2] - b[2];
            } else {
                return a[0] - b[0];
            }
        });
        
        int result[] = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // sort by index if processing times are the same
            } else {
                return a[0] - b[0]; // otherwise, sort by processing time
            }
        });
        
        long currTime = 0;
        int idx = 0;

        int resIndex = 0;
        
        while (idx < n || !pq.isEmpty()) {

            // for cpu idle 
            if (pq.isEmpty() && currTime < sortedTasks[idx][0]) {
                currTime = sortedTasks[idx][0];
            }
            
            // Add all tasks that can start by the current time to the min heap
            while (idx < n && sortedTasks[idx][0] <= currTime) {
                pq.offer(new int[] {sortedTasks[idx][1], sortedTasks[idx][2]}); // {processing_time, index}
                idx++;
            }
            
            // Get the task with the smallest processing time (and smallest index in case of tie)
            int[] currTask = pq.poll();
            currTime += currTask[0];
            result[resIndex++] = currTask[1];
        }
        
        return result;
    }
}
