package lab2.I;

import java.util.Scanner;

class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public static class Node <E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E value) {
            this.value = value;
        }
    }

    public DoublyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append (T value) {
        Node<T> newNode = new Node<>(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node<T> removeLast() {
        if(length == 0) return null;
        Node<T> temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void prepend(T value) {
        Node<T> newNode = new Node<>(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node<T> removeFirst() {
        if(length == 0) return null;
        Node<T> temp = head;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node<T> get(int index) {
        if (index < 0 || index >= length) return null;
        Node<T> temp = head;
        if (index < length/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, T value) {
        Node<T> temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, T value) {
        if(index < 0 || index > length) return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }
        Node<T> newNode = new Node<>(value);
        Node<T> before = get(index - 1);
        Node<T> after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

    public Node<T> remove(int index){
        if(index < 0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length - 1) return removeLast();
        Node<T> temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;
        length--;
        return temp;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        while(scan.hasNext()){
            String input = scan.next();
            if(input.equals("add_front")){
                list.prepend(scan.next());
                System.out.println("ok");
            } else if (input.equals("add_back")) {
                list.append(scan.next());
                System.out.println("ok");
            } else if (input.equals("erase_front")) {
                if(list.getHead() != null) {System.out.println(list.removeFirst().value);
                }else {
                    System.out.println("error");
                }
            } else if (input.equals("erase_back")) {
                if(list.getTail() != null) {
                    System.out.println(list.removeLast().value);
                }else {
                    System.out.println("error");
                }
            } else if (input.equals("front")) {
                if(list.getHead() != null) {
                    System.out.println(list.getHead().value);
                }else {
                    System.out.println("error");
                }
            } else if (input.equals("back")) {
                if(list.getTail() != null) {
                    System.out.println(list.getTail().value);
                }else {
                    System.out.println("error");
                }
            } else if (input.equals("clear")) {
                list.makeEmpty();
                System.out.println("ok");
            } else if (input.equals("exit")) {
                System.out.println("goodbye");
                break;
            }
        }
    }

}