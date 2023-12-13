package lab12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class C {
        static Vector<Integer>[] roads;
        static Vector<Integer>[] airlanes;
        static int[][] matrix;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            roads = new Vector[n];
            airlanes = new Vector[n];
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                roads[i] = new Vector<>();
                airlanes[i] = new Vector<>();
            }

            for (int i = 0; i < m; i++) {
                int a = scanner.nextInt() - 1;
                int b = scanner.nextInt() - 1;
                roads[a].add(b);
                roads[b].add(a);
                matrix[a][b] = 1;
                matrix[b][a] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] < 1 && i != j) {
                        airlanes[i].add(j);
                    }
                }
            }

            Queue<Integer> q1 = new LinkedList<>();
            ArrayList<Integer> d1 = new ArrayList<>(n + 1);
            ArrayList<Boolean> used1 = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                used1.add(false);
                d1.add(0);
            }
            q1.add(0);
            used1.set(0, true);

            while (!q1.isEmpty()) {
                int v = q1.poll();
                for (int i = 0; i < roads[v].size(); i++) {
                    int to = roads[v].get(i);
                    if (!used1.get(to)) {
                        used1.set(to, true);
                        q1.add(to);
                        d1.set(to, d1.get(v) + 1);
                    }
                }
            }

            Queue<Integer> q2 = new LinkedList<>();
            ArrayList<Integer> d2 = new ArrayList<>(n + 1);
            ArrayList<Boolean> used2 = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                used2.add(false);
                d2.add(0);
            }
            q2.add(0);
            used2.set(0, true);

            while (!q2.isEmpty()) {
                int v = q2.poll();
                for (int i = 0; i < airlanes[v].size(); i++) {
                    int to = airlanes[v].get(i);
                    if (!used2.get(to)) {
                        used2.set(to, true);
                        q2.add(to);
                        d2.set(to, d2.get(v) + 1);
                    }
                }
            }

            if (!used1.get(n - 1) || !used2.get(n - 1)) {
                System.out.println(-1);
            } else {
                System.out.println(Math.max(d1.get(n - 1), d2.get(n - 1)));
            }
        }

}
