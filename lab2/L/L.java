package lab2.L;

import java.util.*;

class SinglyLinkedList<E extends Integer> {
    private Node<E> head;
    private Node<E> tail;
    private int length;

    public static class Node<T extends Integer> {
        T value;
        Node<T> next;
        Node(){}
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

    public Node<E> removeLast() {
        if (length == 0) return null;
        Node<E> temp = head;
        Node<E> pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(E value) {
        Node<E> newNode = new Node<>(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node<E> removeFirst() {
        if (length == 0) return null;
        Node<E> temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node<E> get(int index) {
        if (index < 0 || index >= length) return null;
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean insert(E value,int index) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node<E> newNode = new Node<>(value);
        Node<E> temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node<E> remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node<E> prev = get(index - 1);
        Node<E> temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }
    public Node<E> shiftLeft(int shift){
        shift = shift % length;
        if(shift == 0) return head;
        Node<E> temp = get(shift - 1);
        tail.next = head;
        head = temp.next;
        temp.next = null;
        tail = temp;
        return head;
    }
    public int sumSubarray(){
        int maxSum = head.value;
        int sum = 0;
        Node<E> temp = head;
        Node<E> temp2 = head;
        for(int i = 0;i < getLength();i++){
            while(temp!= null) {
                sum += (int) temp.value;
                if (sum > maxSum) {
                    maxSum = sum;
                }
                temp = temp.next;
            }
            sum = 0;
            temp2 = temp2.next;
            temp = temp2;
        }
        return maxSum;
    }

    public void removeDuplicates(){
        Node<E> temp = head;
        while(temp.next != null){
            if(temp.value.equals(temp.next.value)){
                temp.next = temp.next.next;
                length--;
            }
            else{
                temp = temp.next;
            }
        }
        tail = temp;
    }

    public void reverse() {
        Node<E> temp = head;
        head = tail;
        tail = temp;

        Node<E> before = null;
        Node<E> after = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        int n = scan.nextInt();
        for(int i = 0; i < n; i++){
            list.append(scan.nextInt());
        }
        System.out.println(list.sumSubarray());
    }

}
