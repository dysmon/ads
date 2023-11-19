package lab9;

import java.util.Arrays;
import java.util.Scanner;

public class H {
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
        String s = new Scanner(System.in).nextLine();
        int[] lsp = computeLPSArray(s);
        int cnt = 0;

        for (int i = 1; i < lsp.length; i++) {
            if (i % 2 == 0) {
                int k = i - lsp[i - 1];
                if(i / k % 2 == 0){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
//        System.out.println(Arrays.toString(lsp));
    }
}
