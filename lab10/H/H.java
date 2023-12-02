package lab10.H;

import java.util.Scanner;


public class H {
    public class Main {
        static char[][] a;
        static int n, m;

        public static void dfs(int i, int j) {
            if (i < 0 || j < 0 || i >= n || j >= m || a[i][j] == '0') return;
            a[i][j] = '0';
            dfs(i, j + 1);
            dfs(i, j - 1);
            dfs(i + 1, j);
            dfs(i - 1, j);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            n = scanner.nextInt();
            m = scanner.nextInt();
            scanner.nextLine();

            a = new char[n][m];

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < m; j++) {
                    a[i][j] = line.charAt(j);
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == '1') {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

        }
    }
}
