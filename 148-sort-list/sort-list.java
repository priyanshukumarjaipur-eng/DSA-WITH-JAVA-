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
    public ListNode sortList(ListNode head) {
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        int arr[]=new int[count];
        curr=head;
        for(int i=0;i<count;i++){
            arr[i]=curr.val;
            curr=curr.next;
        }
        ListNode head1=null;
        ListNode tail=null;
        Arrays.sort(arr);
        for(int i=0;i<count;i++){
            ListNode temp=new ListNode(arr[i]);
            if(head1==null){
                head1=temp;
                tail=head1;
            }
            else{
                tail.next=temp;
                tail=tail.next;
            }
        }
        return head1;
    }
}