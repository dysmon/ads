package lab10.J;

import java.util.ArrayList;
import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(n);
        ArrayList<Integer> parents = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
            parents.add(-1);
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            matrix.get(x).add(y);
            parents.set(y, x);
        }
        System.out.println(matrix);
        System.out.println(parents);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (parents.get(i) == -1 || matrix.get(parents.get(i)).size() < matrix.get(i).size()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
