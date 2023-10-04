package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int h = scan.nextInt();

        var arr = new int[n];

        for(int i = 0; i < n;i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(arr,h));
    }
    public static int binarySearch(int[] array, int search) {
        int left = 1;
        int right = array[array.length - 1];

        while (left < right) {
            int sum = 0;
            int mid = left + (right - left) / 2;

            for(int i : array){
                sum += Math.ceil( (double) i / mid);
            }
            if(sum > search){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }
}
