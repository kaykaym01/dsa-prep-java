package main.java.datastructures;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Represents a binary search tree with O(log n) access, insertion, and deletion
 */
public class BinarySearchTree {
    BSTNode root;
    int size;

    /**
     * Sets the root of the binary tree
     * @param root the root to be set
     */
    private void setRoot(BSTNode root){
        this.root = root;
    }

    /**
     * Checks if tree is empty
     * @return true if root is null, false otherwise
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Inserts a value in the binary search tree
     * @param value the value to be inserted
     */
    public void insert(int value){
        if (isEmpty()){
            setRoot(new BSTNode(value));
            size++;
        }
        else {
            if (value <= root.data){
                root.setLeft(insertRecursive(value, root.left));
            }
            else {
                root.setRight(insertRecursive(value, root.right));
            }
        }

    }

    /**
     * Helper function to insert new value recursively while maintaining
     * BST rule s.t. the values in all left subtrees are less than or equal
     * to the parent node and values in all right subtrees are greater
     * than the parent node
     * @param value value to be added
     * @param node node to be compared against
     * @return either a new node in the right position or the node whose child has been set
     */
    private BSTNode insertRecursive(int value, BSTNode node){
        if (node == null){
            size++;
            return new BSTNode(value);
        }
        else {
            if (value <= node.data){
                node.setLeft(insertRecursive(value, node.left));
            }
            else {
                node.setRight(insertRecursive(value, node.right));
            }
        }
        return node;
    }

    /**
     * Deletes node in the binary search tree with data value
     * @param value the value to be deleted
     */
    public void delete(int value){
        if (!isEmpty()){
            setRoot(deleteRecursive(value, root));
        }
    }

    /**
     * Helper function to search for and delete node with data value
     * @param value the value to be deleted
     * @param node the node to be searched
     * @return a BSTNode with the value removed from its tree
     */
    private BSTNode deleteRecursive(int value, BSTNode node){
        if (node == null) return root;
        else if (value < node.data){
            node.setLeft(deleteRecursive(value, node.left));
        }
        else if (value > node.data){
            node.setRight(deleteRecursive(value, node.right));
        }
        else {
            // case 1: no child
            if (node.left == null && node.right == null) {
                node = null;
            }
            // case 2: only right child
            else if (node.left == null){
                BSTNode temp = node;
                node = node.right;
                temp = null;
            }
            // case 3: only left child
            else if (node.right == null){
                BSTNode temp = node;
                node = node.left;
                temp = null;
            }
            // both children present
            else {
                BSTNode temp = findMinRecursive(node.right);
                node.data = temp.data;
                node.right = deleteRecursive(temp.data, node.right);
            }
        }
        return node;
    }

    /**
     * Gets the next number after val in an inorder traversal of the BST
     * @param val the value for which we want the successor
     * @return the first value larger than val in the tree, or null if
     * val is max value in tree
     */
    public Integer getInOrderSuccessor(int val){
        BSTNode successor = getSuccessor(root, val);
        if (successor != null){
            return successor.data;
        }
        return null;
    }

    /**
     * Gets the previous number before val in an inorder traversal of the BST
     * @param val the value for which we want the predecessor
     * @return the first value smaller than val in the tree, or null if
     * val is min value in tree
     */
    public Integer getInOrderPredecessor(int val){
        BSTNode predecessor = getPredecessor(root, val);
        if (predecessor != null){
            return predecessor.data;
        }
        return null;
    }

    private BSTNode getPredecessor(BSTNode node, int val){
        BSTNode current = searchRecursive(val, node);
        if (current == null) return null;

        // case 1, left subtree not empty
        // can return maximum of its left subtree
        if (current.left != null){
            return findMaxRecursive(current.left);
        }
        // case 2, left subtree is empty
        // need to find the nearest ancestor for which val is in
        // the ancestors right subtree
        else {
            BSTNode predecessor = null;
            BSTNode ancestor = node;
            while (ancestor != current){
                if (val > ancestor.data){
                    predecessor = ancestor;
                    ancestor = ancestor.right;
                } else {
                    ancestor = ancestor.left;
                }
            }
            return predecessor;
        }
    }

