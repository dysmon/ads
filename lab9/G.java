package lab9;

import java.util.Arrays;
import java.util.Scanner;

public class G {
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

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        String a = input.nextLine();
        int[] lsp = computeLPSArray(a);
        System.out.println(Arrays.toString(lsp));
        System.out.println(lsp.length - lsp[lsp.length - 1]);
    }
}
