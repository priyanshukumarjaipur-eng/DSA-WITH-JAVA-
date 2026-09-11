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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> st=new Stack<>();
        ListNode curr=head;
        while(curr!=null){
                while(!st.isEmpty() && curr.val>st.peek()){
                    st.pop();
                }
                st.push(curr.val);
            curr=curr.next;
        }
        ListNode newHead = null;
        ListNode tail = null;
        for (int val : st) {
            ListNode node = new ListNode(val);
            if (newHead == null) {
                newHead = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return newHead;
    }
}