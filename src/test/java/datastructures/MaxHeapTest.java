package test.java.datastructures;

import main.java.datastructures.MaxHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    MaxHeap maxHeap;

    @BeforeEach
    void setUp() {
        maxHeap = new MaxHeap();
    }

    @Test
    void add() {
        maxHeap.add(10);
        maxHeap.add(15);
        maxHeap.add(20);
        maxHeap.add(17);
        maxHeap.add(25);

        assertEquals(25, maxHeap.peek());
    }

    @Test
    void poll() {
        maxHeap.add(10);
        maxHeap.add(15);
        maxHeap.add(20);
        maxHeap.add(17);
        maxHeap.add(25);

        assertEquals(25, maxHeap.poll());
        assertEquals(20, maxHeap.poll());
        assertEquals(17, maxHeap.poll());
        assertEquals(15, maxHeap.poll());
        assertEquals(10, maxHeap.poll());

    }
}