// class Solution {
//     public String countAndSay(int n) {
//         if( n == 1 ) return "1";
//         if( n == 2 ) return "11";
        
//         String num = "11";
//         for(int i=3;i<=n;i++){
//             String temp = "";
//             int count = 1;
//             num = num + "$";
//         for(int j=0;j < num.length()-1;j++){

//             if(num.charAt(j) == num.charAt(j+1)) count++;

//             else{

//                 temp = temp + Integer.toString(count);
//                 temp = temp + num.charAt(j);
//                 count = 1;
//             }
//         }
//         num = temp;

//         }
//         return num;

//     }
// }

public class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        StringBuilder num = new StringBuilder("1");

        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1;

            char currentChar = num.charAt(0);
            for (int j = 1; j < num.length(); j++) {
                if (num.charAt(j) == currentChar) {
                    count++;
                } else {
                    temp.append(count).append(currentChar);
                    currentChar = num.charAt(j);
                    count = 1;
                }
            }

            temp.append(count).append(currentChar);
            num = temp;
        }

        return num.toString();
    }
}
