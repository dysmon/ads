package lab7;

import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                combined[index] = array2[j];
                index++;
                j++;
            }
        }
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }
        return combined;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        var st = new StringTokenizer(br.readLine());
        var array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = Integer.parseInt(st.nextToken());
        }

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        var array2 = new int[n];
        for (int i = 0; i < n; i++) {
            array2[i] = Integer.parseInt(st.nextToken());
        }
        var merged = merge(array1, array2);

        for (int i : merged) bw.write(i + " ");
        bw.close();
    }
}
