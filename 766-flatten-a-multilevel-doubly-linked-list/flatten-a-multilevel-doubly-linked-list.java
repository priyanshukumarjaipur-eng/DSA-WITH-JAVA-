class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        flattenDFS(head);
        return head;
    }

    private Node flattenDFS(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            // If current node has a child, flatten it
            if (curr.child != null) {
                Node childHead = curr.child;
                Node childTail = flattenDFS(childHead);

                // Connect curr with childHead
                curr.next = childHead;
                childHead.prev = curr;

                // Connect childTail with next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                // Clear child pointer
                curr.child = null;
                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }
        return last;
    }
}
