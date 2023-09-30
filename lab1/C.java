package lab1;

import java.util.Scanner;
import java.util.Stack;

public class C {
    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        String first = con.next();
        String second = con.next();
        if(lengthOfWord(first) == lengthOfWord(second)) System.out.println("Yes");
        else System.out.println("No");
    }
    static int lengthOfWord(String word){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < word.length();i++){
            if(word.charAt(i) != '#'){
                stack.push(word.charAt(i));
            } else {
                stack.pop();
            }
        }
        return stack.size();
    }
}
