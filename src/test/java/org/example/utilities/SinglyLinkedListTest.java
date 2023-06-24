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
                    After creation of list with root element with value "A", toString() should return "A".""");
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
    void removeCentralNodeFromListOfTreeNodes() {
        // GIVEN
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A")
                .addElement("B")
                .addElement("C");
        if (!Objects.equals(list.toString(), "A, B, C")) {
            throw new NoSuchElementException("""
                    After creation of list of three nodes with values A, B, C, toString() should return "A, B, C".""");
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
                    After creation of list of three nodes with values A, B, C, D\s
                    toString() should return "A, B, C, D".""");
        }

        // WHEN
        list.removeCentralNode();

        //THEN
        Assertions.assertEquals("A, D", list.toString());
    }
}