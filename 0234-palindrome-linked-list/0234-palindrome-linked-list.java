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

        ListNode slow = head;
        ListNode fast = head;
        int size = 0;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            size++;
        }

        ListNode prev = null;
        ListNode cur = slow;

        while(cur!=null){
            ListNode nextnode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextnode;
        }

        ListNode reversehead = prev;

        ListNode r1 = head;
        ListNode r2 = reversehead;

        for(int j=0; j<size; j++){
            if(r1.val!=r2.val){
                return false;
            }
            r1 = r1.next;
            r2 = r2.next;
        }

        return true;
    }
}