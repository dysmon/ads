package lab11;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class D {
    static int ans = 0;
    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] g = new int[n][n];
        Vector<Boolean> visited = new Vector<>(n);
        Vector<Integer> p = new Vector<>(n, -1);
        Vector<Integer> min_e = new Vector<>(n, INF);

        for (int i = 0; i < n; i++) {
            visited.add(false);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = scanner.nextInt();
            }
        }

        min_e.set(0, 0);

        for (int i = 0; i < n; i++) {
            int v = -1;

            for (int j = 0; j < n; j++) {
                if (!visited.get(j) && (v == -1 || min_e.get(j) < min_e.get(v))) {
                    v = j;
                }
            }

            visited.set(v, true);

            if (p.get(v) != -1) {
                ans += g[v][p.get(v)];
            }

            for (int j = 0; j < n; j++) {
                if (g[v][j] < min_e.get(j)) {
                    min_e.set(j, g[v][j]);
                    p.set(j, v);
                }
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}

