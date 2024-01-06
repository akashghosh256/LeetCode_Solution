class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int [][] height = new int [n][m];

        Queue <int[]> bfs = new LinkedList<>();

       for(int r=0; r<n;r++){
           for(int c=0; c<m; c++){
               if(isWater[r][c] == 1){
                   height[r][c] = 0;
                   bfs.offer(new int[]{r,c});
               }
               else {
                   height[r][c] = -1;
               }
           }
       }

       int[] dir = { 0,1,0,-1,0};
       while( !bfs.isEmpty()){
           int [] top = bfs.poll();
           int r = top[0], c = top[1];

           for(int i=0;i<4;i++){
               int nr = r + dir[i], nc = c+ dir[i+1];
               if( nr <0 || nc < 0 || nr == n || nc == m || height[nr][nc] != -1) continue;
        height[nr][nc] = height[r][c] +1;
        bfs.offer(new int[]{nr,nc});       


           }

       } 

return height;

    }
}