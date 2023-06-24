package org.example.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Objects;

class SinglyLinkedListTest {

    @Test
    void addElement() {
        // GIVEN
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A");
        if (!Objects.equals(list.toString(), "A")) {
            throw new NoSuchElementException("""
                    After creation a list with root element with value "A", toString() should return "A".""");
        }

        // WHEN
        list.addElement("B");

        // THEN
        Assertions.assertEquals("A, B", list.toString());
    }

    @Test
    void toStringOneItemList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A");
        Assertions.assertEquals("A", list.toString());
    }

    @Test
    void toStringThreeItemsList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A")
                .addElement("B")
                .addElement("C");

        Assertions.assertEquals("A, B, C", list.toString());
    }

    @Test
    void toStringEmptyList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A").flush();
        Assertions.assertEquals("List is empty", list.toString());
    }

    @Test
    void toStringListOfNulls() {
        SinglyLinkedList<Object> list = new SinglyLinkedList<>(null)
                .addElement(null);
        Assertions.assertEquals("Null, Null", list.toString());
    }

    @Test
    void flush() {
        // GIVEN
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A");

        // WHEN
        list.flush();

        //THEN
        Assertions.assertEquals("List is empty", list.toString());
    }

    @Test
    void removeCentralNodeFromListOfTreeNodes() {
        // GIVEN
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A")
                .addElement("B")
                .addElement("C");
        if (!Objects.equals(list.toString(), "A, B, C")) {
            throw new NoSuchElementException("""
                    After creation a list of three nodes with values A, B, C toString() should return "A, B, C".""");
        }

        // WHEN
        list.removeCentralNode();

        //THEN
        Assertions.assertEquals("A, C", list.toString());
    }

    @Test
    void removeCentralNodeFromListOfFourNodes() {
        // GIVEN
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A")
                .addElement("B")
                .addElement("C")
                .addElement("D");
        if (!Objects.equals(list.toString(), "A, B, C, D")) {
            throw new NoSuchElementException("""
                    After creation a list of four nodes with values A, B, C, D\s
                    toString() should return "A, B, C, D".""");
        }

        // WHEN
        list.removeCentralNode();

        //THEN
        Assertions.assertEquals("A, D", list.toString());
    }

    @Test
    void removeCentralNodeFromListOfOneNodes() {
        // GIVEN
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A");
        if (!Objects.equals(list.toString(), "A")) {
            throw new NoSuchElementException("""
                    After creation a list of one node with values A toString() should return "A".""");
        }

        // WHEN
        list.removeCentralNode();

        //THEN
        Assertions.assertEquals("List is empty", list.toString());
    }

    @Test
    void removeCentralNodeFromListOfTwoNodes() {
        // GIVEN
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A")
                .addElement("B");
        if (!Objects.equals(list.toString(), "A, B")) {
            throw new NoSuchElementException("""
                    After creation a list of two nodes with values A, B toString() should return "A, B".""");
        }

        // WHEN
        list.removeCentralNode();

        //THEN
        Assertions.assertEquals("List is empty", list.toString());
    }

    @Test
    void removeCentralNodeFromListOfTreeIntegerNodes() {
        // GIVEN
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(1)
                .addElement(2)
                .addElement(3);
        if (!Objects.equals(list.toString(), "1, 2, 3")) {
            throw new NoSuchElementException("""
                    After creation a list of three nodes with values 1, 2, 3 toString() should return "1, 2, 3".""");
        }

        // WHEN
        list.removeCentralNode();

        //THEN
        Assertions.assertEquals("1, 3", list.toString());
    }

    @Test
    void removeCentralNodeFromEmptyList() {
        // GIVEN
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A").flush();
        if (!Objects.equals(list.toString(), "List is empty")) {
            throw new NoSuchElementException("""
                    After flushing a list toString() should return "List is empty".""");
        }

        // WHEN
        list.removeCentralNode();

        //THEN
        Assertions.assertEquals("List is empty", list.toString());
    }

    @Test
    void removeCentralNodeFromListOfNulls() {
        // GIVEN
        SinglyLinkedList<Object> list = new SinglyLinkedList<>(null)
                .addElement(null)
                .addElement(null);
        if (!Objects.equals(list.toString(), "Null, Null, Null")) {
            throw new NoSuchElementException("""
                    After creation a list of three nodes with NULL values, toString() should return "Null, Null, Null".""");
        }

        // WHEN
        list.removeCentralNode();

        //THEN
        Assertions.assertEquals("Null, Null", list.toString());
    }
}