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
    public int pairSum(ListNode head) {
        int len=0;
        int max=0;
        ListNode curr=head;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        int arr[]=new int[len];
        curr=head;
        for(int i=0;i<len;i++){
            arr[i]=curr.val;
            curr=curr.next;
        }
        for(int i=0;i<len;i++){
           int sum=arr[i]+arr[len-i-1];
           if(sum>max){
            max=sum;
           }
        }
        return max;
    }
}