package lab7;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
    public static String[] merge(String[] array1, String[] array2) {
        String[] combined = new String[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i].length() <= array2[j].length()) {
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
    public static String[] mergeSort(String[] array){
        if(array.length <= 1) return array;

        int midIndex = array.length / 2;
        String[] left = mergeSort(Arrays.copyOfRange(array,0,midIndex));
        String[] right = mergeSort(Arrays.copyOfRange(array,midIndex,array.length));

        return merge(left,right);
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(String st : mergeSort(s)){
                bw.write(st + " ");
            }
            bw.newLine();
        }
        bw.close();
    }
}
