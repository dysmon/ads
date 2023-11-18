package lab8;

import java.util.HashSet;
import java.util.Scanner;

public class G {
    static long mod = 9007199254740881L;
    static long pre;
    static long D = 97;

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder (new Scanner(System.in).nextLine());
        HashSet<Long> d = new HashSet<>();

        for (int j = 0; j < s.length(); j++) {
            pre = 0;

            for (int k = j; k < s.length(); k++) {
                pre = (pre * D + s.charAt(k)) % mod;

                d.add(pre);
            }
        }

        System.out.println(d.size());
    }
}

