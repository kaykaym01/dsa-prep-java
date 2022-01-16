package test.java.algorithms.sorting;

import main.java.algorithms.sorting.Sorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
    int[] arr;
    int[] sortedArr;
    int[] emptyArr;
    int[] singleArr;
    int[] sortedEmptyArr;
    int[] sortedSingleArr;

    @BeforeEach
    void setUp() {
        arr = new int[]{1, 20, -5, 12, 7, 10};
        sortedArr = new int[]{-5, 1, 7, 10, 12, 20};
        emptyArr = new int[0];
        singleArr = new int[]{1};
        sortedEmptyArr = new int[0];
        sortedSingleArr = new int[]{1};
    }

    @Test
    void bubbleSort() {
        Sorter.bubbleSort(arr);
        assertArrayEquals(sortedArr, arr);

        Sorter.bubbleSort(emptyArr);
        assertArrayEquals(sortedEmptyArr, emptyArr);

        Sorter.bubbleSort(singleArr);
        assertArrayEquals(sortedSingleArr, singleArr);
    }

    @Test
    void insertionSort() {
        Sorter.insertionSort(arr);
        assertArrayEquals(sortedArr, arr);

        Sorter.insertionSort(emptyArr);
        assertArrayEquals(sortedEmptyArr, emptyArr);

        Sorter.insertionSort(singleArr);
        assertArrayEquals(sortedSingleArr, singleArr);
    }

    @Test
    void selectionSort() {
        Sorter.selectionSort(arr);
        assertArrayEquals(sortedArr, arr);

        Sorter.selectionSort(emptyArr);
        assertArrayEquals(sortedEmptyArr, emptyArr);

        Sorter.selectionSort(singleArr);
        assertArrayEquals(sortedSingleArr, singleArr);
    }

    @Test
    void mergeSort() {
        assertArrayEquals(sortedArr, Sorter.mergeSort(arr,  arr.length));

        assertArrayEquals(sortedEmptyArr, Sorter.mergeSort(emptyArr,  emptyArr.length));

        assertArrayEquals(sortedSingleArr, Sorter.mergeSort(singleArr, singleArr.length));
    }

    @Test
    void quickSort() {
        Sorter.quickSort(arr);
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    void heapSort() {
        Sorter.heapSort(arr);
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    void radixSort() {
        Sorter.radixSort(arr);
        assertArrayEquals(sortedArr, arr);
    }
}