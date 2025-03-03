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
    public ListNode partition(ListNode head, int x) {
     ListNode beforehead = new ListNode(0);
     ListNode before = beforehead;
     ListNode afterhead = new ListNode(0);
     ListNode after = afterhead;
    ListNode t = head;
    while(t!=null){
        if(t.val <x){
            before.next = t;
            before= before.next;
        }else{
            after.next = t;
            after = after.next ;
        }
        t = t.next;
    }
    after.next  = null;
    before.next = afterhead.next;

    return beforehead.next;
    }
}