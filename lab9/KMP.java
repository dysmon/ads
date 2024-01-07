package lab9;
public class KMP {
    public static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] array = new int[m];
        int k = 0;

        for (int q = 1; q < m; q++) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(q)) {
                k = array[k - 1];
            }
            if (pattern.charAt(k) == pattern.charAt(q)) {
                k = k + 1;
            }
            array[q] = k;
        }

        return array;
    }

    public static void search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = computeLPSArray(pattern);
        int q = 0;

        for (int i = 0; i < n; i++) {
            while (q > 0 && text.charAt(i) != pattern.charAt(q)) {
                q = lps[q - 1];
            }

            if (pattern.charAt(q) == text.charAt(i)) {
                q++;
            }

            if (q == m) {
                System.out.println("Pattern found at index " + (i - m + 1));
                q = lps[q - 1];
            }
        }
    }

    public static void main(String[] args) {
        String text = "ababcababcabcabc";
        String pattern = "ababc";

        search(text, pattern);
    }
}
