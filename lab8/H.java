import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
    private static final int PRIME = 101;
    private static final int ALPHABET_SIZE = 256;

    public static boolean rabinKarp(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();
        int patternHash = 0;
        int textHash = 0;
        int h = 1;

        for (int i = 0; i < patternLength - 1; i++) {
            h = (h * ALPHABET_SIZE) % PRIME;
        }

        for (int i = 0; i < patternLength; i++) {
            patternHash = (ALPHABET_SIZE * patternHash + pattern.charAt(i)) % PRIME;
            textHash = (ALPHABET_SIZE * textHash + text.charAt(i)) % PRIME;
        }

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash) {
                boolean found = true;
                for (int j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
            if (i < textLength - patternLength) {
                textHash = (ALPHABET_SIZE * (textHash - text.charAt(i) * h) + text.charAt(i + patternLength)) % PRIME;
                if (textHash < 0) {
                    textHash += PRIME;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var array = new String[n];
        int minSize = Integer.MAX_VALUE;
        String minStr = "";
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (minSize > s.length()) {
                minSize = s.length();
                minStr = s;
            }
            array[i] = s;
        }
        int maxSize = 0;
        String res = "";
        for (int i = 0; i < minSize; i++) {
            for (int j = i; j < minSize; j++) {
                String sub = minStr.substring(i, j+1);
                boolean ok = true;
                for (int k = 0; k < n; k++) {
                    if (!rabinKarp(array[k], sub)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    if (maxSize < sub.length()) {
                        maxSize = sub.length();
                        res = sub;
                    }
                }
            }
        }
        System.out.println(res);

    }
}
