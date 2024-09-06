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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null || head == null){
            return true;
        }
        ListNode slow = head;ListNode fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversed = rever(slow);
        ListNode fh = head;
        ListNode sh = reversed;

        while(sh!=null){
            if(fh.val != sh.val) return false;

            fh = fh.next;
            sh = sh.next;
        }
        rever(reversed);
        return true;

    }
        public ListNode rever(ListNode head){
            ListNode prev = null;
            ListNode curr = head;
            while(curr!=null){
                ListNode next = curr.next ;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

}