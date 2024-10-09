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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode val = dummy;
        while(val.next!=null && val.next.next!=null){
            ListNode temp = val.next;
            ListNode vall  = val.next.next;
             temp.next = vall.next;
            val.next = vall;
            val.next.next = temp;

        val = val.next.next;
        }

        return dummy.next;
    }
}