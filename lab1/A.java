package lab1;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int deck = scan.nextInt();
            solution(deck);
        }
    }

    static void solution(int deck){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(deck);
        for(int i = deck - 1; i > 0; i--){
            deque.addFirst(i);
            for(int j = i;j > 0;j--) {
                deque.addFirst(deque.removeLast());
            }
        }
        for(int i : deque){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
