package test.java.datastructures;
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.datastructures.LinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class LinkedListTest {

    LinkedList ll;

    @BeforeEach
    void setUp(){
        ll = new LinkedList();
    }

    @Test
    @DisplayName("Inserting at head should work ")
    void insertAtHeadTest() {
        assertEquals(0, ll.getSize());

        ll.insertAtHead(1);
        ll.insertAtHead(2);
        ll.insertAtHead(3);
        ll.insertAtHead(4);
        assertEquals(4, ll.getSize());

        String expectedResult = "{4 -> 3 -> 2 -> 1}";
        assertEquals(expectedResult, ll.toString());
    }

    @Test
    @DisplayName("Inserting at end should work ")
    void insertAtEndTest() {
        assertEquals(0, ll.getSize());

        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        assertEquals(4, ll.getSize());

        String expectedResult = "{1 -> 2 -> 3 -> 4}";
        assertEquals(expectedResult, ll.toString());
    }

    @Test
    void insertAtIndexTest(){
        assertEquals(0, ll.getSize());
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);

        // insert at head
        ll.insertAtIndex(17, 0);
        String expectedResult = "{17 -> 1 -> 2 -> 3 -> 4}";
        assertEquals(expectedResult, ll.toString());

        // insert in middle
        ll.insertAtIndex(19, 2);
        expectedResult = "{17 -> 1 -> 19 -> 2 -> 3 -> 4}";
        assertEquals(expectedResult, ll.toString());

        // insert at end
        ll.insertAtIndex(25, 6);
        expectedResult = "{17 -> 1 -> 19 -> 2 -> 3 -> 4 -> 25}";
        assertEquals(expectedResult, ll.toString());

        // insert far beyond end
        ll.insertAtIndex(101, 100);
        expectedResult = "{17 -> 1 -> 19 -> 2 -> 3 -> 4 -> 25 -> 101}";
        assertEquals(expectedResult, ll.toString());
    }

    @Test
    void deleteAtIndexTest() {
        assertEquals(0, ll.getSize());
        ll.insertAtEnd(0);
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(7);
        ll.insertAtEnd(4);

        // delete at head
        ll.deleteAtIndex(0);
        String expectedResult = "{1 -> 2 -> 3 -> 7 -> 4}";
        assertEquals(expectedResult, ll.toString());

        // delete in middle
        ll.deleteAtIndex(2);
        expectedResult = "{1 -> 2 -> 7 -> 4}";
        assertEquals(expectedResult, ll.toString());

        // delete value
        ll.delete(7);
        expectedResult = "{1 -> 2 -> 4}";
        assertEquals(expectedResult, ll.toString());

        // delete at end
        ll.deleteAtIndex(2);
        expectedResult = "{1 -> 2}";
        assertEquals(expectedResult, ll.toString());
    }

    @Test
    void insertUsingRecursionTest(){
        assertEquals(0, ll.getSize());
        ll.insertAtEnd(0);
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);

        ll.insertUsingRecursion(24, 3);
        String expectedResult = "{0 -> 1 -> 2 -> 24 -> 3 -> 4}";
        assertEquals(expectedResult, ll.toString());
    }
}