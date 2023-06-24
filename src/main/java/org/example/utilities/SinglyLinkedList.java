package org.example.utilities;

public class SinglyLinkedList<T> {
    private final SinglyLinkedList.Node<T> root;

    public SinglyLinkedList(Node<T> root) {
        this.root = root;
    }

    public SinglyLinkedList<T> addElement(Node<T> node) {
        Node<T> currentNode = root;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        return this;
    }

    public void printList() {
        Node<T> currentNode = root;
        while (currentNode.next != null) {
            System.out.print(currentNode.item.toString());
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.item.toString());
    }

    /**
     * The method removes central node(s).
     * If number of nodes is odd then one central node is deleted.
     * ex: [survived] -> [deleted] -> [survived]
     * If number of nodes is even then two central node are deleted.
     * ex: [survived] -> [deleted] -> [deleted] -> [survived]
     * @return The list without central node(s).
     */
    public SinglyLinkedList<T> removeCentralNode() {
        Node<T> tmpMiddleElementOne = root;
        Node<T> tmpMiddleElementTwo = null;
        Node<T> currentElement = root;
        Node<T> prevMiddleElement = null;
        boolean sizeIsOdd = true;

        while (currentElement.next != null) {
            currentElement = currentElement.next;
            sizeIsOdd = !sizeIsOdd;

            if (sizeIsOdd) {
                prevMiddleElement = tmpMiddleElementOne;
                tmpMiddleElementOne = tmpMiddleElementTwo;
                tmpMiddleElementTwo = null;
            }
            else {
                tmpMiddleElementTwo = tmpMiddleElementOne.next;
            }
        }

        prevMiddleElement.next = sizeIsOdd ? prevMiddleElement.next.next.next : prevMiddleElement.next.next;

        return this;
    }

    private static class Node<T> {
        T item;
        SinglyLinkedList.Node<T> next;

        Node(T element, SinglyLinkedList.Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}
