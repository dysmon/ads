package lab8;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        var sb = new StringBuilder();
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i] - arr[i-1];
        }

        for (int i = 0; i < arr.length; i++) {
            char ch = (char) (arr[i] / Math.pow(2,i) + 97);
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
