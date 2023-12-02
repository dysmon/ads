package lab10.G;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G {
    static List<Integer>[] matrix;
    static int[] used;
    static Stack<Integer> stack;
    static List<Integer> cyclePath;
    static boolean isCyclic;

    public static boolean dfs(int v, int a, int b) {
        used[v] = 1;
        for (int to : matrix[v]) {
            if (v == a && b == to) {
                continue;
            }
            if (used[to] == 0) {
                if (dfs(to, a, b)) {
                    return true;
                }
            } else if (used[to] == 1) {
                return true;
            }
        }
        used[v] = 2;
        return false;
    }

    public static boolean dfs2(int v) {
        used[v] = 1;
        stack.push(v);
        for (int i : matrix[v]) {
            if (used[i] == 0) {
                if (dfs2(i)) {
                    return true;
                }
            } else if (used[i] == 1) {
                while (stack.peek() != i) {
                    cyclePath.add(stack.pop());
                }
                cyclePath.add(i);
                cyclePath.add(v);
                Collections.reverse(cyclePath);
                return true;
            }
        }
        used[v] = 2;
        if (!stack.isEmpty()) {
            stack.pop();
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        matrix = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            matrix[u].add(v);
        }

        used = new int[n + 1];
        stack = new Stack<>();
        cyclePath = new ArrayList<>();
        isCyclic = false;

        for (int i = 1; i <= n; i++) {
            if (used[i] == 0) {
                isCyclic = dfs2(i);
                if (isCyclic) {
                    break;
                }
            }
        }

        if (!isCyclic) {
            System.out.println("YES");
            return;
        }

        for (int i = 0; i < cyclePath.size() - 1; i++) {
            int u = cyclePath.get(i);
            int v = cyclePath.get(i + 1);
            Arrays.fill(used, 0);
            isCyclic = false;

            for (int j = 1; j <= n; j++) {
                if (used[j] == 0) {
                    isCyclic |= dfs(j, u, v);
                }
            }

            if (!isCyclic) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
