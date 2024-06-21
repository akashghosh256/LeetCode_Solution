class Solution {

    private boolean okayDist(int dis, int[] position, int m){
       
        // we will start putting ball from first index 0 and then try all
        int count=1; // first ball placed
        int prevInd = 0;
        for(int i=1; i< position.length; i++){
            if(position[i] - position[prevInd] >= dis){
                count++;
                prevInd =i;
            }
        }

        return (count >= m);

    }


    public int maxDistance(int[] position, int m) {
        
        // binary search problem = Aryan yt
        Arrays.sort(position);
        int n = position.length;
        int l=0;
        int  r = position[n-1] - position[0];
        int ans = -1;

        while(l <= r){
            int mid = (l+r)/2;
            if(okayDist(mid,position,m)){
                ans=mid;
                l = mid + 1;
            }
            else
            {

                r = mid - 1;            }

        }


        return ans;


    }
}