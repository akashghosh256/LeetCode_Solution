// class Solution {
//     public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
//     }
// }

class Solution {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int minimizeSet(int d1, int d2, int u1, int u2) {
        long l = 1, r = 2000000009;
        long ans = r;
        long lc = (((long) d1 * (long) d2)) / gcd(d1, d2);
        while (l <= r) {
            long mid = (l + r) / 2;
            int x = (int) (mid - (mid / d1)); //no of elements only divisible by d1
            int y = (int) (mid - (mid / d2)); //no of elements only divisible by d2
            int z = (int) (mid - (mid / lc)); // no of elements not divisible by any
            if (x < u1 || y < u2 || z < u1 + u2) {
                l = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                r = mid - 1;
            }
        }
        return (int) ans;
    }
}
