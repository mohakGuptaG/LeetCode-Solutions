/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> mp = new HashMap<>();

        ListNode curr = head;

        while(curr!=null){
            if(mp.containsKey(curr)){
                return curr;
            }

            mp.put(curr, 1);
            curr = curr.next;
        }

        return null;
    }
}