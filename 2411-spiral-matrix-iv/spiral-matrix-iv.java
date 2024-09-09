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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [][] mat = new int [m][n];
        int left =0;int right =n-1;int top=0;int bottom =m-1;
        ListNode current = head;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
            if(current!=null){
                mat[top][i]= current.val;
                current = current.next;
            }
            else{
                mat[top][i]=-1;
            }
            }
            top++;
          
                for(int i=top;i<=bottom;i++){
                    if(current!=null){
                        mat[i][right] = current.val;
                        current = current.next;
                    }
                    else{
                        mat[i][right]=-1;
                    }
                }
            right--;
                
              if(top<=bottom){
                for(int i=right;i>=left;i--){
                    if(current!=null){
                        mat[bottom][i]=current.val;
                        current= current.next;
                    }
                    else{
                        mat[bottom][i]=-1;
                    }
                }
            
            bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    if(current!=null){
                        mat[i][left]=current.val;
                        current = current.next;
                    }
                    else{
                        mat[i][left]=-1;
                    }
                }
            left++;
            }
        }
        return mat;
    }
}