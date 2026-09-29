/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class pair{
    Node node;
    int level;
    pair(Node node,int level){
        this.node=node;
        this.level=level;
    }
}
class Solution {

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0));
        int currlevel=0;
        while(!q.isEmpty()){
            int lsize=q.size();
            for(int i=0;i<lsize;i++){
                pair curr=q.remove();
                if (curr.node == null) {
                    continue;
                }
                if(curr.level!=currlevel) currlevel=curr.level;
                if(q.peek()!=null && q.peek().level==currlevel){
                    curr.node.next=q.peek().node;
                }
                else{
                    curr.node.next=null;
                }
                if(curr.node.left!=null) q.add(new pair(curr.node.left,curr.level+1));
                if(curr.node.right!=null) q.add(new pair(curr.node.right,curr.level+1));
            }
        }
        return root;
    }
}