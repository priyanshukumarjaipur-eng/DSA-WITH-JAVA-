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
    public ListNode insertionSortList(ListNode head) {
        ListNode curr=head;
        int n=0;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        int arr[]=new int[n];
        curr=head;
        for(int i=0;i<n;i++){
            arr[i]=curr.val;
            curr=curr.next;
        }
        for(int i=1;i<n;i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
        head=null;
        ListNode tail=null;
        for(int i=0;i<n;i++){
            ListNode temp=new ListNode(arr[i]);
            if(head==null){
                head=temp;
                tail=head;
            }
            else{
                tail.next=temp;
                tail=tail.next;
            }  
        }
        return head;
    }
}