class Solution {
    public int maxArea(int[] height) {
        // // brute force O(n2)
        // int n = height.length;
        // int res =0;

        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         int area = (j-i)* Math.min(height[i],height[j]);
        //         res = Math.max(res,area);        
        //     }
        // }
        // return res;


        //two pointer approach o(n)
        int n = height.length;
        int res = 0;
        int i = 0;
        int j = n-1;
        while(i < j){
 int area = (j-i)* Math.min(height[i],height[j]);
  res = Math.max(res,area); 

  if( height[i] < height[j])
  i+=1;
  else j-=1;
        
        }

        return res;

        
    }
}