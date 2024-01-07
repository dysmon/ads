package lab1;

import java.util.Scanner;
import java.util.Stack;

public class B {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int element = scan.nextInt();

            while (!stack.isEmpty() && element < stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(stack.peek() + " ");
            }
            stack.push(element);
        }
    }
}
