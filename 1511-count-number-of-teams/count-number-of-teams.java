class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int teams = 0;


    for(int j=1; j<n-1; j++){
        int leftSmall = 0;
        int leftLarge = 0;
        int rightSmall = 0;
        int rightLarge = 0;

        for(int i=0; i<j; i++){
            if(rating[i] > rating[j]) leftLarge++;
            else leftSmall++;
        }

        for(int k=j+1; k<n;k++){
            if(rating[k] > rating[j]) rightLarge++;
            else rightSmall++;
        }

        teams += (leftSmall * rightLarge) + (leftLarge * rightSmall);
        }


return teams;

        
    }
}