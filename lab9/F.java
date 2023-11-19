package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class F {
    static List<Integer> list = new ArrayList<>();
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
    public static void search(String text, String pattern) {
        int cnt = 0;
        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPSArray(pattern);

        int i = 0
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
                list.add((i - j) + 1);
                j = lps[j - 1];
            }

        }
    }
    public static void main(String[] args) throws IOException {
        var input = new BufferedReader(new InputStreamReader(System.in));
        var text = input.readLine();
        var pattern = input.readLine();

        search(text,pattern);
        System.out.println(list.size());
        for(int i : list){
            System.out.print(i + " ");
        }
    }
}
