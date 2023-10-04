package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n;i++){
            array[i] = scan.nextInt();
        }
        int target = scan.nextInt();
        System.out.println(binarySearch(array,target)== -1 ? "No" : "Yes");
    }
    public static int binarySearch(int[] array, int search) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == search) {
                return mid;
            } else if (search < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
