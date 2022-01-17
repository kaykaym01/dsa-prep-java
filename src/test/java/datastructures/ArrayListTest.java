package test.java.datastructures;

import main.java.datastructures.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    ArrayList arrayList;

    @BeforeEach
    void setUp(){
        arrayList =  new ArrayList();
    }


    @Test
    void insert() {
        // arraylist is empty at first
        assertTrue(arrayList.isEmpty());
        assertFalse(arrayList.contains(19));

        //array list is no longer empty
        arrayList.insert(19);
        assertFalse(arrayList.isEmpty());
        assertTrue(arrayList.contains(19));

        arrayList.insert(34);
        assertTrue(arrayList.contains(34));

        arrayList.insert(22);
        assertTrue(arrayList.contains(22));

        arrayList.insert(25);
        assertTrue(arrayList.contains(25));


        // arraylist has 4 elements
        assertEquals(4, arrayList.getSize());

        // arraylist has less than 5 elements, so is not full
        assertFalse(arrayList.isFull());
        arrayList.insert(-1);
        assertTrue(arrayList.contains(-1));


        //arraylist now has 5 elements, so is full
        assertTrue(arrayList.isFull());

        assertFalse(arrayList.contains(100));

        // array list was full, so capacity will now double
        arrayList.insert(100);
        assertTrue(arrayList.contains(100));


        // array list now has 6 elements
        assertEquals(6, arrayList.getSize());
        assertEquals(10, arrayList.getCapacity());

        // array list should no longer be full since size < capacity
        assertFalse(arrayList.isFull());

        // array should have all 6 elements
        assertEquals("[19, 34, 22, 25, -1, 100]", arrayList.toString());
    }

    @Test
    void remove() {
        // arraylist is empty at first
        assertTrue(arrayList.isEmpty());
        assertFalse(arrayList.contains(19));

        //array list is no longer empty
        arrayList.insert(19);
        assertEquals(1, arrayList.getSize());
        assertFalse(arrayList.isEmpty());
        assertTrue(arrayList.contains(19));

        // remove only element in list, so now is empty
        arrayList.remove(19);
        assertTrue(arrayList.isEmpty());
        assertFalse(arrayList.contains(19));

        arrayList.insert(34);
        arrayList.insert(22);
        arrayList.insert(25);

        // arraylist has 3 elements
        assertEquals(3, arrayList.getSize());

        // removing element not in array should not decrease size
        assertFalse(arrayList.remove(-1));
        assertEquals(3, arrayList.getSize());

        assertTrue(arrayList.contains(22));
        arrayList.remove(22);
        assertFalse(arrayList.contains(22));
        assertEquals(2, arrayList.getSize());

        // array should have all 6 elements
        assertEquals("[34, 25]", arrayList.toString());
    }
}