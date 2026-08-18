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
        // Step 1: Count total nodes
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Step 2: Find position to delete (length - n)
        int pos = length - n;

        // Step 3: Handle edge case (remove head)
        if (pos == 0) {
            return head.next;
        }

        // Step 4: Traverse again to node before target
        curr = head;
        ListNode prev = null;
        for (int i = 0; i < pos; i++) {
            prev = curr;
            curr = curr.next;
        }

        // Step 5: Remove target node
        prev.next = curr.next;

        return head;
    }
}
