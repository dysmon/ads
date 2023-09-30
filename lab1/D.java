package lab1;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        String s = con.next();
        Stack<Character> stack = new Stack<>();

        solution(s,stack);
    }
    static void solution(String s, Stack<Character> stack){
        for (char c : s.toCharArray()) {
            if(stack.isEmpty()){
                stack.push(c);
            } else if (c == stack.peek()) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        System.out.println(stack.isEmpty() ? "YES" : "NO");
    }
}
