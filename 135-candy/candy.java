class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ar[] = new int[n];
        Arrays.fill(ar,1);

        // left to right
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                ar[i] = ar[i-1]+1;
            }
        }

        // right to left
        for(int i = n-2; i>=0; i--){
            if(ratings[i]> ratings[i+1]){
                ar[i] = Math.max(ar[i], ar[i+1]+1);
            }
        }

        int sum =0;
        for(int i : ar)
        sum += i;
        return sum;
        // tc = o(n 2)
    }
}