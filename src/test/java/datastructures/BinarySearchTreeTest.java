package test.java.datastructures;

import main.java.datastructures.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree();
    }

    @Test
    void testInsert() {
        bst.insert(5);
        bst.insert(4);
        bst.insert(6);
        bst.insert(2);
        bst.insert(3);
        bst.insert(7);

        assertEquals("5, 4, 2, 3, 6, 7", bst.toPreOrder());
        assertEquals("2, 3, 4, 5, 6, 7", bst.toInOrder());
        assertEquals("3, 2, 4, 7, 6, 5", bst.toPostOrder());
        assertEquals("5  4  6  2  7  3", bst.toLevelOrder());
    }

    @Test
    void testGetTreeHeight(){
        //empty tree has height -1
        assertEquals(-1, bst.getTreeHeight());

        // tree with single element has height 0
        bst.insert(5);
        assertEquals(0, bst.getTreeHeight());

        // tree height should be 2 since node 7 is 2 edges from root
        bst.insert(4);
        bst.insert(6);
        bst.insert(7);
        assertEquals(2, bst.getTreeHeight());

    }

    @Test
    void testIsEmpty() {
        assertTrue(bst.isEmpty());
        bst.insert(5);
        assertFalse(bst.isEmpty());
    }

    @Test
    void testDelete() {
        // delete should handle empty tree
        assertDoesNotThrow(() ->bst.delete(9));

        // delete only node in tree
        bst.insert(12);
        assertTrue(bst.contains(12));
        bst.delete(12);
        assertFalse(bst.contains(12));
        assertTrue(bst.isEmpty());

        bst.insert(12);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(13);
        bst.insert(17);
        bst.insert(1);
        bst.insert(9);
        bst.insert(19);

        // delete leaf node
        assertTrue(bst.contains(19));
        bst.delete(19);
        assertFalse(bst.contains(19));

        // delete internal node
        assertTrue(bst.contains(5));
        bst.delete(5);
        assertFalse(bst.contains(5));

        // delete root node
        assertTrue(bst.contains(12));
        bst.delete(12);
        assertFalse(bst.contains(12));
    }


    @Test
    void testGetInorderSuccessor(){
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(8);
        bst.insert(12);
        bst.insert(17);
        bst.insert(25);
        bst.insert(6);
        bst.insert(11);
        bst.insert(16);
        bst.insert(27);

        assertNull(bst.getInOrderSuccessor(27));
        assertEquals(8, bst.getInOrderSuccessor(6));
        assertEquals(15, bst.getInOrderSuccessor(12));
        assertEquals(27, bst.getInOrderSuccessor(25));
        assertNull(bst.getInOrderSuccessor(30));
    }

    @Test
    void testGetInOrderPredecessor(){
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(8);
        bst.insert(12);
        bst.insert(17);
        bst.insert(25);
        bst.insert(6);
        bst.insert(11);
        bst.insert(16);
        bst.insert(27);

        assertNull(bst.getInOrderPredecessor(6));
        assertEquals(8, bst.getInOrderPredecessor(10));
        assertEquals(15, bst.getInOrderPredecessor(16));
        assertEquals(25, bst.getInOrderPredecessor(27));
        assertNull(bst.getInOrderPredecessor(30));
    }

    @Test
    void testFindMin() throws IOException {
        Exception e = assertThrows(IOException.class, () -> bst.findMin());
        assertEquals("Empty binary search tree has no minimum", e.getMessage());

        bst.insert(5);
        bst.insert(4);
        bst.insert(6);

        assertEquals(4, bst.findMin());
    }

    @Test
    void testFindMax() throws IOException {
        Exception e = assertThrows(IOException.class, () -> bst.findMax());
        assertEquals("Empty binary search tree has no maximum", e.getMessage());

        bst.insert(5);
        bst.insert(4);
        bst.insert(6);

        assertEquals(6, bst.findMax());
    }

    @Test
    void testContains() {
        // contains run on empty list should always return false
        assertFalse(bst.contains(9));

        bst.insert(5);
        bst.insert(4);
        bst.insert(6);

        //9 still not in list
        assertFalse(bst.contains(9));

        // inserted elements should be in list
        assertTrue(bst.contains(4));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(6));
    }
}