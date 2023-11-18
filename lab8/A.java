package lab8;

import java.io.*;
import java.util.LinkedHashSet;

public class A {
    static long mod = 1000000007L;

    public static void main(String[] args) throws IOException {
        var set = new LinkedHashSet<String>();
        var scan = new BufferedReader(new InputStreamReader(System.in));
        var wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(scan.readLine());
        String[][] array = new String[2 * n][2];
        for (int i = 0; i < n * 2; i++) {
            String cur = scan.readLine();
            set.add(cur);
            array[i][0] = cur;
            array[i][1] = hash(cur);
        }


        int cnt = 0;
        for(int i = 0; i < n * 2; i++){
            if(set.contains(array[i][1])){
                wr.write(String.format("Hash of string \"%s\" is %s\n",array[i][0],array[i][1]));
                cnt++;
            }
            if(cnt == n) break;
        }
        wr.close();
        scan.close();
    }

    public static String hash(String s){
        long h = 0;
        for(int i = s.length() - 1; i >= 0;i--){
            h = (h * 11 % mod + (s.charAt(i) - 47)) % mod;
        }
        return String.valueOf(h);
    }
}