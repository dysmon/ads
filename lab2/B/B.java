package lab2.B;

import java.util.Scanner;

class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int length;

    public static class Node<T> {
        T value;
        Node<T> next;

        Node() {
        }

        Node(T value) {
            this.value = value;
        }
    }

    public SinglyLinkedList() {
        Node<E> newNode = new Node<>();
        head = newNode;
        tail = newNode;
        length = 0;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public StringBuilder printList() {
        Node<E> temp = head;
        StringBuilder s = new StringBuilder();
        while (temp != null) {
            s.append(temp.value + " ");
            temp = temp.next;
        }
        return s;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(E value) {
        Node<E> newNode = new Node<>(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node<E> get(int index) {
        if (index < 0 || index >= length) return null;
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node<E> shiftBy(int shift) {
        shift = shift % length;
        if (shift == length) return head;
        Node<E> temp = get(shift - 1);
        tail.next = head;
        head = temp.next;
        temp.next = null;
        tail = temp;

        return head;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SinglyLinkedList<String> list = new
                SinglyLinkedList<>();
        int n = scan.nextInt();
        int shift = scan.nextInt();
        for (int i = 0; i < n; i++) {
            list.append(scan.next());
        }
        list.shiftBy(shift);
        System.out.println(list.printList());
    }
}
