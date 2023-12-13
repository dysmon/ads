package lab12;

import java.util.Scanner;

public class D {
    static final int N = (int) 2e5 + 5;
    static final int INF = (int) 2e9 + 7;
    static int[] x = new int[N];
    static int[] y = new int[N];
    static int[] p = new int[N];
    static int ans = 0;

    static int get(int v) {
        if (v == p[v])
            return v;
        return p[v] = get(p[v]);
    }

    static boolean unite(int a, int b) {
        a = get(a);
        b = get(b);
        if (a == b)
            return false;
        if (Math.random() < 0.5)
            swap(a, b);
        p[b] = a;
        return true;
    }

    static void bin(int l, int r, int n) {
        while (l <= r) {
            int md = (l + r) / 2;
            for (int i = 1; i <= n; i++)
                p[i] = i;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]) <= md)
                        unite(i, j);
                }
            }
            if (get(1) == get(n)) {
                ans = md;
                r = md - 1;
            } else {
                l = md + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        bin(0, INF, n);
        System.out.println(ans);
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}

