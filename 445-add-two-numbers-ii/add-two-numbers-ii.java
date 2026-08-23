class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. Reverse both input lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        // 2. Add them using standard reverse-order logic
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry > 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // 3. Reverse the result list to restore forward order
        return reverseList(dummy.next);
    }
    
    // Helper function to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
