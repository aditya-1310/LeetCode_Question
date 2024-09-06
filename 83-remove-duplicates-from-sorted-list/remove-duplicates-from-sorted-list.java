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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dum = new ListNode(0);
        dum.next =head;
        ListNode temp = dum;
        while(temp.next!=null && temp.next.next !=null){
            if(temp.next.next.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
        return dum.next;
    }
}