package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
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
        int cnt = 0;
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
                cnt++;
                j = lps[j - 1];
            }

        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        var input = new BufferedReader(new InputStreamReader(System.in));
        var token = new StringTokenizer(input.readLine());
        var pattern = token.nextToken();
        int n = Integer.parseInt(token.nextToken());
        var text = input.readLine();

        System.out.println(search(text,pattern) < n ? "NO" : "YES");
    }
}
