package main.java.datastructures;

/**
 *
 */
public class LinkedList {

    private Node head;
    private int size;

    public boolean isEmpty(){
        return head == null;
    }

    public void insertAtHead(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

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

    public int getSize() {
        return size;
    }

    private static class Node{
        Node next;
        int data;

        public Node (int data){
            this.data = data;
        }
    }


}