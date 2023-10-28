package lab7;

import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] rows = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                rows[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Comparator<int[]> rowComparator = new Comparator<>() {
            @Override
            public int compare(int[] row1, int[] row2) {
                int sum1 = Arrays.stream(row1).sum();
                int sum2 = Arrays.stream(row2).sum();

                if (sum1 != sum2) {
                    return Integer.compare(sum2, sum1);
                }

                for (int i = 0; i < m; i++) {
                    if (row1[i] != row2[i]) {
                        return Integer.compare(row1[i], row2[i]);
                    }
                }

                return 0;
            }
        };

        Arrays.sort(rows, rowComparator);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(rows[i][j] + " ");
            }
            bw.newLine();
        }
        bw.close();
    }
}
