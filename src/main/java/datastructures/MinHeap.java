package main.java.datastructures;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;
    int[] heap;

    public MinHeap(){
        heap = new int[capacity];
    }

    private int getLeftChildIndex(int parentIndex){return (parentIndex*2)+1;}
    private int getRightChildIndex(int parentIndex){return (parentIndex*2)+2;}
    private int getParentIndex(int childIndex){return (childIndex-2)/2;}

    private boolean hasLeftChild(int index){return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index){return getRightChildIndex(index) < size;}
    private boolean hasParent(int index){return getParentIndex(index) >= 0;}

    private int leftChild(int index){return heap[getLeftChildIndex(index)];}
    private int rightChild(int index){return heap[getRightChildIndex(index)];}
    private int parent(int index) {return heap[getParentIndex(index)];}

    public int peek(){
        if (size == 0) throw new IllegalStateException();
        return heap[0];
    }

    public int poll(){
        if (size == 0) throw new IllegalStateException();
        int item = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureExtraCapacity();
        heap[size++] = item;
        heapifyUp();
    }

    private void heapifyDown(){
        int currentTop = 0;
        while (hasLeftChild(currentTop)){
            int smallerChildIndex = getLeftChildIndex(currentTop);
            if (hasRightChild(currentTop) && rightChild(currentTop) < leftChild(currentTop)){
                smallerChildIndex = getRightChildIndex(currentTop);
            }

            if (heap[currentTop] < heap[smallerChildIndex]){
                break;
            } else {
                swap(heap, currentTop, smallerChildIndex);
            }
            currentTop = smallerChildIndex;
        }
    }

    // parent = (index-2)/2
    // leftChild = (index*2) + 1
    // rightChild = (index*2) + 2

    private void heapifyUp(){
        int lastAdded = size-1;
        while (hasParent(lastAdded) && heap[lastAdded] < parent(lastAdded )){
            swap(heap, lastAdded, getParentIndex(lastAdded));
            lastAdded = getParentIndex(lastAdded);
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void ensureExtraCapacity(){
        if (capacity == size){
            capacity *= 2;
            int[] newHeap = new int[capacity];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
    }


}
