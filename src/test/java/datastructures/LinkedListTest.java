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

}