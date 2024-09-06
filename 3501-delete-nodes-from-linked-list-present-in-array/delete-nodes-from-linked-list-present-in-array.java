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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> map = new HashSet<>();
        for(int num:nums){
            map.add(num);
        }
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode temp = dum;
        while(temp.next!=null){
            if(map.contains(temp.next.val)){
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }


        return dum.next;
        }

    }
