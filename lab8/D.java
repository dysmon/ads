package lab8;

import java.io.*;

public class D {
    private static final int PRIME = 101;
    private static final int ALPHABET_SIZE = 256;

    public static int rabinKarp(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();
        int patternHash = 0;
        int textHash = 0;
        int h = 1;
        int cnt = 0;

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
                    cnt++;
                }
            }

            if (i < textLength - patternLength) {
                textHash = (ALPHABET_SIZE * (textHash - text.charAt(i) * h) + text.charAt(i + patternLength)) % PRIME;

                if (textHash < 0) {
                    textHash += PRIME;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            String[][] array = new String[n][2];
            if (n == 0) break;
            int max = 0;
            for (int i = 0; i < n; i++) {
                array[i][0] = br.readLine();
                array[i][1] = "0";
            }
            String text = br.readLine();
            for (int i = 0; i < n; i++) {
                String pattern = array[i][0];
                int current = rabinKarp(text, pattern);
                if (current >= max) {
                    max = current;
                    array[i][1] = max + "";
                }
            }
            System.out.println(max);
            for (int i = 0; i < n; i++) {
                if(Integer.parseInt(array[i][1]) == max) System.out.println(array[i][0]);
            }
        }
    }
}
