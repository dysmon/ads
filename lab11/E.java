package lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class E {
    static int[] p = new int[200005];
    static int[] rk = new int[200005];

    static void init_dsu() {
        for (int i = 0; i < 200005; i++) {
            p[i] = i;
            rk[i] = 1;
        }
    }

    static int get_root(int v) {
        if (p[v] == v) {
            return v;
        } else {
            return p[v] = get_root(p[v]);
        }
    }

    static boolean merge(int a, int b) {
        int ra = get_root(a), rb = get_root(b);

        if (ra == rb) {
            return false;
        } else {
            if (rk[ra] < rk[rb]) {
                p[ra] = rb;
            } else if (rk[rb] < rk[ra]) {
                p[rb] = ra;
            } else {
                p[ra] = rb;
                rk[rb]++;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int cnt = 0;
        init_dsu();

        ArrayList<Integer>[] g = new ArrayList[200005];
        for (int i = 0; i < 200005; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            cnt++;
            for (int j = 0; j < g[i].size(); j++) {
                if (g[i].get(j) > i && get_root(i) != get_root(g[i].get(j))) {
                    cnt--;
                    merge(i, g[i].get(j));
                }
            }
            res.add(cnt);
        }

        Collections.reverse(res);

        for (int i = 1; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        System.out.println(0);
        scanner.close();
    }

}

