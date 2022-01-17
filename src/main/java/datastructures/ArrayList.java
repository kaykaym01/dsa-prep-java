package main.java.datastructures;

/**
 * Represents a dynamically allocated array, an ArrayList
 */
public class ArrayList {

    private int capacity;
    private int[] arr;
    private int size;

    public ArrayList(){
        capacity = 5;
        arr = new int[capacity];
    }

    /**
     * Gets the capacity of the arraylist
     * @return capacity of arraylist
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the number of elements in the array list
     * @return total number of elements in the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Checks if element is in array list
     * @param x the element to search for
     * @return true if element is present, false if otherwise
     */
    public boolean contains(int x){
        return search(x) != -1;
    }

    /**
     * Checks if array list is full
     * @return true if size == capacity, false if otherwise
     */
    public boolean isFull(){
        return capacity == size;
    }

    /**
     * Checks if array list is empty
     * @return true if size == 0, false if otherwise
     */
    public boolean isEmpty(){
        return size ==0;
    }

    /**
     * Inserts new element into array list
     * if underlying array is full, will double capacity so that
     * new elements can be added
     * @param x the new element to insert into the array list
     */
    public void insert(int x){
        if (isFull()){
            capacity *= 2;
            int[] newArray = new int[capacity];
            copyOver(newArray, arr);
            arr = newArray;
        }
        arr[size++] = x;
    }

    /**
     * Copies all elements in array 2 into array 1
     * @param arr1 array to move elements to
     * @param arr2 array to copy elements from
     */
    private void copyOver(int[] arr1, int[] arr2){
        System.arraycopy(arr2, 0, arr1, 0, arr2.length);
    }

    /**
     * Removes element with value x
     * @param x the element to remove
     * @return true if element was removed, false if otherwise
     */
    public boolean remove(int x){
        boolean found = false;
        int p1 = 0;
        for (int p2 = 0; p2 < arr.length; p2++){
            if (arr[p2] == x){
                p1 = p2;
                found = true;
                size--;
            }
            else {
                arr[p1] = arr[p2];
                p1++;
            }
        }
        return found;
    }

    /**
     * Finds index of element x in arraylist, returns -1 if not found
     * @param x element to look for
     * @return index of element x in array list, -1 if not found
     */
    public int search(int x){
        int index = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == x){
                index = i;
                return index;
            }
        }
        return index;
    }

    /**
     * Gets the String representation of the array list
     * @return String representation of the array list
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size-1; i++){
            result.append(arr[i]);
            result.append(", ");
        }
        result.append(arr[size - 1]);
        result.append("]");
        return result.toString();
    }
}
