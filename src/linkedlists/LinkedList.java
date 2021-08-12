package linkedlists;

import java.util.Arrays;
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
    private int size;

    public void addFirst(int item) {
        Node newHead = new Node(item);
        if (isEmpty()) {
            first = last = new Node(item);
        } else {
            newHead.next = first;
            first = newHead;
        }
        size++;
    }

    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }

        Node newHead = first.next;
        first.next = null;
        first = newHead;
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            size = 0;
        }

        Node current = first;
        while (current != null) {
            if (current.next == last) break;
            current = current.next;
        }
        current.next = null;
        last = current;
        size--;
    }

    public void deleteWithValue(int item) {
        if (first == null) return;

        //     current  next   next.next
        // [] -> [] ->  [v] -> [] ->
        Node current = first;
        while (current.next != null) {
            if (current.next.value == item) {
                Node next = current.next.next;
                current.next.next = null;
                current.next = next;
                return;
            }
            current = current.next;
        }
        throw new IllegalArgumentException();
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    //                             p    c     n
    //     10 -> 20 -> 30 -> 40 -> 50
    //  <- 10 <- 20

    public void reverse() {
        if (isEmpty()) return;

        Node current = first;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        last = first;
        first = prev;
    }

    //Kth node from the end
    public int kthNodeFromEnd(int k) {
        if (isEmpty()) throw new IllegalStateException();
        if (k < 1) throw new IllegalArgumentException();

        Node a = first;
        Node b = first;
        int distance = 0;
        //                        a
        //             b
        //10 -> 20 -> 30 -> 40 -> 50
        //d = 2
        while (a.next != null) {
            if (distance == k - 1) {
                a = a.next;
                b = b.next;
            } else {
                a = a.next;
                if (a == null) throw new IllegalArgumentException();
                distance++;
            }
        }

        return b.value;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
