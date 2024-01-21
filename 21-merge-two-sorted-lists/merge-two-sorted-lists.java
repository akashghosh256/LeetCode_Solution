// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         if (l1 == null) return l2;
//         if (l2 == null) return l1;

//         if (l1.val > l2.val) {
//             // Swap l1 and l2 to make sure l1 is always smaller
//             return mergeTwoLists(l2, l1);
//         }

//         ListNode res = l1;

//         while (l1 != null && l2 != null) {
//             ListNode temp = null;
//             while (l1 != null && l1.val <= l2.val) {
//                 temp = l1; // Storing the previous node
//                 l1 = l1.next;
//             }
//             temp.next = l2;
//         }

//         return res;
//     }
// }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val) {
            // Swap l1 and l2 to make sure l1 is always smaller
            return mergeTwoLists(l2, l1);
        }

        ListNode res = l1;

        while (l1 != null && l2 != null) {
            ListNode temp = null;
            while (l1 != null && l1.val <= l2.val) {
                temp = l1; // Storing the previous node
                l1 = l1.next;
            }
            temp.next = l2;
            ListNode swapTemp = l1;
            l1 = l2;
            l2 = swapTemp;

        }

        return res;
    }
}
