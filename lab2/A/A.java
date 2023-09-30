package lab2.A;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        int nearest = Integer.MAX_VALUE;
        int nearestInder = 0;

        for(int i = 0; i < n;i++){
            if(Math.abs(arr[i] - k) == 0){
                System.out.println(i);
                return;
            }
            else if(Math.abs(arr[i] - k) < nearest){
                nearest = Math.abs(arr[i] - k);
                nearestInder = i;
            }
        }
        System.out.println(nearestInder);
    }
}
