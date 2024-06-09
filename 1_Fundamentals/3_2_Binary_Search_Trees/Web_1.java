/*
 * 1. The great tree-list recursion problem. 
 * A binary search tree and a circular doubly linked list are conceptually built from 
 * the same type of nodes - a data field and two references to other nodes. 
 * Given a binary search tree, rearrange the references so that it becomes a circular doubly-linked list (in sorted order). 
 * Nick Parlante describes this as one of the neatest recursive pointer problems ever devised. 
 * 
 * Hint: create a circularly linked list A from the left subtree, a circularly linked list B from the right subtree, 
 * and make the root a one node circularly linked list. Them merge the three lists.
 */

public class Web_1 {

    public static class BST<Key extends Comparable<Key>, Value> {
        public Node root; 
        public Node head;

        public class Node {
            public Key key;
            public Value val;
            public Node left, right;

            public Node(Key key, Value val) { 
                this.key = key; 
                this.val = val; 
            }
        }

        public void put(Key key, Value val) {
            if (root == null) {
                root = new Node(key, val);
                return;
            }
    
            Node current = root;
            while (current != null) {
                int cmp = key.compareTo(current.key);
                if (cmp == 0) {
                    current.val = val;
                    return;
                } 
                else if (cmp < 0) { 
                    if (current.left == null) {
                        current.left = new Node(key, val);
                        return;
                    }
                    current = current.left;
                } 
                else {
                    if (current.right == null) {
                        current.right = new Node(key, val);
                        return;
                    }
                    current = current.right;
                } 
            }
        }

        private void mergeCircularLists(Node headA, Node headB) {
            // keys of list A are smaller than keys of list B
            // so we need headA -> ... -> tailA -> headB -> ... -> tailB
            Node tailA = headA.left;
            Node tailB = headB.left;
            if (tailA == headB || tailB == headA) return; // they are already merged

            // headA's prev is tailB; tailA's next is headB
            // headB's prev is tailA; tailB's next is headA
            headA.left = tailB;
            tailA.right = headB;
            headB.left = tailA;
            tailB.right = headA;
        }

        private Node toCircularList(Node x) {
            if (x == null) return null;

            Node headA = toCircularList(x.left);
            Node headB = toCircularList(x.right);
            if (headA == null) headA = x;
            if (headB == null) headB = x;

            x.left = x;
            x.right = x;
            mergeCircularLists(headA, x); // now headA + x is one list with headA as the smallest key
            mergeCircularLists(headA, headB);

            return headA; // return head (smallest key) of the list
        }

        public void toCircularList() {
            this.head = toCircularList(root);
        }
    }

    public static void main(String[] args) {
        String s = "SEARCHEXAMPLE";
        BST<Character, Integer> bst = new BST<>();

        for (int i = 0; i < s.length(); i++) bst.put(s.charAt(i), i);
        bst.toCircularList();
        BST<Character, Integer>.Node current = bst.head;
        
        for (int n = 0; n < 2; n++) {
            for (int i = 0; i < 10; i++) {
                System.out.print(current.key + " ");
                current = current.right;
            }   
            System.out.println();
        }

        // Should print
        // A C E H L M P R S X twice
    }
}
