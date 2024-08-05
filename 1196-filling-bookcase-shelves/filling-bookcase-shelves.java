class Solution {
    private int n;
    private int WIDTH;
    private int dp[][];  // books length, shelfWidth

    // https://www.youtube.com/watch?v=pOtAvGIW8kQ&ab_channel=codestorywithMIK

    private int solve(int [][] books , int i, int remW, int maxH){
        // top-down

        if(i>=n) return maxH;

        if(dp[i][remW] != -1) return dp[i][remW];

        int bookW = books[i][0];
        int bookH = books[i][1];

        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;

        // keep
        if(bookW <= remW)
        keep = solve(books, i+1, remW - bookW, Math.max( maxH, bookH));

        // skip
        skip = maxH + solve(books, i+1 , WIDTH-bookW, bookH);

       // return Math.min(keep,skip);
       return dp[i][remW] = Math.min(keep, skip);


    }



    public int minHeightShelves(int[][] books, int shelfWidth) {
        n  = books.length;
        WIDTH = shelfWidth;
        int remW = shelfWidth;

        dp = new int[1001][1001];

        for(int row[] : dp)
        Arrays.fill(row,-1);

        return solve(books, 0, remW, 0);

        
    }
}