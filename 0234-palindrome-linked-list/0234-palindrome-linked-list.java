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
        if(head == null || head.next == null){
            return true;
        }

        int size = 0;
        ListNode curr = head;
        

        while(curr!=null){
            curr = curr.next;
            size++;
        }

        int i=0;
        ListNode midnode = null;
        curr = head;

        while(i<size/2){
            curr = curr.next;
            i++;
        }

        ListNode prev = null;
        ListNode cur = curr;

        while(cur!=null){
            ListNode nextnode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextnode;
        }

        ListNode reversehead = prev;

        ListNode r1 = head;
        ListNode r2 = reversehead;

        for(int j=0; j<size/2; j++){
            if(r1.val!=r2.val){
                return false;
            }
            r1 = r1.next;
            r2 = r2.next;
        }

        return true;
    }
}