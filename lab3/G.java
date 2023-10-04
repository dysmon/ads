package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long f = scan.nextLong();
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(binarySearch(arr,f));

    }

    public static long binarySearch(int[] arr, long f) {
        long left = 1;
        long right = arr[arr.length - 1];
        while (left < right) {
            long sum = 0;
            long mid = left + (right - left) / 2;
            for(int i : arr){
                sum += Math.ceil((double) i / mid);
            }
            if (sum <= f) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

