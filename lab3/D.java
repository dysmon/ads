package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int query = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < query; i++) {
            int l1 = scan.nextInt();
            int r1 = scan.nextInt();
            int l2 = scan.nextInt();
            int r2 = scan.nextInt();

            boolean isIntersaction = Math.max(l1,l2) <= Math.min(r1,r2);
            if (isIntersaction) {
                System.out.println(binarySearch(arr, Math.max(r1,r2),false) - binarySearch(arr, Math.min(l1,l2),true) + 1);
            } else {
                System.out.println((binarySearch(arr, r2,false) - binarySearch(arr, l2,true)) +
                        (binarySearch(arr, r1,false) - binarySearch(arr, l1,true)) + 2);
            }
        }
    }

    private static int binarySearch(int[] arr, int target,boolean isLeft) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(isLeft) return left;
        else return right;
    }
}
