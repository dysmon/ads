package lab10.I;

import java.io.*;
import java.util.*;

public class I {
    static int n;
    static ArrayList<Integer>[] matrix;
    static int[] color;
    static ArrayList<Integer> ans;

    public static void dfs(int v) {
        if (color[v] == 1) {
            System.out.println("Impossible");
            System.exit(0);
        }

        if (color[v] == 2) {
            return;
        }

        color[v] = 1;

        for (int to : matrix[v]) {
            dfs(to);
        }

        color[v] = 2;
        ans.add(v);
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        matrix = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            matrix[i] = new ArrayList<>();
        }

        color = new int[n + 1];
        ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            matrix[from].add(to);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                dfs(i);
            }
        }

        System.out.println("Possible");

        Collections.reverse(ans);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}