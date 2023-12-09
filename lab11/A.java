package lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A {
    static class Edge implements Comparable<Edge> {
        int weight;
        int left;
        int right;

        public Edge(int weight, int left, int right) {
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static int n, m;
    static int[] e1, e2, e3;

    static void col(boolean[] used, int l, int r) {
        for (int i = l; i <= r; i++) {
            used[i] = true;
        }
    }

    static int find(int i) {
        if (i == e1[i]) {
            return i;
        }

        return e1[i] = find(e1[i]);
    }

    static boolean sl(int i, int j) {
        int a = find(i), b = find(j);
        if (a == b) return false;
        e1[a] = b;
        e2[b] = Math.min(e2[a], e2[b]);
        e3[b] = Math.max(e3[a], e3[b]);
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        List<Edge> g = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            int c = scanner.nextInt();
            g.add(new Edge(c, l, r));
        }

        e1 = new int[n];
        e2 = new int[n];
        e3 = new int[n];

        for (int i = 0; i < n; i++) {
            e1[i] = i;
            e2[i] = i;
            e3[i] = i;
        }

        Collections.sort(g);

        long ans = 0;
        int cnt = 0;
        int p = -1;

        for (int i = 0; i < g.size(); i++) {
            if (cnt > n - 1) {
                break;
            }

            int l = g.get(i).left, r = g.get(i).right, c = g.get(i).weight;
            p = l;

            for (int j = l; j <= r; j++) {
                if (j != find(j)) {
                    p = find(j);
                    break;
                }
            }

            if (e2[p] <= l && r <= e3[p]) {
                continue;
            } else if (e2[p] <= r && r <= e3[p]) {
                r = e2[p];
            } else if (e2[p] <= l && l <= e3[p]) {
                l = e3[p];
            }

            for (int j = l; j <= r; j++) {
                if (sl(p, j)) {
                    cnt++;
                    ans += c;
                }
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}
