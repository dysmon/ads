package lab9;

import java.util.Scanner;

public class C {
    public static int[] computeLPSArray(String pattern) {
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

    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPSArray(pattern);

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
                return i - j;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        String a = input.nextLine();
        String pattern = input.nextLine();
        a += a;
        int found = search(a, pattern);
        if (found == -1 || found >= pattern.length()) System.out.println(-1);
        else System.out.println(a.length() - pattern.length() - found);
    }
}
