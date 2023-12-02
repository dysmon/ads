package lab10.F;

import java.util.ArrayList;
import java.util.Scanner;

public class F {
    static ArrayList<ArrayList<Integer>> matrix;
    static ArrayList<Integer> color;

    public static void dfs(int v) {
        color.set(v, 1);
        for (int i : matrix.get(v)) {
            if (color.get(i) == 0) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        matrix = new ArrayList<>(n);
        color = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
            color.add(0);
        }

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            matrix.get(from).add(to);
            matrix.get(to).add(from);
        }

        int s = scanner.nextInt() - 1;
        int f = scanner.nextInt() - 1;
        boolean check = false;
        dfs(s);

        for (int i = 0; i < n; i++) {
            if (color.get(i) == 1 && i == f) {
                check = true;
            }
        }

        if (check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}