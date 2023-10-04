package lab3;

import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static boolean check(int[] a, long m, int k) {
        long cnt = 0;
        long sum = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > m) {
                return false;
            } else if (sum + a[i] > m) {
                sum = a[i];
                cnt++;
            } else {
                sum += a[i];
            }
        }
        cnt++;
        return cnt <= k;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        long left = 0;
        long right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            right += a[i];
        }

        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (check(a, mid, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}


