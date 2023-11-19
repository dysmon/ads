package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {
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

    public static void main(String[] args) throws IOException {
        var input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        for (int i = 0; i < n; i++) {
            var token = new StringTokenizer(input.readLine());
            String s = token.nextToken();
            int[] lsp = computeLPSArray(s);
            int freq = Integer.parseInt(token.nextToken());
            int prefix = lsp[lsp.length - 1];
            int root = lsp.length - prefix;

            if (prefix == 0) System.out.println(root * freq);
            else System.out.println(prefix + freq * root);
        }
    }
}
