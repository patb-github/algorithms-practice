/*
 * 2. BST reconstruction. Given the preorder traversal of a BST (not including null nodes), reconstruct the tree.
 * 
 * A preorder traversal is done by visiting the root, then the left subtree, and then the right subtree.
 */

import java.util.ArrayList;
import java.util.List;

public class Web_2 {
    
    public static class ReconstructedBST<Key extends Comparable<Key>> {
        private Node root; 
        private class Node {
            private Key key;
            private Node left, right;

            private Node(Key key) { 
                this.key = key; 
            }
        }
        
        // Constructs the bst from the preorder traversal
        public ReconstructedBST(Iterable<Key> preorder) {
            root = null;
            for (Key key : preorder) put(key);
        };

        public void put(Key key) {
            if (root == null) {
                root = new Node(key);
                return;
            }
    
            Node current = root;
            while (current != null) {
                int cmp = key.compareTo(current.key);
                if (cmp == 0) return;
                else if (cmp < 0) { 
                    if (current.left == null) {
                        current.left = new Node(key);
                        return;
                    }
                    current = current.left;
                } 
                else {
                    if (current.right == null) {
                        current.right = new Node(key);
                        return;
                    }
                    current = current.right;
                } 
            }
        }

        private void preorderTraversal(List<Key> queue, Node node) {
            if (node == null) return;

            queue.add(node.key);
            preorderTraversal(queue, node.left);
            preorderTraversal(queue, node.right);
        }

        // perform preorder traversal for checking
        public Iterable<Key> preorderTraversal() {
            List<Key> queue = new ArrayList<>();
            preorderTraversal(queue, root);
            return queue;
        }

    }
    public static void main(String[] args) {
        int[] preorderArray = {100, 20, 10, 30, 200, 150, 300};
        ArrayList<Integer> preorder = new ArrayList<>();
        for (int x : preorderArray) preorder.add(x);
        System.out.println(preorder);
        
        ReconstructedBST<Integer> bst = new ReconstructedBST<>(preorder);
        Iterable<Integer> bstPreorder = bst.preorderTraversal();
        System.out.println(bstPreorder);
    }

}
