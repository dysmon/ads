package lab10.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A {
    static class Index {
        int i, j;

        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static Queue<Index> q = new ArrayDeque<>();
    static int[][] matrix;

    static void step(int i, int j, int col, int row) {
        if (i < col && j < row && i >= 0 && j >= 0 && matrix[i][j] == 1) {
            matrix[i][j] = 2;
            q.add(new Index(i, j));
        }
    }

    public static void main(String[] args) throws IOException {
        var input = new BufferedReader(new InputStreamReader(System.in));
        var token = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        matrix = new int[n][m];

        int time = -1;

        for (int i = 0; i < n; ++i) {
            token = new StringTokenizer(input.readLine());
            for (int j = 0; j < m; ++j) {
                matrix[i][j] = Integer.parseInt(token.nextToken());
                if (matrix[i][j] == 2) {
                    q.add(new Index(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            time++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Index cur = q.remove();

                step(cur.i - 1, cur.j, n, m);
                step(cur.i + 1, cur.j, n, m);
                step(cur.i, cur.j - 1, n, m);
                step(cur.i, cur.j + 1, n, m);
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 1) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        if (time == -1) {
            System.out.println(0);
        } else {
            System.out.println(time);
        }

        input.close();
    }
}