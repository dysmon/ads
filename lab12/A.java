package lab12;

import java.util.ArrayList;
import java.util.Scanner;

// Floyd-Warshall

public class A {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[][] matrix = new int[501][501];
            int[] x = new int[501];
            boolean[] used = new boolean[501];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 1; i <= n; i++) {
                x[i] = scanner.nextInt();
            }

            ArrayList<Integer> ans = new ArrayList<>();

            for (int k = 1; k <= n; k++) {
                used[x[k]] = true;
                int temp = 0;

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][x[k]] + matrix[x[k]][j]);
                        if (used[i] && used[j]) {
                            temp = Math.max(matrix[i][j], temp);
                        }
                    }
                }
                ans.add(temp);
            }

            for (int i : ans) {
                System.out.println(i);
            }
        }
}
