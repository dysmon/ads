package lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C {
    static class Pair<T, U> {
        T first;
        U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
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
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        List<Pair<Integer, Pair<Integer, Integer>>> g = new ArrayList<>();
        while (m-- > 0) {
            String roadType = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (roadType.equals("big")) {
                g.add(new Pair<>(c * x, new Pair<>(a, b)));
            } else if (roadType.equals("small")) {
                g.add(new Pair<>(c * y, new Pair<>(a, b)));
            } else if (roadType.equals("both")) {
                g.add(new Pair<>(c * x, new Pair<>(a, b)));
                g.add(new Pair<>(c * y, new Pair<>(a, b)));
            }
        }

        int k = g.size();
        int cost = 0;
        List<Pair<Integer, Integer>> res = new ArrayList<>();

        Collections.sort(g, (a1, b1) -> Integer.compare(a1.first, b1.first));

        p = new ArrayList<>(Collections.nCopies(n, 0));
        for (int i = 0; i < n; ++i) {
            p.set(i, i);
        }

        for (int i = 0; i < k; ++i) {
            int a = g.get(i).second.first, b = g.get(i).second.second, l = g.get(i).first;
            if (dsu_get(a) != dsu_get(b)) {
                cost += l;
                res.add(g.get(i).second);
                dsu_unite(a, b);
            }
        }
        System.out.println(cost);
        scanner.close();
    }
}
