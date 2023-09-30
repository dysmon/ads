package lab1;

import java.util.*;

public class J {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        while(scan.hasNext()) {
            String operation = scan.next();
            if (operation.equals("!")) {
                break;
            }
            if (operation.equals("+")) {
                arrayDeque.addFirst(scan.nextInt());
            } else if (operation.equals("-")) {
                arrayDeque.addLast(scan.nextInt());
            } else if (arrayDeque.isEmpty()) {
                list.add(-1);
            } else if (operation.equals("*")) {
                if(arrayDeque.size() != 1) {
                    list.add(arrayDeque.removeFirst() + arrayDeque.removeLast());
                }else {
                    list.add(2 * arrayDeque.removeFirst());
                }
            }
        }

            for(int i : list){
                if (i == -1){
                    System.out.println("error");
                }else {
                    System.out.println(i);
                }
            }
    }
}
