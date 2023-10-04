package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] competitors = new int[n];

        for(int i = 0; i < n; i++){
            competitors[i] = scan.nextInt();
        }

        Arrays.sort(competitors);

        n = scan.nextInt();

        for(int round = 0; round < n;round++){
            int markPower = scan.nextInt();

            int victories = binarySearch(competitors,markPower);
            int powerSum = 0;
            for(int i = 0; i < victories;i++){
                powerSum += competitors[i];
            }
            System.out.println(victories + " " + powerSum);
        }
        scan.close();
    }

    private static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        int victories = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(target >= arr[mid]){
                victories = mid + 1;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return victories;
    }
}
