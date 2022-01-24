package main.java.datastructures;

public class MaxHeap {
    int capacity = 10;
    int size = 0;
    int[] heap;

    public MaxHeap(){
        heap = new int[capacity];
    }

    // get left child, parent, right child index
    private int getLeftChildIndex(int index){return (2*index)+1;}
    private int getRightChildIndex(int index){return (2*index)+2;}
    private int getParentIndex(int index){return (index-2)/2;}

    // hasparent, hasleft child, has right child
    private boolean hasLeftChild(int index){return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index){return getRightChildIndex(index) < size;}
    private boolean hasParent(int index){return getParentIndex(index) >= 0;}

    // get left child, parent, right child
    private int leftChild(int index){return heap[getLeftChildIndex(index)];}
    private int rightChild(int index){return heap[getRightChildIndex(index)];}
    private int parent(int index){return heap[getParentIndex(index)];}

    public void add(int value){
        ensureCapacity();
        heap[size++] = value;
        heapifyUp();
    }

    public int peek(){
        return heap[0];
    }

    public int poll(){
        int item = heap[0];
        heap[0] = heap[--size];
        heapifyDown();
        return item;
    }

    private void ensureCapacity(){
        if (size == capacity){
            capacity *= 2;
            int[] newHeap = new int[capacity];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
    }

    private void heapifyDown(){
        int newMaxIndex = 0;

        while (hasLeftChild(newMaxIndex)){
            int greaterChildIndex = getLeftChildIndex(newMaxIndex);
            if (hasRightChild(newMaxIndex) && rightChild(newMaxIndex) > heap[greaterChildIndex]){
                greaterChildIndex = getRightChildIndex(newMaxIndex);
            }
            if (heap[greaterChildIndex] > heap[newMaxIndex]){
                swap(heap, greaterChildIndex, newMaxIndex);
                newMaxIndex = greaterChildIndex;
            } else{
                break;
            }
        }
    }

    private void heapifyUp(){
        int lastAddedIndex = size-1;
        while (hasParent(lastAddedIndex) && parent(lastAddedIndex) < heap[lastAddedIndex]){
            swap(heap, getParentIndex(lastAddedIndex), lastAddedIndex);
            lastAddedIndex = getParentIndex(lastAddedIndex);
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
