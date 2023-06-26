package org.example.tasks;

import java.util.Objects;

/**
 * Class represents singly linked list.
 *
 * @author Gennady Sitnikov
 * @param <T>
 */
public class SinglyLinkedList<T> {
    private SinglyLinkedList.Node<T> root;

    public SinglyLinkedList(T rootNodeValue) {
        this.root = new Node<>(rootNodeValue, null);
    }

    public SinglyLinkedList<T> flush() {
        root = null;
        return this;
    }

    public int size() {

        if (Objects.isNull(root)) {
            return 0;
        }

        Node<T> currentNode = root;
        int counter = 1;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            counter++;
        }
        return counter;
    }

    public SinglyLinkedList<T> addElement(T nodeValue) {
        Node<T> currentNode = root;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(nodeValue, null);
        return this;
    }

    /**
     * Print the list
     *
     * @return string   of values of nodes list in natural order separated by coma
     *                  Special cases:
     *                      if list is empty then return "List is empty"
     *                      if node value is null return "Null".
     */
    @Override
    public String toString() {
        Node<T> currentNode = root;
        StringBuilder stringBuilder = new StringBuilder();

        // Degenerate case - list is empty.
        if (Objects.isNull(root)) {
            return "List is empty";
        }

        while (currentNode.next != null) {
            stringBuilder
                    .append(Objects
                        .isNull(currentNode.value) ?
                        "Null" :
                        currentNode.value.toString())
                    .append(", ");
            currentNode = currentNode.next;
        }

        stringBuilder
                .append(Objects
                        .isNull(currentNode.value) ?
                        "Null" :
                        currentNode.value.toString());

        return stringBuilder.toString();
    }

    /**
     * The method removes central node(s).
     * <ul>
     * <li>If number of nodes is odd then one central node is deleted.
     * ex: [survived] -> [deleted] -> [survived]
     * <li>If number of nodes is even then two central node are deleted.
     * ex: [survived] -> [deleted] -> [deleted] -> [survived]
     * </ul>
     * <p>
     * Corner cases:
     * <ul>
     * <li> If only one or two nodes in the list remove all of them.
     * <li> If list is empty, then do nothing.
     * </ul>
     *
     * @return The list without central node(s).
     */
    public SinglyLinkedList<T> removeCentralNode() {
        // Degenerate case - list is empty.
        if (Objects.isNull(root)) {
            return this;
        }

        Node<T> tmpMiddleNodeOne = root;
        Node<T> tmpMiddleNodeTwo = null;
        Node<T> currentNode = root;
        Node<T> nodeBeforeMiddle = null;
        boolean isSizeOdd = true;

        // Calculate middle nodes
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            isSizeOdd = !isSizeOdd;

            if (isSizeOdd) {
                nodeBeforeMiddle = tmpMiddleNodeOne;
                tmpMiddleNodeOne = tmpMiddleNodeTwo;
                tmpMiddleNodeTwo = null;
            }
            else {
                tmpMiddleNodeTwo = tmpMiddleNodeOne.next;
            }
        }

        // Delete nodes - if there is one or two nodes just flush the list,
        //                otherwise remove central node(s) by switching the next node link to node after central one(s).
        if (Objects.isNull(nodeBeforeMiddle)) {
            flush();
        }
        else {
            nodeBeforeMiddle.next = isSizeOdd ? nodeBeforeMiddle.next.next : nodeBeforeMiddle.next.next.next;
        }

        return this;
    }

    private static class Node<T> {
        T value;
        SinglyLinkedList.Node<T> next;

        Node(T value, SinglyLinkedList.Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
