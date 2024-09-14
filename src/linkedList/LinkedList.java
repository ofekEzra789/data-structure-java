package linkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int count = 0;

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        count++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first = node;
        }
        count++;
    }

    public int indexOf(int item) {
        int index = 0;
        var curr = first;

        while (curr != null) {
            if (curr.value == item) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return  indexOf(item) != -1;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else if (first == last) {
            first = last = null;
        }
        else {
            var temp = first.next;
            first.next = null;
            first = temp;
        }
        count--;
    }

    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (first == last) {
            first = last = null;
        } else {
            var curr = first;

            while (curr.next != last) {
                curr = curr.next;
            }
            curr.next = null;
            last = curr;
        }
        count--;
    }

    public void print() {
        var curr = first;

        while (curr != null) {
            System.out.print(curr.value + " --> ");
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println("\n");
    }

    public int size() {
        return this.count;
    }

    public void reverse() {
        var lastAfterRev = first;
        var p = first;
        var c = first.next;

        if (isEmpty()) return;

        while (c != null) {
            var n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        first = p;
        last = lastAfterRev;
        last.next = null;
    }

    public int[] toArray() {
        int[] array = new int[count];
        int index = 0;
        var curr = first;

        while (curr != null) {
            array[index++] = curr.value;
            curr = curr.next;
        }
        return array;
    }

    private boolean isEmpty() {
        return first == null;
    }
}


