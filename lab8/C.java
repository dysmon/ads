package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class C {
    static HashSet<Long> set = new HashSet<>();
    static final long ALPHABET_SIZE = 256;
    static final long PRIME = 9007199254740881L;
    static long maxSize = 0;

    public static boolean rabinKarp(String text) {
        long textHash = 0;
        int cnt = 0;
        int foundSize = Integer.MAX_VALUE;

        for (int j = 0; j < text.length(); j++) {
            textHash = 0;
            boolean found = false;
            for (int k = j; k < maxSize + j && k < text.length(); k++) {
                textHash = (textHash * ALPHABET_SIZE + text.charAt(k)) % PRIME;
                if (set.contains(textHash)) {
                    cnt = 0;
                    foundSize = k - j;
                    found = true;
                }
            }
            if (!found){
                cnt++;
            }
            if(cnt > foundSize || (!found && j == 0)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String pattern = br.readLine();
            maxSize = Math.max(maxSize, pattern.length());
            long hash = 0;
            for (int j = 0; j < pattern.length(); j++) {
                hash = (ALPHABET_SIZE * hash + pattern.charAt(j)) % PRIME;
            }
            set.add(hash);
        }

        System.out.println(rabinKarp(text) ? "YES" : "NO");
    }
}
