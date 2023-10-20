package lab4;

import java.util.PriorityQueue;

public class Example {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(30);
        queue.add(20);
        queue.add(60);
        queue.add(50);
        queue.add(15);
        queue.add(80);
        queue.add(50);
        queue.add(40);
        queue.add(20);
        System.out.println(queue);

    }
}