    /**
     * Helper function to find the in order successor of a value
     * @param node The node to start the search
     * @param val The value for which we want the successor
     * @return The node of the next successor
     */
    private BSTNode getSuccessor(BSTNode node, int val){
        // search the node
        BSTNode current = searchRecursive(val, node);
        if (current == null) return null;

        // case 1: node has right subtree, can get min of right subtree
        if (current.right != null){
            return findMinRecursive(current.right);
        }
        // case 2: node does not have right subtree
        // need to find the nearest ancestor for which val
        // would be in the left subtree
        else {
            BSTNode successor = null;
            BSTNode ancestor = node;
            while (ancestor != current){
                if (current.data < ancestor.data){
                    successor = ancestor;
                    ancestor = ancestor.left;
                }
                else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }

    }


    /**
     * Gets the height/max depth of the tree
     * @return the height/max depth of the tree
     */
    public int getTreeHeight(){
        return heightRecursive(root);
    }

    /**
     * Helper function to get the height of the BST
     * @param node the node whose subtrees will be checked
     * @return 1 + the max of the height of the two subtrees
     */
    private int heightRecursive(BSTNode node){
        if (node == null){
            return -1;
        }
        return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
    }



    /**
     * Restructures the Binary Search Tree so that it is a balanced tree
     */
    public void reBalance(){
        root.reBalance();
    }

    /**
     * Returns true if the value is in the tree
     * @param value the value to be searched
     * @return true if value is in tree, false otherwise
     */
    public boolean contains(int value){
        return containsRecursive(value, root) ;
    }

    /**
     * Helper function for determining if a value is already in the tree
     * @param value value to be searched for
     * @param node node to be compared against value
     * @return true if value is in tree, false otherwise
     */
    private boolean containsRecursive(int value, BSTNode node){
        if (node == null){
            return false;
        }
        if (node.data == value){
            return true;
        }
        else if (value < node.data){
            return containsRecursive(value, node.left);
        }
        else {
            return containsRecursive(value, node.right);
        }
    }

    /**
     * Returns the node in the tree with data value
     * @param value the value of the node
     * @param node the tree to search
     * @return BSTNode in tree with data value or null if not found
     */
    private BSTNode searchRecursive(int value, BSTNode node){
        if (node == null){
            return null;
        }
        if (node.data == value){
            return node;
        }
        else if (value < node.data){
            return searchRecursive(value, node.left);
        }
        else {
            return searchRecursive(value, node.right);
        }
    }

    /**
     * Gets the minimum value in the tree
     * @return the minimum value in the tree
     * @throws IOException if tree is empty
     */
    public int findMin() throws IOException {
        if (isEmpty())
            throw new IOException("Empty binary search tree has no minimum");
        return findMinRecursive(root).data;
    }

    /**
     * Gets the maximum value in the tree
     * @return the maximum value in the tree
     * @throws IOException if tree is empty
     */
    public int findMax() throws IOException {
        if (isEmpty())
            throw new IOException("Empty binary search tree has no maximum");
        return findMaxRecursive(root).data;
    }

    /**
     * Helper function to find the maximum value in a tree recursively
     * @param node the node to be checked for max value
     * @return the value of the farthest right node in the tree, the max
     */
    private BSTNode findMaxRecursive(BSTNode node){
        if (node.right != null){
            return findMaxRecursive(node.right);
        }
        return node;
    }

    /**
     * Helper function to find the minimum value in a tree recursively
     * @param node the node to be checked for min value
     * @return the value of the farthest left node in the tree, the min
     */
    private BSTNode findMinRecursive(BSTNode node){
        if (node.left != null){
            return findMinRecursive(node.left);
        }
        return node;
    }

    /**
     * Gets the inorder tree traversal
     * @return A String representation of inorder traversal of the tree
     */
    public String toInOrder(){
        return root.toInOrder();
    }

    /**
     * Gets the preorder tree traversal
     * @return A String representation of preorder traversal of the tree
     */
    public String toPreOrder(){
        return root.toPreOrder();
    }

    /**
     * Gets the postorder tree traversal
     * @return A String representation of postorder traversal of the tree
     */
    public String toPostOrder(){
        return root.toPostOrder();
    }

    /**
     * Gets the level order tree traversal (BFS)
     * @return A String representation of the level order traversal of the tree
     */
    public String toLevelOrder(){
        Queue<BSTNode> queue = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()){
            BSTNode currNode = queue.peek();
            result.append(currNode.data);
            result.append("  ");
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null){
                queue.add(currNode.right);
            }
            queue.remove();
        }
        return result.toString().trim();
    }

    /**
     * Gets the string representation of the tree
     * @return String representation of the tree
     */
    @Override
    public String toString(){
        return root.toString();
    }

    /**
     * A private BSTNode class to represent a node in a binary search tree
     * that can have at most 2 children
     */
    private static class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;

        /**
         * Creates a new BSTNode with data and no children
         * @param data the data to be set
         */
        public BSTNode(int data){
            this.data = data;
        }

        /**
         * Sets the left child of the node
         * @param left the new value of left child
         */
        public void setLeft(BSTNode left){
            this.left = left;
        }

        /**
         * Sets the right child of the node
         * @param right the new value of right child
         */
        public void setRight(BSTNode right) {
            this.right = right;
        }

        /**
         * restructures the binary search tree such that it is a balanced tree
         */
        public void reBalance(){

        }

        /**
         * Gets the inorder traversal of the tree
         * @return String with inorder traversal
         */
        public String toInOrder(){
            StringBuilder result = new StringBuilder();
            if (left != null){
                result.append(left.toInOrder());
                result.append(", ");
            }
            result.append(data);
            if (right != null){
                result.append(", ");
                result.append(right.toInOrder());
            }
            return result.toString();
        }

        /**
         * Gets the preorder traversal of the tree
         * @return String with preorder traversal
         */
        public String toPreOrder(){
            StringBuilder result = new StringBuilder();
            result.append(data);
            if (left != null){
                result.append(", ");
                result.append(left.toPreOrder());
            }
            if (right != null){
                result.append(", ");
                result.append(right.toPreOrder());
            }
            return result.toString();
        }


        /**
         * Gets the post order traversal of the tree
         * @return String with post order traversal
         */
        public String toPostOrder(){
            StringBuilder result = new StringBuilder();
            if (left != null){
                result.append(left.toPostOrder());
                result.append(", ");
            }
            if (right != null){
                result.append(right.toPostOrder());
                result.append(", ");
            }
            result.append(data);
            return result.toString();
        }

        /**
         * Gets the String representation of the BSTNode, including all descendants
         * @return String representation of BSTNode, including all descendants
         */
        @Override
        public String toString(){
            return Integer.toString(data);
        }


    }
}
