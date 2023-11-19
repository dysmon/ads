package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static int[] computeLPSArray(StringBuilder pattern) {
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
        return lps;
    }

    public static boolean search(StringBuilder text, StringBuilder pattern, int[] lps) {
        int n = text.length();
        int m = pattern.length();

        int i = 0;
        int j = 0;

        while (i < n) {
            if (pattern.charAt(j) != text.charAt(i)) {
                if (j > 0) j = lps[j - 1];
                else i++;
            } else {
                i++;
                j++;
            }
            if (j == m) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        var input = new BufferedReader(new InputStreamReader(System.in));
        var text = new StringBuilder(input.readLine());
        StringBuilder pattern = new StringBuilder(input.readLine());
        var repString = new StringBuilder(text);

        int[] lps = computeLPSArray(pattern);

        if (text.length() > pattern.length() && search(text, pattern, lps)) {
            System.out.println(1);
            return;
        }

        int i = text.length(), j = pattern.length(), cnt = 1;

        while (i < j) {
            text.append(repString);
            i = text.length();
            cnt++;
        }

        if (search(text, pattern, lps)) {
            System.out.println(cnt);
        } else if (search(text.append(repString), pattern, lps)) {
            System.out.println(cnt + 1);
        } else {
            System.out.println(-1);
        }

        input.close();
    }
}
