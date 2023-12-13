package lab12;

import java.util.*;

// Dijkstra

public class B {

        static int INF = 1000000000;
        static List<int[]>[] g = new ArrayList[200001];
        static int[] d = new int[200001];
        static int n, m;

        static int dijkstra(int s, int end) {
            Arrays.fill(d, INF);
            d[s] = 0;
            PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            q.offer(new int[]{d[s], s});

            while (!q.isEmpty()) {
                int[] pair = q.poll();
                int v = pair[1];

                for (int[] edge : g[v]) {
                    int to = edge[0];
                    int len = edge[1];

                    if (d[v] + len < d[to]) {
                        q.remove(new int[]{d[to], to});
                        d[to] = d[v] + len;
                        q.offer(new int[]{d[to], to});
                    }
                }
            }

            return d[end];
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            m = scanner.nextInt();

            for (int i = 0; i <= n; i++) {
                g[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                g[a].add(new int[]{b, c});
                g[b].add(new int[]{a, c});
            }

            int q = scanner.nextInt();
            int w = scanner.nextInt();
            int e = scanner.nextInt();
            int r = scanner.nextInt();

            int a = dijkstra(q, w) + dijkstra(w, e) + dijkstra(e, r);
            int b = dijkstra(q, e) + dijkstra(e, w) + dijkstra(w, r);

            if (Math.min(a, b) <= INF) {
                System.out.println(Math.min(a, b));
            } else {
                System.out.println(-1);
            }
        }

}
