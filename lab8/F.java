package lab8;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class F {
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

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        String text = scan.nextLine();
        int patternHash = 0;
        int textHash = 0;
        int h = 0;

        for (int i = 0; i < text.length() - 1; i++) {
            h = (h * ALPHABET_SIZE) % PRIME;
        }
    }
}
