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
    public ListNode reverse(ListNode head){
        ListNode curr=head,prev=null;
        while(curr!=null){
            ListNode nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return prev;
    }
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr=head;
        int n=0;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        int nge[]=new int[n];
        ListNode newlead=reverse(head);
        Stack<Integer> st=new Stack<>();
        curr=newlead;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && curr.val>=st.peek()){
                st.pop();
            }
            nge[n-i-1]=st.isEmpty() ? 0:st.peek();
            st.push(curr.val);
            curr=curr.next;
        }
        return nge;
    }
}