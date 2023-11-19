package lab9;

import java.util.Arrays;

public class KMP {
    public static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // Length of the previous longest prefix suffix
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

    public static void search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPSArray(pattern);

        int i = 0; // Index for traversing the text
        int j = 0; // Index for traversing the pattern

        while (i < n) {
            if (pattern.charAt(j) != text.charAt(i)) {
                if (j > 0) j = lps[j - 1];
                else i++;
            } else {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(computeLPSArray("janjaa")));
    }
}
