/*
 * Exercise 13. Give nonrecursive implementations of get(), put(), and keys() for BST.
 * 
 * Dependencies: Stack.java, Queue.java
 */

public class NonrecursiveBST<Key extends Comparable<Key>, Value> {

    private Node root; 

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;

        private Node(Key key, Value val) { 
            this.key = key; 
            this.val = val; 
        }
    }

    // Contructor - initiliaze an empty BST
    public NonrecursiveBST() {};

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

    /*
    public void put(Key key, Value val) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                current.val = val;
                return;
            } 
            else if (cmp < 0) current = current.left;
            else current = current.right;
        }
        current = new Node(key, val);
    }
     
    Why the code above does not work:
        root will always be null even if the last line executes.
        Suppose the BST is empty; i.e., root is null. Then when we assign current = root,
        current points to the same memory location as what root points to, and we get a null reference.
        It would seem like the last line would create a node for root, but it doesn't.
        When we create a new node using 'new Node(key, val)', a node object is created memory different to 
        where the root is pointing to. Then, when we assign that node to 'current', we are passing that new node
        reference to the VARIABLE current, not root. So, we would have to assign root = current.
        A similar problem occurrs in the while-loop.
    */

    public Value get(Key key) {
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) return current.val; 
            else if (cmp < 0) current = current.left;
            else current = current.right;
        }
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        // Since we can't use recursion, we will stack the nodes to simulate the call stack
        Stack<Node> stack = new Stack<>();

        Node current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                current = stack.pop();
                queue.enqueue(current.key);
                current = current.right;
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        String s = "SEARCHEXAMPLE";
        NonrecursiveBST<Character, Integer> bst = new NonrecursiveBST<>();

        for (int i = 0; i < s.length(); i++) bst.put(s.charAt(i), i);
        for (char c : bst.keys()) System.out.println(c + " " + bst.get(c));
    }
}
