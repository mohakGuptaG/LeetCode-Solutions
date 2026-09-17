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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode curr = head;
        int size = 0;

        while(curr!=null){
            curr = curr.next;
            size++;
        }

        if(size == n){
            return head.next;
        }

        int myNode = size-n;
        ListNode prev = head;

        for(int i=1; i<myNode; i++){
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return head;
    }
}