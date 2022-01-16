package main.java.algorithms.sorting;

import java.util.Arrays;

/**
 *
 */
public class Sorter {
    /**
     * Implements a bubble sort on array arr
     * O(n^2)
     * @param arr the array to sort
     */
    public static void bubbleSort(int[] arr){
        for (int i = arr.length -1; i >= 0; i--){
            int bub1 = 0;
            int bub2 = 1;
            while (bub2 <= i){
                if (arr[bub1] > arr[bub2]){
                    int temp = arr[bub1];
                    arr[bub1] = arr[bub2];
                    arr[bub2] = temp;
                }
                bub1++;
                bub2++;
            }
        }
    }

    /**
     * Implements an insertion sort on array arr
     * O(n^2)
     * @param arr the array to sort
     */
    public static void insertionSort(int[] arr){
        for (int i =1; i < arr.length; i++){
            int j = i;
            while (j >= 1 && arr[j] < arr[j-1]){
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                j--;
            }
        }

    }

    /**
     * Implements a selection sort on array arr
     * O(n^2)
     * @param arr the array to sort
     */
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int min = Integer.MAX_VALUE;
            int minInd = 0;
            for (int j = i; j < arr.length; j++){
                if (arr[j] <= min){
                    min = arr[j];
                    minInd = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }

    }


    /**
     * Helper merge function used to merge two sorted arrays, arr1 and arr2
     * @param arr1 array to merge
     * @param m length of arr1
     * @param arr2 array to merge
     * @param n length of arr2
     * @return a sorted array of length m+n with elements of both arr1 and arr2
     */
    private static int[] merge(int[] arr1, int m, int[] arr2, int n){

        /* pseudocode
         * result = new array with length a.len + b.len
         *
         * while (a and b have elements)
         * if (a[0] < b[0])
         *  add a[0] to c
         *  remove a[0] from a
         * else
         *  add b[0] to c
         *  remove b[0] from b
         *
         *  while (a has elements)
         *      add a[0] to c
         *      remove a[0] from a
         *
         *  while (b has elements)
         *      add b[0] to c
         *      remove b[0] from b
         */

        int[] result = new int[m+n];
        int p1 = 0;
        int p2 = 0;
        int i = 0;

        while (p1 < m && p2 < n){
            result[i++] = (arr1[p1] < arr2[p2])?arr1[p1++]:arr2[p2++];
        }

        while (p1 < m){
            result[i++] = arr1[p1++];
        }

        while (p2 < n){
            result[i++] = arr2[p2++];
        }

        return result;

    }

    /**
     * Implements a merge sort on array arr
     * O(n log n)
     * @param arr the array to sort
     * @param n length of arr
     * @return a sorted array
     */
    public static int[] mergeSort(int[] arr, int n){

        /* pseudocode
         * if (n ==1 ) return arr
         *
         * left = arr[0]...arr[n/2]
         * right = arr[n/2 + 1]...arr[n]
         *
         * left = mergesort(left)
         * right = mergesort(right)
         *
         * return merge(l1, l2)
         */

        if (n <= 1){
            return arr;
        }

        int[] left = Arrays.copyOfRange(arr, 0, n/2);
        int[] right = Arrays.copyOfRange(arr, (n/2), n);

        int[] sortedLeft = mergeSort(left, left.length);
        int[] sortedRight = mergeSort(right, right.length);

        return merge(sortedLeft, left.length, sortedRight, right.length);

        // divide
        //keep dividing until length <= 1
    }

    private static void partition(){

    }

    /**
     * Implements a quick sort on arry arr
     * O(n log n)
     * @param arr the array to sort
     */
    public static void quickSort(int[] arr){

    }

    /**
     * Implements a heap sort on array arr
     * O()
     * @param arr the array to sort
     */
    public static void heapSort(int[] arr){

    }

    /**
     * Implements a radix sort on array arr
     * O()
     * @param arr the array to sort
     */
    public static void radixSort(int[] arr){

    }

}
