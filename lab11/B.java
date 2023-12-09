package lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {
    static List<Integer> p;

    static int dsu_get(int v) {
        return (v == p.get(v)) ? v : (p.set(v, dsu_get(p.get(v))));
    }

    static void dsu_unite(int a, int b) {
        a = dsu_get(a);
        b = dsu_get(b);
        if ((int) (Math.random() * 2) == 1) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a != b)
            p.set(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        p = new ArrayList<>(Collections.nCopies(n, 0));

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        List<ArrayList<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(a[i] + a[j]);
                pair.add(i);
                pair.add(j);
                g.add(pair);
            }
        }

        int m = g.size();
        int cost = 0;
        List<ArrayList<Integer>> res = new ArrayList<>();

        Collections.sort(g, (a1, b1) -> Integer.compare(a1.get(0), b1.get(0)));

        for (int i = 0; i < n; ++i) {
            p.set(i, i);
        }

        for (int i = 0; i < m; ++i) {
            int a1 = g.get(i).get(1), b = g.get(i).get(2), l = g.get(i).get(0);
            if (dsu_get(a1) != dsu_get(b)) {
                cost += l;
                res.add(g.get(i));
                dsu_unite(a1, b);
            }
        }

        System.out.println(cost);
        scanner.close();
    }
}
