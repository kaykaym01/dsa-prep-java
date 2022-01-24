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

    /**
     * Inserts new node with value data at index index
     * @param data the value of the new node
     * @param index the index to insert the new node
     */
    public void insertAtIndex(int data, int index){

        // insert at beginning index
        if (index == 0 || head == null) {
            insertAtHead(data);
            return;
        }
        if (index >= size){
            insertAtEnd(data);
            return;
        }

        int i = 0;
        Node currNode = head;
        // insert at index or at end if index > size of linkedlist
        while (i < index-1 && currNode.next != null){
            currNode = currNode.next;
            i++;
        }
        Node newNode = new Node(data);
        newNode.next = currNode.next;
        currNode.next = newNode;
        size++;
    }

    /**
     * Deletes the node at the head of the LinkedList
     */
    public void deleteAtHead(){
        if (!isEmpty()){
            head = head.next;
        }
        size--;
    }

    /**
     * Deletes the node at the end of the LinkedList
     */
    public void deleteAtEnd(){
        if (!isEmpty()){
            Node prevNode = null;
            Node currNode = head;
            while (currNode.next != null){
                prevNode = currNode;
                currNode = currNode.next;
            }
            prevNode.next = null;
        }
        size--;
    }

    /**
     * Deletes the node with value n in LinkedList
     * @param value the value to be removed from the list
     */
    public void delete(int value){
        if (isEmpty()){ return;}

        Node currNode = head;
        if (currNode.data == value) {
            deleteAtHead();
            size--;
            return;
        }

        while (currNode.next != null){
            if (currNode.next.data == value){
                currNode.next = currNode.next.next;
                size--;
            }
            currNode = currNode.next;
        }
    }

    /**
     * Deletes node i from the LinkedList
     * @param index the index of the node to be removed from the list
     */
    public void deleteAtIndex(int index){
        if (index == 0){
            deleteAtHead();
            size--;
            return;
        }

        Node currNode = head;
        int i = 1;
        while (i < index && currNode.next != null){
            currNode = currNode.next;
            i++;
        }

        currNode.next = currNode.next.next;
        size--;
    }

    /**
     * Checks if value n is in the linked list
     * @param n the value to search for
     * @return true if n in linked list, false if otherwise
     */
    public boolean contains(int n){
        return false;
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


    public void insertAt(int index, int value){
        head = insertAtRecursive(index, value, head);
    }

    private Node insertAtRecursive(int index, int value, Node curr){
        // base case: if index == 0
        if (index == 0 || curr == null){
            Node newNode = new Node(value);
            newNode.next = curr;
            return newNode;
        }

        // if index is not 0, keep going
        curr.next =  insertAtRecursive(--index, value, curr.next);
        return curr;
    }

    /**
     * Gets the size of the Linked List
     * @return An integer representing the size of the linked list
     */
    public int getSize() {
        return size;
    }

    public void insertUsingRecursion(int value, int index){
        head = insertUsingRecursion(index, value, head);
    }

    private Node insertUsingRecursion(int index, int value, Node nextNode){
        if (index == 0){
            Node newNode = new Node(value);
            newNode.next = nextNode;
            size++;
            return newNode;
        }
        nextNode.next = insertUsingRecursion(--index, value, nextNode.next);
        return nextNode;
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