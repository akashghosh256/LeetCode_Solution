// class Solution {
//     public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
//     }
// }

public class Solution {
    
    // Helper method to find the greatest common divisor using Euclid's algorithm
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Main method to minimize the set based on given conditions
    public int minimizeSet(int d1, int d2, int u1, int u2) {
        // Initialize left and right boundaries
        long l = 1, r = 2000000009;
        // Initialize the answer
        long ans = r;
        // Calculate the least common multiple of d1 and d2
        long lc = (((long) d1 * (long) d2)) / gcd(d1, d2);
        
        // Binary search loop
        while (l <= r) {
            // Calculate the middle point
            long mid = (l + r) / 2;
            // Calculate the count of numbers divisible by d1
            int x = (int) (mid - (mid / d1));
            // Calculate the count of numbers divisible by d2
            int y = (int) (mid - (mid / d2));
            // Calculate the count of numbers divisible by both d1 and d2
            int z = (int) (mid - (mid / lc));
            
            // Check conditions
            if (x < u1 || y < u2 || z < u1 + u2) {
                // If conditions not met, update left boundary
                l = mid + 1;
            } else {
                // If conditions met, update answer and right boundary
                ans = Math.min(ans, mid);
                r = mid - 1;
            }
        }
        
        // Convert the answer to integer and return
        return (int) ans;
    }
}

