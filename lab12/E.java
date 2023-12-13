package lab12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Dijkstra

public class E {

    static int n, v;
    static List<Edge> e = new ArrayList<>();
    static final int INF = 1000000000;
    static boolean cycle = false;

    static class Edge {
        int a, b, cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static void dijkstra() {
        int[] d = new int[n];
        int[] p = new int[n];
        int x = 0;

        for (int i = 0; i < n; i++) {
            d[i] = INF;
            p[i] = -1;
        }

        d[v] = 0;

        for (int i = 0; i < n; i++) {
            x = -1;
            for (int j = 0; j < n * n; j++) {
                if (d[e.get(j).a] < INF) {
                    if (d[e.get(j).b] > d[e.get(j).a] + e.get(j).cost) {
                        d[e.get(j).b] = Math.max(-INF, d[e.get(j).a] + e.get(j).cost);
                        p[e.get(j).b] = e.get(j).a;
                        x = e.get(j).b;
                    }
                }
            }
        }

        if (x == -1) {
            cycle = false;
        } else {
            int y = x;
            for (int i = 0; i < n; i++) {
                y = p[y];
            }

            List<Integer> path = new ArrayList<>();
            for (int cur = y; ; cur = p[cur]) {
                path.add(cur);
                if (cur == y && path.size() > 1) {
                    break;
                }
            }

            Collections.reverse(path);

            System.out.println("YES");
            System.out.println(path.size());

            for (int i : path) {
                System.out.print((i + 1) + " ");
            }
            System.out.println();
            cycle = true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cost = scanner.nextInt();
                e.add(new Edge(i, j, cost));
            }
        }

        for (int i = 0; i < n; i++) {
            v = i;
            dijkstra();
            if (cycle) {
                break;
            }
        }

        if (!cycle) {
            System.out.println("NO");
        }
    }

}
