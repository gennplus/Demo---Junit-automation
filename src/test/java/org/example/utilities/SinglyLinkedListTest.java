package org.example.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    @Test
    void addElement() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("A");
        Assertions.assertEquals("A", list.toString());

        list.addElement("B");
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
    void removeCentralNode() {
    }
}