package lab3;

import java.io.*;
import java.util.StringTokenizer;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int toFind;

    static int[] target;
    static String[] answer;

    public static void main(String[] args) throws IOException {;
        toFind = Integer.parseInt(br.readLine());
        target = new int[toFind];
        answer = new String[toFind];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < toFind; i++) {
            target[i] = Integer.parseInt(st.nextToken());
            answer[i] = "-1";
        }

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            solution(arr, i);
        }
        for(int i = 0; i < answer.length;i++){
            System.out.println(answer[i]);;
        }
    }

    public static void solution(int[] arr, int index) {
        for (int i = 0; i < toFind; i++) {
            int found = -1;
            if (target[i] >= arr[arr.length - 1] && index % 2 == 0) {
                found = reversedBinarySearch(arr, target[i]);
            } else if (target[i] >= arr[0] && index % 2 == 1) {
                found = binarySearch(arr, target[i]);
            }
            if (found != -1) {
                answer[i] = index + " " + found;
            }
        }
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int reversedBinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
