// class Solution {
//     public int countPrimes(int n) {
//       //  if( n==1) return 0;
//         int rem = n / 10;
//         int ans = rem * 4;
//         int count =0 ;
//         for(int i=rem > 0 ? rem*10:2; i<n; i++){
//             for(int j=2;j<i;j++){
//               if( i % j == 0)  count++;
//             }
//             if( count == 0) ans++;

//             count=0;
//         }

//         return ans;
//     }
// }

public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}