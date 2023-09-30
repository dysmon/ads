package lab1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);
        init(queue1,scanner.nextLine());
        init(queue2,scanner.nextLine());

        scanner.close();

        solution(queue1,queue2);

    }
    static void init(Queue<Integer> queue,String inputLine){
        Scanner con = new Scanner(inputLine);
        while(con.hasNextInt()){
                queue.add(con.nextInt());
        }
    }

    static void solution(Queue<Integer> queue1,Queue<Integer> queue2){
        for(int i = 0;i < 10e6; i++){
            if(queue1.isEmpty()){
                System.out.println("Nursik " + i);
                return;
            }else if(queue2.isEmpty()){
                System.out.println("Boris " + i);
                return;
            }
            if((queue1.element() > queue2.element() || (queue1.element() == 0 &&
                    queue2.element() == 9)) && (queue1.element() != 9 ||
                    queue2.element() != 0)){
                queue1.add(queue1.remove());
                queue1.add(queue2.remove());
            } else if(queue1.element() < queue2.element() || (queue2.element() == 0 &&
                    queue1.element() == 9)) {
                queue2.add(queue1.remove());
                queue2.add(queue2.remove());
            }
        }
        System.out.println("blin nichya");
    }
}
