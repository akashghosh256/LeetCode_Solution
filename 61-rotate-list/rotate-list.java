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
    public ListNode rotateRight(ListNode head, int k) {
        int len=1;
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        while( temp.next != null){
            len++;
            temp = temp.next;
        }
        temp.next = head; //CLL

   k = k % len;
   int end = len - k;
  // temp = head;
    while( end-- != 0){
        temp = temp.next;
    }
head = temp.next;
temp.next = null; 




return head;




    }
}