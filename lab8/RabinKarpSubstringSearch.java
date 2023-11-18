package lab8;

public class RabinKarpSubstringSearch {
    private static final int PRIME = 101; // A prime number
    private static final int ALPHABET_SIZE = 256; // Number of characters in the ASCII alphabet

    public static void rabinKarp(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();
        int patternHash = 0;
        int textHash = 0;
        int h = 1;

        // Calculate h: ALPHABET_SIZE^(patternLength - 1) % PRIME
        for (int i = 0; i < patternLength - 1; i++) {
            h = (h * ALPHABET_SIZE) % PRIME;
        }

        // Calculate initial hash values for pattern and the first window of text
        for (int i = 0; i < patternLength; i++) {
            patternHash = (ALPHABET_SIZE * patternHash + pattern.charAt(i)) % PRIME;
            textHash = (ALPHABET_SIZE * textHash + text.charAt(i)) % PRIME;
        }

        // Slide the pattern over the text and check for matches
        for (int i = 0; i <= textLength - patternLength; i++) {
            // If hash values match, compare characters one by one
            if (patternHash == textHash) {
                boolean found = true;
                for (int j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate hash value for the next window of text: remove leftmost character and add new character
            if (i < textLength - patternLength) {
                textHash = (ALPHABET_SIZE * (textHash - text.charAt(i) * h) + text.charAt(i + patternLength)) % PRIME;

                // Make sure the hash value is non-negative
                if (textHash < 0) {
                    textHash += PRIME;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABCABABABABABA";
        String pattern = "ABABA";
        rabinKarp(text, pattern);
    }
}