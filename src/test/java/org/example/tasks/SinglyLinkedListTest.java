package org.example.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedListTest {

    @Test
    @Tag("smoke_task1")
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
        Assertions.assertEquals(2, list.size());
    }

    @Test
    @Tag("smoke_task1")
    void toStringOneItemList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A");
        Assertions.assertEquals("A", list.toString());
    }

    @Test
    @Tag("smoke_task1")
    void toStringThreeItemsList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A")
                .addElement("B")
                .addElement("C");

        Assertions.assertEquals("A, B, C", list.toString());
    }

    @Test
    @Tag("smoke_task1")
    void toStringEmptyList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A").flush();
        Assertions.assertEquals("List is empty", list.toString());
    }

    @Test
    @Tag("smoke_task1")
    void toStringListOfNulls() {
        SinglyLinkedList<Object> list = new SinglyLinkedList<>(null)
                .addElement(null);
        Assertions.assertEquals("Null, Null", list.toString());
    }

    @Test
    @Tag("smoke_task1")
    void flush() {
        // GIVEN
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A");

        // WHEN
        list.flush();

        //THEN
        Assertions.assertEquals("List is empty", list.toString());
        Assertions.assertEquals(0, list.size());
    }

    @Test
    @Tag("smoke_task1")
    void size() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A")
                .addElement("B")
                .addElement("C");

        Assertions.assertEquals(3, list.size());
    }

    @Test
    @Tag("smoke_task1")
    void sizeOfEmptyList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A")
                .flush();

        Assertions.assertEquals(0, list.size());
    }

    @Test
    @Tag("full_task1")
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
        Assertions.assertEquals(2, list.size());
    }

    @Test
    @Tag("full_task1")
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
        Assertions.assertEquals(2, list.size());
    }

    @Test
    @Tag("full_task1")
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
        Assertions.assertEquals(0, list.size());
    }

    @Test
    @Tag("full_task1")
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
        Assertions.assertEquals(0, list.size());
    }

    @Test
    @Tag("full_task1")
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
        Assertions.assertEquals(2, list.size());
    }

    @Test
    @Tag("full_task1")
    void removeCentralNodeFromEmptyList() {
        // GIVEN
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A").flush();
        if (list.size() != 0) {
            throw new NoSuchElementException("""
                    After flushing a list should be empty.""");
        }

        // WHEN
        list.removeCentralNode();

        //THEN
        Assertions.assertEquals("List is empty", list.toString());
        Assertions.assertEquals(0, list.size());
    }

    @Test
    @Tag("full_task1")
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
        Assertions.assertEquals(2, list.size());
    }
}