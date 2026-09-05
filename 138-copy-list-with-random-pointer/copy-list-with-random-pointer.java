class Solution {
    // Helper: create a deep copy of nodes (values only, no randoms yet)
    public Node deepcopy(Node head){
        Node dummy = new Node(-1);
        Node curr = head;
        Node t2 = dummy;
        while (curr != null) {
            Node temp = new Node(curr.val);
            t2.next = temp;
            t2 = t2.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper: interleave original and copy nodes
    private Node alterMerge(Node head1, Node head2) {
        Node d = new Node(-1); // dummy for merged list
        Node t = d;
        Node t1 = head1;
        Node t2 = head2;

        while (t1 != null && t2 != null) {
            t.next = t1;
            t1 = t1.next;
            t = t.next;

            t.next = t2;
            t2 = t2.next;
            t = t.next;
        }
        if (t1 != null) t.next = t1;
        if (t2 != null) t.next = t2;

        return d.next; // merged head
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: build copy list
        Node copyHead = deepcopy(head);

        // Step 2: interleave original and copy nodes
        Node mergedHead = alterMerge(head, copyHead);

        // Step 3: assign random pointers
        Node t1 = mergedHead;       // original
        Node t2 = mergedHead.next;  // copy
        while (t1 != null && t2 != null) {
            if (t1.random == null) {
                t2.random = null;
            } else {
                t2.random = t1.random.next; // copy’s random = original.random’s copy
            }
            t1 = (t1.next != null) ? t1.next.next : null;
            t2 = (t2.next != null) ? t2.next.next : null;
        }

        // Step 4: Separate the two lists
        Node d1 = new Node(-1); // original list dummy
        Node d2 = new Node(-1); // copy list dummy
        Node t1tail = d1;
        Node t2tail = d2;
        Node t = mergedHead;
        while (t != null && t.next != null) {
            t1tail.next = t;        // link original
            t = t.next;
            t2tail.next = t;        // link copy
            t = t.next;
            t1tail = t1tail.next;
            t2tail = t2tail.next;
        }
        t1tail.next = null;
        t2tail.next = null;

        return d2.next; // return head of copied list
    }
}
