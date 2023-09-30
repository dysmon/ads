package lab1;

import java.util.*;

public class I {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String input = scan.nextLine();

        Queue<Character> q = new ArrayDeque<>();
        for(int i = 0;i < n;i++){
            q.add(input.charAt(i));
        }
        int vote = 0;

        while(q.size() > Math.abs(vote)) {
            if(q.element() == 'K'){
                if(vote < 0){
                    q.remove();
                } else {
                    q.add(q.remove());
                }
                ++vote;
            } else {
                if(vote > 0){
                    q.remove();
                } else {
                    q.add(q.remove());
                }
                --vote;
            }
        }

        System.out.println(vote > 0 ? "KATSURAGI" : "SAKAYANAGI");
    }
}