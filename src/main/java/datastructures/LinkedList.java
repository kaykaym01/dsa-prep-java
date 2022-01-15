package main.java.datastructures;

/**
 * Represents a linked list
 */
public class LinkedList {

    private Node head;
    private int size;

    /**
     * Returns true if there are no elements in the linked list
     * @return true if linked list is empty, false otherwise
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Adds a new node to the head of the Linked List
     * @param data the data in the new node
     */
    public void insertAtHead(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Adds a new node to the end of the Linked List
     * @param data the data in the new node
     */
    public void insertAtEnd(int data){
        if (isEmpty()){
            head = new Node(data);
            size++;
            return;
        }

        Node currNode = head;
        while (currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = new Node(data);
        size++;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        Node currNode = head;

        result.append("{");
        while (currNode.next != null){
            result.append(currNode.data);
            result.append(" -> ");
            currNode = currNode.next;
        }
        result.append(currNode.data);
        result.append("}");
        return result.toString();
    }

    /**
     * Gets the size of the Linked List
     * @return An integer representing the size of the linked list
     */
    public int getSize() {
        return size;
    }

    /**
     * Simple class to represent a Node in the LinkedList
     */
    private static class Node{
        Node next;
        int data;

        public Node (int data){
            this.data = data;
        }
    }


}