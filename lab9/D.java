package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {
    public static int computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int j = 1;

        while (j < m) {
            if (pattern.charAt(j) == pattern.charAt(len)) {
                len++;
                lps[j] = len;
                j++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[j] = 0;
                j++;
            }
        }
        return lps[pattern.length() - 1];
    }

    public static void main(String[] args) throws IOException {
        var input = new BufferedReader(new InputStreamReader(System.in));
        String text = input.readLine();
        int n = Integer.parseInt(input.readLine());
        String[] s = new String[n];
        int[] ans = new int[n];
        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            s[i] = input.readLine();
            ans[i] = computeLPSArray(s[i].toLowerCase() + text.toLowerCase());
            if (ans[i] > max) {
                max = ans[i];
            }
            max = Math.max(ans[i], max);
        }

        for (int an : ans) {
            if (an == max) cnt++;
        }

        if (max == 0) System.out.println(0);
        else {
            System.out.println(cnt);
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] == max) System.out.println(s[i]);
            }
        }

    }
}