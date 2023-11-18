package lab8;

import java.io.*;

public class B {
    private static final int PRIME = 101;
    private static final int ALPHABET_SIZE = 256;

    public static int rabinKarp(String text1, String text2, String pattern) {
        int patternLength = pattern.length();
        int textLength = text1.length();
        int patternHash = 0;
        int textHash = 0, textHash2 = 0;
        int h = 1;
        int cnt = 0;

        for (int i = 0; i < patternLength - 1; i++) {
            h = (h * ALPHABET_SIZE) % PRIME;
        }

        for (int i = 0; i < patternLength; i++) {
            patternHash = (ALPHABET_SIZE * patternHash + pattern.charAt(i)) % PRIME;
            textHash = (ALPHABET_SIZE * textHash + text1.charAt(i)) % PRIME;
            textHash2 = (ALPHABET_SIZE * textHash2 + text2.charAt(i)) % PRIME;
        }

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash && patternHash == textHash2) {
                    cnt++;
            }

            if (i < textLength - patternLength) {
                textHash = (ALPHABET_SIZE * (textHash - text1.charAt(i) * h) + text1.charAt(i + patternLength)) % PRIME;
                textHash2 = (ALPHABET_SIZE * (textHash2 - text2.charAt(i) * h) + text2.charAt(i + patternLength)) % PRIME;

                if (textHash < 0) {
                    textHash += PRIME;
                }
                if (textHash2 < 0) {
                    textHash2 += PRIME;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String text1 = br.readLine();
        String text2 = br.readLine();
        String pattern = br.readLine();

        System.out.println(rabinKarp(text1, text2, pattern));

    }
}