package test.java.datastructures;

import main.java.datastructures.MinHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinHeapTest {
    MinHeap minHeap;
    @BeforeEach
    void setUp(){
        minHeap = new MinHeap();
    }

    @Test
    void addTest(){
        minHeap.add(10);
        minHeap.add(15);
        minHeap.add(20);
        minHeap.add(17);
        minHeap.add(25);

        assertEquals(10, minHeap.peek());
    }

    @Test
    void pollTest(){
        minHeap.add(10);
        minHeap.add(15);
        minHeap.add(20);
        minHeap.add(17);
        minHeap.add(25);
        assertEquals(10, minHeap.poll());
        assertEquals(15, minHeap.poll());
        assertEquals(17, minHeap.poll());
        assertEquals(20, minHeap.poll());
        assertEquals(25, minHeap.poll());



    }
}
