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
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
            }
            else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        if (l1 != null) {
        curr.next = l1;
        } 
        else {
        curr.next = l2;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> arr=new ArrayList<>();
        int n=lists.length;
        for(int i=0;i<n;i++){
            arr.add(lists[i]);
        }
        while(arr.size()>1){
            ListNode a=arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            ListNode b=arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            ListNode c=merge(a,b);
            arr.add(c);
        }
        return arr.get(0);
    }
}