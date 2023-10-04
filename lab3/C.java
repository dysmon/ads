package lab3;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int query = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        for (int i = 0; i < query; i++) {
            int cnt = 0;
            int l1 = scan.nextInt();
            int r1 = scan.nextInt();
            int l2 = scan.nextInt();
            int r2 = scan.nextInt();
            for (int k = 0; k < n; k++) {
                if (arr[k] >= l1 && arr[k] <= r1 || arr[k] >= l2 && arr[k] <= r2) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
