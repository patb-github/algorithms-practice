/*
 * 2. BST reconstruction. Given the preorder traversal of a BST (not including null nodes), reconstruct the tree.
 * 
 * I will assume that our tree has distinct keys.
 * A preorder traversal is done by visiting the root, then the left subtree, and then the right subtree.
 * In my original solution, I simply added the nodes in the preorder to the BST. However, this problem more likely
 * requires us to use pointers like the one here:
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Web_2X {
    
    private Node root; 
    public static class Node<Key extends Comparable<Key>> {
        Key key;
        Node<Key> left, right;

        Node(Key key) { 
            this.key = key; 
        }

        Node(Key key, Node<Key> left, Node<Key> right) { 
            this.key = key; 
            this.left = left;
            this.right = right;
        }
    }

    private void preorderTraversal(List<Node> queue, Node node) {
        if (node == null) return;

        queue.add(node);
        preorderTraversal(queue, node.left);
        preorderTraversal(queue, node.right);
    }

    // perform preorder traversal for checking
    public Iterable<Node> preorderTraversal() {
        List<Node> queue = new ArrayList<>();
        preorderTraversal(queue, root);
        return queue;
    }

    private Node bstFromPreorder(Node x, Stack<Comparable> stack) {
        if (stack.empty()) return null;

        // A preorder traversal is done by visiting the root, then the left subtree, and then the right subtree.
        // So we first create the root node
        x = new Node(stack.pop());

        // then create the left subtree if it exists
        if (!stack.empty() && stack.peek().compareTo(x.key) < 0) {
            x.left = bstFromPreorder(x.left, stack);
        } 
        // then create the right subtree if it exists
        if (!stack.empty() && stack.peek().compareTo(x.key) > 0) {
            x.right = bstFromPreorder(x.right, stack);
        } 

        return x;
    }
    
    public void bstFromPreorder(Comparable[] preorder) {
        if (preorder.length == 0) throw new IllegalArgumentException("preorder cannot be empty");

        // Would rather use a Queue, but Java does not have a Queue class
        // so we use a reversed stack
        Stack<Comparable> stack = new Stack<>();
        for (int i = preorder.length - 1; i >= 0; i--) stack.push(preorder[i]);

        root = bstFromPreorder(root, stack);
    }

    public static void main(String[] args) {
        Integer[] preorder = {100, 20, 10, 30, 200, 150, 300};

        Web_2X test = new Web_2X();
        test.bstFromPreorder(preorder);

        for (Node<Integer> x : test.preorderTraversal()) {
            System.out.println(x.key);
        }
    }
}
