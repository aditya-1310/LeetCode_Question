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
    public ListNode swapNodes(ListNode head, int k) {
       int length =0;
       ListNode first = head;
       while(first!=null){
        length++;
        first = first.next;
       }

    ListNode fo = head;
    ListNode so = head;

    for(int i=1;i<k;i++){
        fo = fo.next;
    }

    for(int i=1;i<length-k+1;i++){
        so=so.next;
    }


        int temp = fo.val;
         fo.val = so.val;
         so.val = temp;



    return head;
    }
}